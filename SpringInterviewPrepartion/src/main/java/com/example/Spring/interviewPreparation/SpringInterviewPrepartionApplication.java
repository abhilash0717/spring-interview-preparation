package com.example.Spring.interviewPreparation;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringInterviewPrepartionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringInterviewPrepartionApplication.class, args);
	}
	
	 @Bean
	 public ModelMapper modelMapper() {
	     return new ModelMapper();
	 }
}
