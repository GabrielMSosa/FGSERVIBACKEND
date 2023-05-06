/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.farmer.farmerservices.factory.controller;

import com.farmer.farmerservices.campo.entity.Datauser_campo;
import com.farmer.farmerservices.campo.entity.Mytruck;
import com.farmer.farmerservices.campo.entity.TeNomDec;
import com.farmer.farmerservices.campo.entity.Transaccion_te;
import com.farmer.farmerservices.campo.response.CampoResponse;
import com.farmer.farmerservices.campo.services.IServiceFarm;
import com.farmer.farmerservices.factory.entity.Datouser_factory;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author gabriel
 */


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/farmer")
public class ControllerFarmWrite {
    
    @Autowired
    private IServiceFarm servi;
    
    
      @PostMapping("/write")
      ResponseEntity<?> CargarFarmItemFull(@RequestBody TeNomDec data){
      //hay que arreglar este endpoint
      //porque tengo que entrar con el id para traer el datauser campo y poder cargarlo..
          System.out.println(data.toString());
        return ResponseEntity.status(HttpStatus.OK)
        .body(servi.LoadCampo(data));
    
      }
      
      
      @DeleteMapping("/deletetruck/{id}")
      ResponseEntity<TeNomDec> RemoveTruckByID(@RequestBody Mytruck data,
                                            @PathVariable Long id){
          System.out.println("el valor de myrtuck vale en el controler "+data.toString());
      
      return ResponseEntity.status(HttpStatus.OK)
        .body(servi.DeleteTruckforIdDataUser(id, data));
            }
      
      
      
      @PostMapping("/addtruck/{id}")      
      ResponseEntity<TeNomDec> AddnewTruck(@RequestBody Mytruck data,
                                            @PathVariable Long id){
      
      return ResponseEntity.status(HttpStatus.OK)
        .body(servi.AddTruckforTenomDec(data, id));
      
          
          
      
      }
      
      @GetMapping("/gettenomfusrcam/{id}")
      ResponseEntity<Set<TeNomDec>> GetTenomByIDDataUsercampo(
                                                @PathVariable Long id)     
      {
        return ResponseEntity.status(HttpStatus.OK)
        .body(servi.ReturnTruckforIdDataUser(id));
      
          
      }
      
      
      
      @GetMapping("/usrcampo/{id}")      
      ResponseEntity<Datauser_campo> GetDatacampo(
                                                @PathVariable Long id)     
      {
        return ResponseEntity.status(HttpStatus.OK)
        .body(servi.GetByID(id));
      
          
      }
      
      
      @PutMapping("/saveone/{id}")
      ResponseEntity<TeNomDec> AddTeTransacc(@RequestBody TeNomDec data,
                                              @PathVariable Long id   ){
      
          
          for (int i = 0; i < data.getTransaccion_te().size(); i++) {
              System.out.println(data.getTransaccion_te().toString());
          }
          
          for (Transaccion_te x:data.getTransaccion_te() ) {
              
              System.out.println(x.toString());
                                                  
          }
          
          data.getTransaccion_te();
          System.out.println("El valor de data vale "+data.getTransaccion_te().size());
      
        return ResponseEntity.status(HttpStatus.OK)
        .body(servi.AddTransaccTe(data));
    
      
      }
      
      
      @GetMapping("/gettenominalbyiduser/{id}")
                ResponseEntity<?> GetDatoTenombyIdUser(@PathVariable Long id){
                
             return ResponseEntity.status(HttpStatus.OK).
                            body(servi.GetTenomByIdUser(id));
     

                }
      
      
      //http://localhost:5000/farmer/gettenominalbyid/106
      //transacci id 107
      //tenomdecl id 106
        @GetMapping("/gettenominalbyid/{id}")
                ResponseEntity<TeNomDec> GetDatoTenombyID(@PathVariable Long id){
             return ResponseEntity.status(HttpStatus.OK).
                            body(servi.GetTeNomById(id));
  
  }

                @CrossOrigin(origins = "*", maxAge = 3600)
                @GetMapping("/gettenominalall")
                ResponseEntity<List<TeNomDec>> GetDatoTenomAll(){
                
             return ResponseEntity.status(HttpStatus.OK).
                            body(servi.GetTeNomAll());
     
                
                
                
                }
                
                
                
                
                
                
                
                
 @GetMapping("/gettransacciyid/{id}")
                ResponseEntity<Transaccion_te> GetDatotransaccbyID(@PathVariable Long id){
             return ResponseEntity.status(HttpStatus.OK).
                            body(servi.GetTetransacciById(id));
  
  }
                
   
                
                 @PutMapping("/editartransaccion/{id}")
            public ResponseEntity<TeNomDec>  editarItem(@PathVariable Long id,
                        @RequestBody Transaccion_te  dato){
                     
                
                   
                
                
                return ResponseEntity.status(HttpStatus.OK).
                            body(servi.AddTransaccionTe(dato, id));
  
 
            }
 
 
                
                
    
    
    
    
}
