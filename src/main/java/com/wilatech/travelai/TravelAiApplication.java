package com.wilatech.travelai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class TravelAiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TravelAiApplication.class, args);
	}

}
