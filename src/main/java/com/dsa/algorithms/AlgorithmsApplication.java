package com.dsa.algorithms;

import com.dsa.algorithms.domain.java.CustomThread;
import com.dsa.algorithms.domain.java.CustomThreadRunnable;
import com.dsa.algorithms.domain.java.DaemonThread;
import com.dsa.algorithms.domain.java.UserThread;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication (exclude = DataSourceAutoConfiguration.class)
public class AlgorithmsApplication {

	public static void main(String[] args) {

		SpringApplication.run(AlgorithmsApplication.class, args);
		CustomThread thread = new CustomThread();

		CustomThreadRunnable customThreadRunnable = new CustomThreadRunnable();
		Thread threadRunnable = new Thread(customThreadRunnable);
		thread.start();
		threadRunnable.start();

	}

}
