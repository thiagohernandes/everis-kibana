package com.everis.kibana;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.everis.kibana" })
public class AppMainEveris {

	public static void main(String[] args) {
		SpringApplication.run(AppMainEveris.class, args);
	}

}
