/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.farmer.farmerservices.UnitGlobal.Controller;

import com.farmer.farmerservices.UnitGlobal.entity.UnitTransTransaccTe;
import com.farmer.farmerservices.UnitGlobal.entity.UnitTransaccion;
import com.farmer.farmerservices.UnitGlobal.services.IServiceUnit;
import com.farmer.farmerservices.campo.entity.TeNomDec;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author gabriel
 */

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/unit")
public class ControllerUnit {
    
    @Autowired
    private IServiceUnit servi;
    
    
    
      
      //@PreAuthorize("hasRole('FACTORY')")
    @GetMapping("/allunit")
    ResponseEntity<List<UnitTransaccion>> GetAllUnit( ){
      
          
          
        return ResponseEntity.status(HttpStatus.OK)
        .body(servi.traerTodo());
    
      
      }
    
//      @PreAuthorize("hasRole('PROPIETARIOS') or hasRole('ADMIN') ")
      @PostMapping("/addunit")
      ResponseEntity<String> CargarUnit(@RequestBody UnitTransaccion data){
      //hay que arreglar este endpoint
      //porque tengo que entrar con el id para traer el datauser campo y poder cargarlo..
          System.out.println(data.toString());
        return ResponseEntity.status(HttpStatus.OK)
        .body(servi.LogicTransacci(data));
    
      }

      
      
      @GetMapping("/retall/{id}")
      ResponseEntity<List<UnitTransTransaccTe>> ReturnAllUnit( @PathVariable Long id  ){
          
        
        
          return ResponseEntity.status(HttpStatus.OK)
           .body( servi.ReturnAll(id));
      
      
      
      }
      @GetMapping("/retallffarm/{id}")
      ResponseEntity<List<UnitTransTransaccTe>> ReturnAllUnitfarm( @PathVariable Long id  ){
          
        
        
          return ResponseEntity.status(HttpStatus.OK)
           .body( servi.ReturnAllxfarm(id));
      
      
      
      }
     
      
      
      
      
      
      
      @PostMapping("/testfarm")
      ResponseEntity<String> ValidaUnit(@RequestBody UnitTransaccion data){
      
          System.out.println("el valor en controller de unit vale"+data.toString());
        
        
          return ResponseEntity.status(HttpStatus.OK)
           .body( servi.ScanUT(data));
      
              
         
          
      
      }
       
  
  
  
    
    
}
