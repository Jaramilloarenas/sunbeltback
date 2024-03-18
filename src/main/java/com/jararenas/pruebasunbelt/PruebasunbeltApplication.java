package com.jararenas.pruebasunbelt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class PruebasunbeltApplication extends SpringBootServletInitializer{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(PruebasunbeltApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(PruebasunbeltApplication.class, args);
	}

}
