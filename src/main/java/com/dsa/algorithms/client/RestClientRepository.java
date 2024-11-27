package com.dsa.algorithms.client;

import com.dsa.algorithms.domain.java.Animal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;

@Slf4j
@Repository
public class RestClientRepository {
    private final RestClient restClient;
    private static final String POST_ANIMAL_URL_PATH = "/animals";

    public RestClientRepository() {
        this.restClient = RestClient.builder().baseUrl("https://host.com").build();
    }

    @Retryable(maxAttempts = 5, retryFor = HttpServerErrorException.class, backoff = @Backoff(delay = 100))
    public Animal getAnimalByName(String animalName) {
        try {
            return restClient
                    .get()
                    .uri("/animals/{animalName}", animalName)
                    .retrieve()
                    .body(Animal.class);
        } catch (HttpClientErrorException.NotFound e) {
            log.error("No animal found by name: {}", animalName, e);
            return null;
        }
    }

    @Retryable(maxAttempts = 5, retryFor = HttpServerErrorException.class, backoff = @Backoff(delay = 100))
    public Animal addAnimal(Animal animal) {
        try {
            return restClient
                    .post()
                    .uri(uri -> uri.path(POST_ANIMAL_URL_PATH).build())
                    .body(animal)
                    .retrieve()
                    .body(Animal.class);
        } catch (RestClientException e) {
            log.error("Error adding new Animal: {}", e.getMessage());
            throw new RuntimeException("Failed to add a new animal", e);
        }
    }
}
