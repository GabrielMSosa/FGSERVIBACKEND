/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pandoracenter.pandora.controller;

import com.pandoracenter.pandora.entity.EStatus;
import com.pandoracenter.pandora.entity.IPKstatus;
import com.pandoracenter.pandora.entity.IPk;
import com.pandoracenter.pandora.entity.PosCheckinFar;
import com.pandoracenter.pandora.service.ServiPoscheckinFarmer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/pandoraposcheckin")

public class ControllerPoscheckin {
    @Autowired
    private ServiPoscheckinFarmer servi;
    
    
    @GetMapping("/allposcheckin")
    ResponseEntity<java.lang.Object> ReturnAllfarmer(){
    
          return ResponseEntity.status(HttpStatus.OK)
           .body(servi.ReturnAllPoscheckin());
      
     }
     
     
     
     @PostMapping("/allposcheckinpk")
     ResponseEntity<java.lang.Object> ReturnAllfarmerxPk(@RequestBody IPk data){
    
          return ResponseEntity.status(HttpStatus.OK)
           .body(servi.ReturnAllPoscheckinxPk(data));
      
     }


    @PostMapping("/savebyfarmer/factory")
    ResponseEntity<PosCheckinFar> SaveByFactory( @RequestBody PosCheckinFar data ){
        String tipostatus=data.getStatus();


            if (tipostatus.equals("accept_farmer")||tipostatus.equals(EStatus.ACCEPT_FARMER.toString())) {
                data.setStatus(EStatus.ACCEPT_FARMER.toString());
            }

        if (tipostatus.equals(EStatus.ACCEPT_FARMER.toString())==false){

            return ResponseEntity.status(HttpStatus.CONFLICT).body(data);}
        else{
            return ResponseEntity.status(HttpStatus.OK)
                    .body(servi.SavebyFactory(data));
        }}

    @PostMapping("/changebyfactory/factory")
    ResponseEntity<PosCheckinFar> ChangeByFactory( @RequestBody PosCheckinFar data ){
        String tipostatus=data.getStatus();


        if (tipostatus.equals("accept_factory")||tipostatus.equals(EStatus.ACCEPT_FACTORY.toString())) {

            data.setStatus(EStatus.ACCEPT_FACTORY.toString());
        }

        if (tipostatus.equals("accept_factory_truck_in")||tipostatus.equals(EStatus.ACCEPT_FACTORY_TRUCK_IN.toString())) {

            data.setStatus(EStatus.ACCEPT_FACTORY_TRUCK_IN.toString());
        }


        if (tipostatus.equals(EStatus.ACCEPT_FACTORY.toString())==false&&tipostatus.equals(EStatus.ACCEPT_FACTORY_TRUCK_IN.toString())==false){

            return ResponseEntity.status(HttpStatus.CONFLICT).body(data);}
        else{
            return ResponseEntity.status(HttpStatus.OK)
                    .body(servi.ChangebyFactory(data));
        }}

    @PostMapping("/return/allstatusandid")
    ResponseEntity<List<PosCheckinFar>> ReturnAllfarmerxPkandeStatus(@RequestBody IPKstatus data){
        List<PosCheckinFar> dtaout=new ArrayList<>();
                if (data.getStatus().equals("accept_farmer")||data.getStatus().equals(EStatus.ACCEPT_FARMER.toString())){

                        data.setStatus(EStatus.ACCEPT_FARMER.toString());}

                if (data.getStatus().equals("accept_factory")||data.getStatus().equals(EStatus.ACCEPT_FACTORY.toString())){

                        data.setStatus(EStatus.ACCEPT_FACTORY.toString());}

                if (data.getStatus().equals("reject_farmer")||data.getStatus().equals(EStatus.REJECT_FARMER.toString())){

                        data.setStatus(EStatus.REJECT_FARMER.toString());}

                if (data.getStatus().equals("reject_factory")||data.getStatus().equals(EStatus.REJECT_FACTORY.toString())){

                        data.setStatus(EStatus.REJECT_FACTORY.toString());}

                if (data.getStatus().equals("accept_factory_truck_in")||data.getStatus().equals(EStatus.ACCEPT_FACTORY_TRUCK_IN.toString())){

                        data.setStatus(EStatus.ACCEPT_FACTORY_TRUCK_IN.toString());}

                if (data.getStatus().equals("accept_factory_water_dg")||data.getStatus().equals(EStatus.ACCEPT_FACTORY_WATER_DG.toString())){

                        data.setStatus(EStatus.ACCEPT_FACTORY_WATER_DG.toString());}

                if (data.getStatus().equals("accept_farmer_truck_in")||data.getStatus().equals(EStatus.ACCEPT_FARMER_TRUCK_IN.toString())){

                        data.setStatus(EStatus.ACCEPT_FARMER_TRUCK_IN.toString());}

                if (data.getStatus().equals("accept_farmer_water_dg")||data.getStatus().equals(EStatus.ACCEPT_FARMER_WATER_DG.toString())){

                        data.setStatus(EStatus.ACCEPT_FARMER_WATER_DG.toString());}

                if (data.getStatus().equals("reject_farmer_truck_in")||data.getStatus().equals(EStatus.REJECT_FARMER_TRUCK_IN.toString())){

                        data.setStatus(EStatus.REJECT_FARMER_TRUCK_IN.toString());}

                if (data.getStatus().equals("reject_farmer_water_dg")||data.getStatus().equals(EStatus.REJECT_FARMER_WATER_DG.toString())){

                        data.setStatus(EStatus.REJECT_FARMER_WATER_DG.toString());}

                if (data.getStatus().equals("reject_truck_in_accepted_water_dg")||data.getStatus().equals(EStatus.REJECT_TRUCK_IN_ACCEPTED_WATER_DG.toString())){

                        data.setStatus(EStatus.REJECT_TRUCK_IN_ACCEPTED_WATER_DG.toString());}

                if (data.getStatus().equals("reject_water_dg_accepted_truck_in")||data.getStatus().equals(EStatus.REJECT_WATER_DG_ACCEPTED_TRUCK_IN.toString())){

                        data.setStatus(EStatus.REJECT_WATER_DG_ACCEPTED_TRUCK_IN.toString());}

                if (data.getStatus().equals("reject_truck_in_and_water_dg")||data.getStatus().equals(EStatus.REJECT_TRUCK_IN_AND_WATER_DG.toString())){

                        data.setStatus(EStatus.REJECT_TRUCK_IN_AND_WATER_DG.toString());}

                if (data.getStatus().equals("accept_checkin")||data.getStatus().equals(EStatus.ACCEPT_CHECKIN.toString())){

                        data.setStatus(EStatus.ACCEPT_CHECKIN.toString());}



        return ResponseEntity.status(HttpStatus.OK)
                .body(servi.ReturnAllPoscheckinxPkandstatus(data));
    }


