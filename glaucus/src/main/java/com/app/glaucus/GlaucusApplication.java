package com.app.glaucus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class GlaucusApplication {

	public static void main(String[] args) {
		SpringApplication.run(GlaucusApplication.class, args);
	}

}
