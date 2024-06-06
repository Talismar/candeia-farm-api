package com.talismar.candeia_farm_api;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class CandeiaFarmApiApplication implements CommandLineRunner  {

	public static void main(String[] args) {
		SpringApplication.run(CandeiaFarmApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Startup application");
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*").allowedHeaders("*").allowedMethods("*");
			}
		};
	}
}
