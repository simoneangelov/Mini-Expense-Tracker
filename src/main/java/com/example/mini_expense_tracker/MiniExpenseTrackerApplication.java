package com.example.mini_expense_tracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Entry point for the Spring Boot application! This is where the 'main' method is located.
// When the application starts, it will run the 'main' method in this class.

@SpringBootApplication
public class MiniExpenseTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiniExpenseTrackerApplication.class, args);
	}

}
