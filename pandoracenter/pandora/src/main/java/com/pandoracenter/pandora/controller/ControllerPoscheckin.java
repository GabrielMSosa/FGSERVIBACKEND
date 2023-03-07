/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pandoracenter.pandora.controller;

import com.pandoracenter.pandora.entity.EStatus;
import com.pandoracenter.pandora.entity.PosCheckinFar;
import com.pandoracenter.pandora.service.ServiPoscheckinFarmer;
import java.util.List;
import java.util.Map;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author gabriel
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/pandoraposcheckin")
public class ControllerPoscheckin {
    @Autowired
    private ServiPoscheckinFarmer servi;
    
      @PostMapping("/savebyfarmer")
      ResponseEntity<PosCheckinFar> SaveByFarmer( @RequestBody PosCheckinFar data ){
           
          System.out.println("el valor ingresado es "+ data.toString());
          
          String tipostatus=data.getStatus();
          
          if (tipostatus.equals("accept_farmer")||tipostatus.equals("accept_factory")||tipostatus.equals("reject_factory")||tipostatus.equals("reject_farmer")) {
              System.out.println("entramos al camino correcto");
              if (tipostatus.equals("accept_farmer")) {
              data.setStatus(EStatus.ACCEPT_FARMER.toString());
          }
          if (tipostatus.equals("accept_factory")) {
              data.setStatus(EStatus.ACCEPT_FACTORY.toString());
          }
          if (tipostatus.equals("reject_factory")) {
              data.setStatus(EStatus.REJECT_FACTORY.toString());
          }
          if (tipostatus.equals("reject_farmer")) {
              data.setStatus(EStatus.REJECT_FARMER.toString());
          }
          }
          else{
              System.out.println("entramos al conflict");
          return ResponseEntity.status(HttpStatus.CONFLICT).body(data);
          
          
          }
          
          
          /*
          ACCEPT_FARMER,
  ACCEPT_FACTORY,
  REJECT_FARMER,
  REJECT_FACTORY,*/
          
          
          //ResponseEntity<UnitTransTransaccTe[]> responseEntity =  restTemplate.getForEntity(url,
	//			UnitTransTransaccTe[].class);
        
          return ResponseEntity.status(HttpStatus.OK)
           .body(servi.SavebyFarmer(data));
      
      
      
      }
    
      @GetMapping("/findackfarmer/{id}")
      ResponseEntity<List<PosCheckinFar>> FindByFarmer( @PathVariable Long id ){
                 
       return ResponseEntity.status(HttpStatus.OK)
           .body(servi.FindMydata(id));
      
      }
           
      
      
    
    
    
    
    
    
    
}
