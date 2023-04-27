package com.example.graalvmhelloworld;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GraalvmHelloworldApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraalvmHelloworldApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			System.out.println("Hello World!");
		};
	}

}
