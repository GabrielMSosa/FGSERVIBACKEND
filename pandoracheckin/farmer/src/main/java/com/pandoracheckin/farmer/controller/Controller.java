/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pandoracheckin.farmer.controller;

import com.netflix.discovery.EurekaClient;
import com.pandoracheckin.farmer.DTO.PandoraCheckFarmer;
import com.pandoracheckin.farmer.UnitGlobal.entity.UnitTransTransaccTe;
import com.pandoracheckin.farmer.service.ServiceCheckin;
import java.util.ArrayList;

import java.util.List;
import java.util.Map;
import org.hibernate.validator.internal.util.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author gabriel
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/pandora")
public class Controller {
 
    @Autowired
    private ServiceCheckin servi;
    
    @GetMapping("/retall/{id}")
      ResponseEntity<List<PandoraCheckFarmer>> ReturnAllUnit( @PathVariable Long id, @RequestHeader Map<String, String> headers ){
           
        System.out.println("eader values: {}"+ headers);
       String token=headers.get("authorization");
        System.out.println("el valor de token vale"+token);
       
          
          //ResponseEntity<UnitTransTransaccTe[]> responseEntity =  restTemplate.getForEntity(url,
	//			UnitTransTransaccTe[].class);
        
          return ResponseEntity.status(HttpStatus.OK)
           .body( servi.ReturnAll(id,token));
      
      
      
      }
}
