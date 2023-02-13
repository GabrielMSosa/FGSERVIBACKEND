/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/*
package com.farmer.farmerservices.factory.controller;

import com.farmer.farmerservices.factory.entity.BasculaParametro;
import com.farmer.farmerservices.factory.entity.Datouser_factory;
import com.farmer.farmerservices.factory.entity.Ofertas;
import com.farmer.farmerservices.factory.service.IServiFactory;
import com.farmer.farmerservices.response.MessageResponse;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
*/
/**
 *
 * @author gabriel
 */

/*
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/factory")
public class ControllerFactoryWrite {
  @Autowired
  private IServiFactory servi;
    
    
    
  @GetMapping("/user")
  @PreAuthorize("hasRole('FACTORY')")
  public String userAccess() {
    return "User Content.";
  }
  



  @GetMapping("/getall")
  @PreAuthorize("hasRole('FACTORY')")
  ResponseEntity<List<Datouser_factory>> GetAllDatoFactory(){


return ResponseEntity.status(HttpStatus.OK)
        .body(servi.GetAllDatouserFactory());
}

  
  
  @PostMapping("/write")
  @PreAuthorize("hasRole('FACTORY')")
  ResponseEntity<Datouser_factory> CargarOferta(@RequestBody Datouser_factory data){
  
  
  
        return ResponseEntity.status(HttpStatus.OK)
        .body(data);
  
  }
  
  
  
  @GetMapping("/getid/{id}")
  @PreAuthorize("hasRole('FACTORY')") 
  ResponseEntity<Datouser_factory> GetDatobyID(@PathVariable Long id){
            
      
  return ResponseEntity.status(HttpStatus.OK).
                            body(servi.GetByID(id));
  
  }
  
    @PutMapping("/add/truck/{id}")
    @PreAuthorize("hasRole('FACTORY')") 
 public ResponseEntity<Ofertas> AddBascula(@PathVariable Long id,
                        @RequestBody BasculaParametro dato
            ){
 
      return ResponseEntity.status(HttpStatus.OK).
                            body(servi.AddBascula(dato, id));
 
 }
  
  
  
  
  
  
  
  
  @GetMapping("/getoferid/{id}")
  @PreAuthorize("hasRole('FACTORY')") 
  ResponseEntity<Ofertas> GetOfertabyID(@PathVariable Long id){
            
      
  return ResponseEntity.status(HttpStatus.OK).
                            body(servi.GetOfertasByID(id));
  
  
  }
  
  
  
  
  
  
  
  
  
  
  
 @PostMapping("/create")
@PreAuthorize("hasRole('FACTORY')") 
 ResponseEntity<Datouser_factory> CreateDataFactory(@RequestBody Datouser_factory data){
 
        servi.CreateDataUserFactory(data);
     
 
 
 
 
     return ResponseEntity.status(HttpStatus.OK).
             body(data);
 }
  
  
  
  
  
  // ROLE_FACTORY,
  //ROLE_PROPIETARIOS

    
    
    
    
}
*/