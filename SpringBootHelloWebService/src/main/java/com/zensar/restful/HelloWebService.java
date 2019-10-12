package com.zensar.restful;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWebService {
	@GetMapping("/hello")
	public String sayHello() {
		return "Welcome to Zensar Restful Service";
	}
}
