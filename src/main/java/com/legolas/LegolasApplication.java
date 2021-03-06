package com.legolas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.legolas.config.AppProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class LegolasApplication {

	public static void main(String[] args) {
		SpringApplication.run(LegolasApplication.class, args);
	}
}
