package com.pandoracenter.pandora;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PandoraApplication {

	public static void main(String[] args) {
		SpringApplication.run(PandoraApplication.class, args);
	}

}
