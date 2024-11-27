package com.dsa.algorithms.client;

import com.dsa.algorithms.domain.java.Animal;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.micrometer.core.instrument.MeterRegistry;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Component
public class KafkaTemplateRepository {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper().registerModule(new JavaTimeModule());
    private final MeterRegistry meterRegistry;
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final RestClientRepository restClientRepository;

    public KafkaTemplateRepository(MeterRegistry meterRegistry, KafkaTemplate<String, String> kafkaTemplate, RestClientRepository restClientRepository) {
        this.meterRegistry = meterRegistry;
        this.kafkaTemplate = kafkaTemplate;
        this.restClientRepository = restClientRepository;
    }

    private void publish(
            Animal animal, String topic, String successCounterMetric, String failureCounterMetric) {
        try {
            String eventString = OBJECT_MAPPER.writeValueAsString(animal);
            ProducerRecord<String, String> producerRecord =
                    new ProducerRecord<>(topic, animal.getName(), eventString);
            CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send(producerRecord);
            future.whenComplete((result, ex) -> {
                if (ex == null) {
                    log.debug(
                            "Sent message=[{}] with offset=[{}]",
                            animal,
                            result.getRecordMetadata().offset());

                    meterRegistry.counter(successCounterMetric).increment();
                } else {
                    log.error("Unable to send message=[{}] due to : {}", animal.getName(), ex.getMessage());
                    meterRegistry.counter(failureCounterMetric).increment();
                }
            });
        } catch (JsonProcessingException e) {
            log.error("Unable to parse message=[{}] due to : {}", animal.getName(), e.getMessage());
            meterRegistry.counter(failureCounterMetric).increment();
            throw new RuntimeException(e);
        }
    }

    @KafkaListener(topics = "${newton-consumer.kafka.topic}")
    public void listen(@Payload @Valid ConsumerRecord<String, Animal> record, Acknowledgment acknowledgment)
            throws JsonProcessingException {

        if (record.value() != null) {
            log.info("Message read from ANIMAL kafka for name: {}}", record.value().getName());
            restClientRepository.addAnimal(record.value());
            meterRegistry.counter("KAFKA_CONSUMPTION_COUNT").increment();
        } else {
            log.warn("Kafka Message is null");
            meterRegistry.counter("KAFKA_NULL_MSG_COUNT").increment();
        }
        acknowledgment.acknowledge();
    }
}
