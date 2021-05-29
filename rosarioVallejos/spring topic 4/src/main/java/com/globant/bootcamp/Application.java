package com.globant.bootcamp;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application {
	static Logger logger= Logger.getLogger(Application.class.getName());

	public static void main(String[] args) {
		logger.info("Comienzo de la ejecución del programa");

		SpringApplication.run(Application.class, args);

	}




}
