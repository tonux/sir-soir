package com.sir.soir.sir2022;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Sir2022Application {

	private static final Logger logger = LogManager.getLogger(Sir2022Application.class);

	public static void main(String[] args) {
		logger.info("Starting application");
		SpringApplication.run(Sir2022Application.class, args);
	}

}
