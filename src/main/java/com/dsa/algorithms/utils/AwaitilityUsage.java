package com.dsa.algorithms.utils;

import com.dsa.algorithms.client.RestClientRepository;
import com.dsa.algorithms.domain.java.Animal;
import lombok.extern.slf4j.Slf4j;
import org.awaitility.Awaitility;
import org.springframework.stereotype.Component;

import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class AwaitilityUsage {

    private final RestClientRepository restClientRepository;

    public AwaitilityUsage(RestClientRepository restClientRepository) {
        this.restClientRepository = restClientRepository;
    }

    public Animal usingAwaitility(Animal animal) throws URISyntaxException {

        log.info("Downloading Engage3Report");
        log.info("Created animal - {}", animal.getName());
        Awaitility.await()
                .atMost(1, TimeUnit.MINUTES)
                .pollInterval(5, TimeUnit.SECONDS)
                .until(() -> "lion".equalsIgnoreCase(animal.getName()));
        return restClientRepository.addAnimal(animal);
    }
}
