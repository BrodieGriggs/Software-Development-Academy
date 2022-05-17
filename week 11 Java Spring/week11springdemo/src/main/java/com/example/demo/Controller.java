package com.example.demo;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	@GetMapping("/helloworld")
	public String hello() {
		return "Hello World!";
	}
	
	@GetMapping("/demonstrate_values")
	public String acceptingValues(@RequestParam(value="user_name") String name) {
		return "Hello " + name;
	}
	
	private AtomicLong id_counter = new AtomicLong();
	
	@GetMapping("/user")
	public Users userData(@RequestParam(value="user_name") String name) {
		return new Users(id_counter.incrementAndGet(), name);
	}
	
	@GetMapping("/Multiply/{num1}/{num2}")
	public long multiply(@PathVariable long num1, @PathVariable long num2) {
		return num1 * num2;
	}
}
