package com.microservices.currencyexchangeservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircutBreakerController {
	
	private Logger logger = LoggerFactory.getLogger(CircutBreakerController.class);
	@GetMapping("/sample-api")
//	@Retry(name = "sample-api", fallbackMethod = "hardCodedResponse")
	@CircuitBreaker(name = "default", fallbackMethod = "hardCodedResponse")
	@RateLimiter(name="default")
	@Bulkhead(name="default")
	public String smapleApi() {
		logger.info("Sample APi call received");
		new RestTemplate().getForEntity("http://localhost:8080/some-dummy-url",
				String.class);
		return "Sample API";
	}
	
	public String hardCodedResponse(Exception ex) {
		return "fallback-response";
	}
}
