package com.example.demo;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
public class FirstStsProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstStsProjectApplication.class, args);	
	}

    @Bean
    ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
