package com.aleedev.SecuityCheck;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SecuityCheckApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecuityCheckApplication.class, args);
	}
}
