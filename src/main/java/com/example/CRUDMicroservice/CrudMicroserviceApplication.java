package com.example.CRUDMicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.SpringVersion;

@SpringBootApplication
public class CrudMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudMicroserviceApplication.class, args);
		System.out.println(SpringVersion.getVersion());
	}

}
