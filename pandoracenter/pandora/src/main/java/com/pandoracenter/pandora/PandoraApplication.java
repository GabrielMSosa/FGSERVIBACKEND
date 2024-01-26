package com.pandoracenter.pandora;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PandoraApplication {

	public static void main(String[] args) {
		SpringApplication.run(PandoraApplication.class, args);
	}

}
