package com.dsa.algorithms;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.GetResponse;
import com.dsa.algorithms.domain.java.Animal;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.awaitility.Awaitility;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.web.servlet.MockMvc;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ControllerIntegrationTest extends IntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ElasticsearchClient esClient;

    @Value("${ci-coverage.es.index}")
    private String ciCoverageIndex;

    @Value("${spring.kafka.template.default-topic}")
    private String kafkaTopic;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private Consumer<String, Animal> kafkaConsumer;

    @Test
    void publishAnimal() throws Exception {
        mockMvc.perform(post("/animals")).andDo(print()).andExpect(status().isOk());

        Awaitility.await()
                .atMost(Duration.ofSeconds(5))
                .pollDelay(Duration.ofMillis(100))
                .ignoreExceptions()
                .until(() -> esClient.count().count() > 0);

        GetResponse<Animal> ciCoverageData =
                esClient.get(g -> g.index(ciCoverageIndex).id("tcin1_" + LocalDate.now()), Animal.class);

        String result =
                """
                        {
                            "animal": "Lion"
                        }
                        """;

        assertThat(ciCoverageData.source())
                .usingRecursiveComparison()
                .ignoringFields("timestamp")
                .isEqualTo(objectMapper.readValue(result, Animal.class));
    }

    @Test
    void publishScheduledSlaBreaches() throws Exception {
        mockMvc.perform(post("/animal"))
                .andDo(print())
                .andExpect(status().isOk());

        Animal kafkaOutput = objectMapper.readValue(
                """
                    {
                      "animal": "Lion"
                      }
                    }
                """,
                Animal.class);

        kafkaConsumer.subscribe(Collections.singletonList(kafkaTopic));

        AtomicReference<ConsumerRecords<String, Animal>> records = new AtomicReference<>();
        Awaitility.await().atMost(5, TimeUnit.SECONDS).until(() -> {
            records.set(kafkaConsumer.poll(Duration.ofMillis(100)));
            return !records.get().isEmpty();
        });

        assertThat(records.get().count()).isEqualTo(1);
        records.get().records(kafkaTopic).forEach(message -> assertThat(message.value())
                .usingRecursiveComparison()
                .ignoringFields("publishTs", "dsbSlaBreach.daysSinceLastSignal")
                .isEqualTo(kafkaOutput));

        assertTrue(greenMail.waitForIncomingEmail(5000, 1));
        assertThat(greenMail.getReceivedMessagesForDomain("sripreethip07@gmail.com").length)
                .isEqualTo(1);
        MimeMessage receivedMessage = greenMail.getReceivedMessagesForDomain("sripreethip07@gmail.com")[0];
        InternetAddress from = (InternetAddress) (receivedMessage.getFrom()[0]);
        assertThat(from.getAddress()).isEqualTo("sripreethip07@gmail.com");
        assertThat(receivedMessage.getSubject()).isEqualTo("Weekly Lost signal reporting (Stores) [test]");
        assertThat(((MimeMultipart) receivedMessage.getContent()).getBodyPart(1).getFileName())
                .isEqualTo("Weekly SLA breached items.csv");
    }
}
