package com.faculte.simplefacultebesoin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.faculte.simplefacultebesoin.domain.rest")
public class SimpleFaculteBesoinApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleFaculteBesoinApplication.class, args);
	}

}
