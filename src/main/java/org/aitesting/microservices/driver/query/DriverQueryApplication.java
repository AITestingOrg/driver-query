package org.aitesting.microservices.driver.query;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.annotation.Retryable;

@EnableRetry
@SpringBootApplication
public class DriverQueryApplication {
	@Retryable(value = IllegalArgumentException.class, maxAttempts = 5)
	public static void main(String[] args) {
		SpringApplication.run(DriverQueryApplication.class, args);
	}
}
