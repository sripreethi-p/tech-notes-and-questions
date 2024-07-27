package com.dsa.algorithms.repository;

import com.dsa.algorithms.domain.clusterprofile.TgtGroup;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;

@Slf4j
@Repository
public class ClusterProfileRepository {
    private final RestClient restClient;

    public ClusterProfileRepository() {
        this.restClient = RestClient.builder().baseUrl("https://clusterprofileservice-stage.prod.target.com/cluster-profile-service/v1").build();
    }

    public TgtGroup getTgtGroupById(String tgtGroupId) {

        try {
            return restClient
                    .get()
                    .uri("/tgtgroups/{tgtGroupId}", tgtGroupId)
                    .retrieve()
                    .body(TgtGroup.class);
        } catch (HttpClientErrorException.NotFound e) {
            log.error("Error getting tgt group by id: " + tgtGroupId, e);
            return null;
        }
    }
}
