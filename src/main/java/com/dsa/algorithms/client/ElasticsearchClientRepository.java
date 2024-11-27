package com.dsa.algorithms.client;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.*;
import co.elastic.clients.elasticsearch._types.aggregations.Aggregation;
import co.elastic.clients.elasticsearch._types.aggregations.TermsAggregation;
import co.elastic.clients.elasticsearch._types.query_dsl.*;
import co.elastic.clients.elasticsearch.core.*;
import co.elastic.clients.elasticsearch.core.search.Hit;
import com.dsa.algorithms.domain.java.Animal;
import io.micrometer.common.util.StringUtils;
import io.reactivex.Observable;
import io.reactivex.Single;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static co.elastic.clients.elasticsearch._types.SortOrder.Desc;

@Slf4j
@Repository
public class ElasticsearchClientRepository {

    private final ElasticsearchClient client;

    public ElasticsearchClientRepository(ElasticsearchClient client) {
        this.client = client;
    }

    public Single<String> getLatestIndex() {
        return Single.create(emitter -> {
            try {
                SearchRequest searchRequest = new SearchRequest.Builder()
                        .index("elastic-index")
                        .scroll(Time.of(t -> t.time("1m")))
                        .size(10)
                        .sort(Collections.singletonList(new SortOptions.Builder()
                                .field(f -> f.field("PUBLISH_DATE_FIELD").order(Desc)).build()))
                        .build();

                SearchResponse<Void> searchResponse = client.search(searchRequest, Void.class);

                if (!searchResponse.hits().hits().isEmpty()) {
                    emitter.onSuccess(searchResponse.hits().hits().get(0).index());
                } else {
                    log.warn("no index found ...");
                }

            } catch (Exception e) {
                log.error("exception occurred while fetching scroll for ShoplistMetadata", e);
                emitter.onError(e);
            }
        });
    }

    public Observable<Animal> search(final Animal animal) {

        return Observable.create(emitter -> {
            try {
                String index = getLatestIndex().blockingGet();
                if (StringUtils.isNotBlank(index)) {
                    SearchRequest searchRequest = new SearchRequest.Builder()
                            .index(index)
                            .size(10)
                            .query(createSearchQuery(animal))
                            .scroll(Time.of(t -> t.time("1m"))).build();

                    SearchResponse<Animal> searchResponse = client.search(searchRequest, Animal.class);
                    while (searchResponse.hits().hits().size() > 0) {
                        for (Hit<Animal> hit : searchResponse.hits().hits()) {
                            Animal shoplistMetadataSearch = hit.source();
                            emitter.onNext(Objects.requireNonNull(shoplistMetadataSearch));
                        }

                        ScrollRequest scrollRequest = new ScrollRequest.Builder()
                                .scrollId(searchResponse.scrollId())
                                .scroll(Time.of(t -> t.time("30s"))).build();

                        ScrollResponse<Animal> scrollResponse = client.scroll(scrollRequest, Animal.class);

                        searchResponse = new SearchResponse.Builder<Animal>()
                                .scrollId(scrollResponse.scrollId())
                                .took(scrollResponse.took())
                                .timedOut(scrollResponse.timedOut())
                                .shards(scrollResponse.shards())
                                .hits(scrollResponse.hits())
                                .maxScore(scrollResponse.maxScore())
                                .aggregations(scrollResponse.aggregations())
                                .clusters(scrollResponse.clusters())
                                .fields(scrollResponse.fields())
                                .numReducePhases(scrollResponse.numReducePhases())
                                .profile(scrollResponse.profile())
                                .pitId(scrollResponse.pitId())
                                .suggest(scrollResponse.suggest())
                                .terminatedEarly(scrollResponse.terminatedEarly()).build();
                    }
                    ClearScrollRequest request = new ClearScrollRequest.Builder()
                            .scrollId(Collections.singletonList(searchResponse.scrollId())).build();

                    client.clearScroll(request);
                }
            } catch (Exception e) {
                log.error("error while searching shoplistmetadata ", e);
                emitter.onError(e);
            } finally {
                emitter.onComplete();
            }
        });
    }


    public Query createSearchQuery(Animal animal) {

        BoolQuery.Builder boolQuery = QueryBuilders.bool();
        if (!animal.getName().isEmpty()) {
            boolQuery.must(new TermsQuery.Builder()
                    .field("NAME")
                    .terms(new TermsQueryField.Builder()
                            .value(Stream.of(animal.getName().toCharArray())
                                    .map(FieldValue::of).collect(Collectors.toList())).build()).build()._toQuery());
        }
        return boolQuery.build()._toQuery();
    }

    private Aggregation createAggregation(String idField, String nameField) {
        return new Aggregation.Builder().terms(new TermsAggregation.Builder()
                .script(Script.of(s -> s.inline(InlineScript.of(i -> i
                        .source("doc['" + idField + "'].value + " + " ':' + doc['" + nameField + "'].value")
                        .lang("painless"))))).size(Integer.MAX_VALUE).build()).build();
    }
}
