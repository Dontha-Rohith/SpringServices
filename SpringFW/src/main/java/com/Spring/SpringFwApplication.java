package com.Spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class SpringFwApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringFwApplication.class, args);
	}

}
