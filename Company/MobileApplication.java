package com.Company;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MobileApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context=SpringApplication.run(MobileApplication.class, args);
		context.getBean(MobileController.class);
	}

}
