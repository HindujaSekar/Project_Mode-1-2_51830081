package com.bankapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@EnableTransactionManagement
@SpringBootApplication
public class BankappV1Application implements CommandLineRunner{

	
	public static void main(String[] args) {
		SpringApplication.run(BankappV1Application.class, args);

	}
	


	@Override
	public void run(String... args) throws Exception {
		
	}

}
















