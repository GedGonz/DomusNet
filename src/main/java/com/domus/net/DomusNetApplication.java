package com.domus.net;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableScheduling
@SpringBootApplication
public class DomusNetApplication {

	public static void main(String[] args) {
		SpringApplication.run(DomusNetApplication.class, args);
	}

}