    @PostMapping("/audit/farmeraccept")
    ResponseEntity<PosCheckinFar> AuditByFarmer( @RequestBody PosCheckinFar data ){

        String tipostatus=data.getStatus();

        if (tipostatus.equals("accept_farmer_truck_in")||tipostatus.equals(EStatus.ACCEPT_FARMER_TRUCK_IN.toString())) {
            data.setStatus(EStatus.ACCEPT_FARMER_TRUCK_IN.toString());
        }

        if (tipostatus.equals("accept_farmer_water_dg")||tipostatus.equals(EStatus.ACCEPT_FARMER_WATER_DG.toString())) {

            data.setStatus(EStatus.ACCEPT_FARMER_WATER_DG.toString());
        }
         if (tipostatus.equals(EStatus.ACCEPT_FARMER_WATER_DG.toString())==false&&tipostatus.equals(EStatus.ACCEPT_FARMER_TRUCK_IN.toString())==false){

            return ResponseEntity.status(HttpStatus.CONFLICT).body(data);}
        else{
            return ResponseEntity.status(HttpStatus.OK)
                    .body(servi.AuditbyFarmerAccepted(data));

 }}

    @PostMapping("/audit/farmerreject")
    ResponseEntity<PosCheckinFar> AuditByFarmerReject( @RequestBody PosCheckinFar data ){

        String tipostatus=data.getStatus();

        if (tipostatus.equals("reject_farmer_truck_in")||tipostatus.equals(EStatus.REJECT_FARMER_TRUCK_IN.toString())) {
            data.setStatus(EStatus.REJECT_FARMER_TRUCK_IN.toString());
        }

        if (tipostatus.equals("reject_farmer_water_dg")||tipostatus.equals(EStatus.REJECT_FARMER_WATER_DG.toString())) {

            data.setStatus(EStatus.REJECT_FARMER_WATER_DG.toString());
        }
        if (tipostatus.equals(EStatus.REJECT_FARMER_WATER_DG.toString())==false&&tipostatus.equals(EStatus.REJECT_FARMER_TRUCK_IN.toString())==false){

            return ResponseEntity.status(HttpStatus.CONFLICT).body(data);}
        else{
            return ResponseEntity.status(HttpStatus.OK)
                    .body(servi.AuditbyFarmerRejected(data));

        }


    }



    @PostMapping("/savebyfarmer/farmer")
      ResponseEntity<PosCheckinFar> SaveByFarmer( @RequestBody PosCheckinFar data ){
          PosCheckinFar returnvalue= new PosCheckinFar();
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
        returnvalue=servi.SavebyFarmer(data);
          if (returnvalue==null) {
               return ResponseEntity.status(HttpStatus.CONFLICT).body(data);
              
          }
          else{
        
        
          return ResponseEntity.status(HttpStatus.OK)
           .body(returnvalue);
      
          }
      
      }
    @GetMapping("/findallbyfarmer/{id}")
    ResponseEntity<List<PosCheckinFar>> FindAllByFarmer( @PathVariable Long id ){
        return ResponseEntity.status(HttpStatus.OK)
                .body(servi.FindMydataallstatus(id));
    }
      @GetMapping("/findackfarmer/{id}")
      ResponseEntity<List<PosCheckinFar>> FindByFarmer( @PathVariable Long id ){
                 
       return ResponseEntity.status(HttpStatus.OK)
           .body(servi.FindMydataackfarmer(id));
      
      }
      //ese endpoint usamos para buscar los pendientes.
        @GetMapping("/findackfactory/{id}")
      ResponseEntity<List<PosCheckinFar>> FindByFactory( @PathVariable Long id ){
                 
       return ResponseEntity.status(HttpStatus.OK)
           .body(servi.FindMydataackfactory(id));
      
      }
           
      
      
    
    
    
    
    
    
    
}
