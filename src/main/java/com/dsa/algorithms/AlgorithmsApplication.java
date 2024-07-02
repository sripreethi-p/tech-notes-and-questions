package com.dsa.algorithms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication (exclude = DataSourceAutoConfiguration.class)
public class AlgorithmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlgorithmsApplication.class, args);
	}

}
