package com.banco.math.demo;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.convert.Jsr310Converters;

@SpringBootApplication
@ComponentScan({ "com.banco.math.demo.*" })
@EntityScan(basePackageClasses = { DemoApplication.class, Jsr310Converters.class })
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@PostConstruct
	void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
