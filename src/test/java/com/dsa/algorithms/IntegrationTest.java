package com.dsa.algorithms;

import com.github.tomakehurst.wiremock.extension.responsetemplating.ResponseTemplateTransformer;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.ServerSetupTest;
import org.junit.ClassRule;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.cloud.contract.wiremock.WireMockSpring;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.elasticsearch.ElasticsearchContainer;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.kafka.KafkaContainer;
import org.testcontainers.utility.DockerImageName;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
@AutoConfigureWireMock(port = 0)
public abstract class IntegrationTest {

    public static MongoDBContainer mongoDbContainer;
    public static ElasticsearchContainer elasticsearchContainer;
    public static KafkaContainer kafkaContainer;
    public static GreenMail greenMail;

    @ClassRule
    public static WireMockRule wm =
            new WireMockRule(WireMockSpring.options().extensions(new ResponseTemplateTransformer(true)));

    static {
        if (isLocalRun()) {

            mongoDbContainer = new MongoDBContainer("mongo:7.0.4");
            mongoDbContainer.start();

            elasticsearchContainer = new ElasticsearchContainer(DockerImageName.parse("elasticsearch:8.10.4"));
            elasticsearchContainer.withEnv("xpack.security.enabled", "false");
            elasticsearchContainer.start();

            kafkaContainer = new KafkaContainer(DockerImageName.parse("apache/kafka:3.8.0"));
            kafkaContainer.start();
        }

        greenMail = new GreenMail(ServerSetupTest.SMTP.dynamicPort());
        greenMail.start();
    }

    @DynamicPropertySource
    public static void testContainerProperties(DynamicPropertyRegistry dynamicPropertyRegistry) {
        if (isLocalRun()) {

            dynamicPropertyRegistry.add("spring.data.mongodb.uri", mongoDbContainer::getReplicaSetUrl);

            dynamicPropertyRegistry.add("spring.elasticsearch.uris", () -> elasticsearchContainer.getHttpHostAddress());
            dynamicPropertyRegistry.add("spring.kafka.bootstrap-servers", () -> kafkaContainer.getBootstrapServers());
        }
        dynamicPropertyRegistry.add(
                "spring.mail.host", () -> greenMail.getSmtp().getServerSetup().getBindAddress());
        dynamicPropertyRegistry.add(
                "spring.mail.port", () -> greenMail.getSmtp().getServerSetup().getPort());
    }

    public static boolean isLocalRun() {
        return !System.getenv().containsKey("CI");
    }
}
