package com.oja.ruralCanarias;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class RuralCanariasApplication {

	public static void main(String[] args) {
		SpringApplication.run(RuralCanariasApplication.class, args);
	}

}