/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servicewebeg.egwebclient.controller;
import com.netflix.discovery.converters.Auto;
import com.servicewebeg.egwebclien.model.MyToken;
import com.servicewebeg.egwebclien.model.ConnValidationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 *
 * @author gabriel
 */

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("testapi/webclien")
public class MyTestController {
    
    
    //private final WebClient webClient;
    
     @Autowired
    private RestTemplate restTemplate;
    
    
   // public MyTestController(WebClient.Builder webClientBuilder) {
     //   this.webClient = webClientBuilder.baseUrl ("lb://AUTH-SERVICE:8086").build();
    //}
    
    
    @PostMapping("/read")
    public ConnValidationResponse Returnvalue(@RequestBody MyToken data1) {
        
        System.out.println(data1.toString());
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + data1.getToken() );

        HttpEntity<String> request = new HttpEntity<String>(headers);
        String url="http://auth-service/api/v1/validateToken";
        
        return restTemplate.exchange(url,HttpMethod.GET,request, ConnValidationResponse.class).getBody();
    }
    
    
    
    
}
