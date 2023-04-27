/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pandoracenter.pandora.controller;

import com.pandoracenter.pandora.entity.*;
import com.pandoracenter.pandora.service.ServiPoscheckinFarmer;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

=======
import java.util.*;

import org.hibernate.annotations.Parameter;
>>>>>>> d43553a536bfa70554811e5ee2332864fcea3d8c
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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
<<<<<<< HEAD
     ResponseEntity<java.lang.Object> ReturnAllfarmerxPk(@RequestBody IPk data){
    
=======
     ResponseEntity<List<PosCheckinFar>> ReturnAllfarmerxPk(@RequestBody IPk data){

>>>>>>> d43553a536bfa70554811e5ee2332864fcea3d8c
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
        }
    }

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
    ResponseEntity<?> ReturnAllfarmerxPkandeStatus( @Valid @RequestBody IPKstatus data,BindingResult result){
        if (result.hasErrors()){
            return ValidateData(result);
        }

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

    @PostMapping("/return/allstatussub")
    ResponseEntity<?> ReturnAllfarmerxPkandeStatus(@Valid @RequestBody IPkSubstatus data, BindingResult result){
        if (result.hasErrors()){
            return ValidateData(result);
        }
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
        //-------------------------------------------------------
        if (data.getSubstatus().equals("accept_farmer")||data.getStatus().equals(EStatus.ACCEPT_FARMER.toString())){

            data.setStatus(EStatus.ACCEPT_FARMER.toString());}

        if (data.getSubstatus().equals("accept_factory")||data.getStatus().equals(EStatus.ACCEPT_FACTORY.toString())){

            data.setStatus(EStatus.ACCEPT_FACTORY.toString());}

        if (data.getSubstatus().equals("reject_farmer")||data.getStatus().equals(EStatus.REJECT_FARMER.toString())){

            data.setStatus(EStatus.REJECT_FARMER.toString());}

        if (data.getSubstatus().equals("reject_factory")||data.getStatus().equals(EStatus.REJECT_FACTORY.toString())){

            data.setStatus(EStatus.REJECT_FACTORY.toString());}

        if (data.getSubstatus().equals("accept_factory_truck_in")||data.getStatus().equals(EStatus.ACCEPT_FACTORY_TRUCK_IN.toString())){

            data.setStatus(EStatus.ACCEPT_FACTORY_TRUCK_IN.toString());}

        if (data.getSubstatus().equals("accept_factory_water_dg")||data.getStatus().equals(EStatus.ACCEPT_FACTORY_WATER_DG.toString())){

            data.setStatus(EStatus.ACCEPT_FACTORY_WATER_DG.toString());}

        if (data.getSubstatus().equals("accept_farmer_truck_in")||data.getStatus().equals(EStatus.ACCEPT_FARMER_TRUCK_IN.toString())){

            data.setStatus(EStatus.ACCEPT_FARMER_TRUCK_IN.toString());}

        if (data.getSubstatus().equals("accept_farmer_water_dg")||data.getStatus().equals(EStatus.ACCEPT_FARMER_WATER_DG.toString())){

            data.setStatus(EStatus.ACCEPT_FARMER_WATER_DG.toString());}

        if (data.getSubstatus().equals("reject_farmer_truck_in")||data.getStatus().equals(EStatus.REJECT_FARMER_TRUCK_IN.toString())){

            data.setStatus(EStatus.REJECT_FARMER_TRUCK_IN.toString());}

        if (data.getSubstatus().equals("reject_farmer_water_dg")||data.getStatus().equals(EStatus.REJECT_FARMER_WATER_DG.toString())){

            data.setStatus(EStatus.REJECT_FARMER_WATER_DG.toString());}

        if (data.getSubstatus().equals("reject_truck_in_accepted_water_dg")||data.getStatus().equals(EStatus.REJECT_TRUCK_IN_ACCEPTED_WATER_DG.toString())){

            data.setStatus(EStatus.REJECT_TRUCK_IN_ACCEPTED_WATER_DG.toString());}

        if (data.getSubstatus().equals("reject_water_dg_accepted_truck_in")||data.getStatus().equals(EStatus.REJECT_WATER_DG_ACCEPTED_TRUCK_IN.toString())){

            data.setStatus(EStatus.REJECT_WATER_DG_ACCEPTED_TRUCK_IN.toString());}

        if (data.getSubstatus().equals("reject_truck_in_and_water_dg")||data.getStatus().equals(EStatus.REJECT_TRUCK_IN_AND_WATER_DG.toString())){

            data.setStatus(EStatus.REJECT_TRUCK_IN_AND_WATER_DG.toString());}

        if (data.getSubstatus().equals("accept_checkin")||data.getStatus().equals(EStatus.ACCEPT_CHECKIN.toString())){

            data.setStatus(EStatus.ACCEPT_CHECKIN.toString());}

        else{
            return ResponseEntity.badRequest().body(Collections.singletonMap("Error","Status fuera de rango"));

        }

        return ResponseEntity.status(HttpStatus.OK)
                .body(servi.ReturnAllPoscheckinxPkandsubstatus(data));
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


    @PostMapping("/audit/master")
    ResponseEntity<?> AuditMaster( @RequestBody PosCheckinFar data,BindingResult result ){
        if (result.hasErrors()){
            return ValidateData(result);
        }

        if (IsInvalid(data)==false){
        PosCheckinFar data2=new PosCheckinFar();
        PosCheckinFar data1=new PosCheckinFar();
        data1=ReturnStatusCorrect(data);
                data2=ReturnPandoraCheckStausCorrect(data1);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(servi.SaveGeneric(data2));}
        else{
            return ResponseEntity.status(HttpStatus.CONFLICT).body(data);}

        }





    @PostMapping("/savebyfarmer/farmer")
      ResponseEntity<?> SaveByFarmer(@Valid @RequestBody PosCheckinFar data,  BindingResult result ){

        if (result.hasErrors()){
            return ValidateData(result);
        }
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
           

    public PosCheckinFar ReturnStatusCorrect(PosCheckinFar data){

            Boolean flag=true;
        if (data.getStatus().equals("accept_farmer")||data.getStatus().equals(EStatus.ACCEPT_FARMER.toString())){
            flag=false;
            data.setStatus(EStatus.ACCEPT_FARMER.toString());}

        if (data.getStatus().equals("accept_factory")||data.getStatus().equals(EStatus.ACCEPT_FACTORY.toString())){
            flag=false;
            data.setStatus(EStatus.ACCEPT_FACTORY.toString());}

        if (data.getStatus().equals("reject_farmer")||data.getStatus().equals(EStatus.REJECT_FARMER.toString())){
            flag=false;
            data.setStatus(EStatus.REJECT_FARMER.toString());}

        if (data.getStatus().equals("reject_factory")||data.getStatus().equals(EStatus.REJECT_FACTORY.toString())){
            flag=false;
            data.setStatus(EStatus.REJECT_FACTORY.toString());}

        if (data.getStatus().equals("accept_factory_truck_in")||data.getStatus().equals(EStatus.ACCEPT_FACTORY_TRUCK_IN.toString())){
            flag=false;
            data.setStatus(EStatus.ACCEPT_FACTORY_TRUCK_IN.toString());}

        if (data.getStatus().equals("accept_factory_water_dg")||data.getStatus().equals(EStatus.ACCEPT_FACTORY_WATER_DG.toString())){
            flag=false;
            data.setStatus(EStatus.ACCEPT_FACTORY_WATER_DG.toString());}

        if (data.getStatus().equals("accept_farmer_truck_in")||data.getStatus().equals(EStatus.ACCEPT_FARMER_TRUCK_IN.toString())){
            flag=false;
            data.setStatus(EStatus.ACCEPT_FARMER_TRUCK_IN.toString());}

        if (data.getStatus().equals("accept_farmer_water_dg")||data.getStatus().equals(EStatus.ACCEPT_FARMER_WATER_DG.toString())){
            flag=false;
            data.setStatus(EStatus.ACCEPT_FARMER_WATER_DG.toString());}

        if (data.getStatus().equals("reject_farmer_truck_in")||data.getStatus().equals(EStatus.REJECT_FARMER_TRUCK_IN.toString())){
            flag=false;
            data.setStatus(EStatus.REJECT_FARMER_TRUCK_IN.toString());}

        if (data.getStatus().equals("reject_farmer_water_dg")||data.getStatus().equals(EStatus.REJECT_FARMER_WATER_DG.toString())){
            flag=false;
            data.setStatus(EStatus.REJECT_FARMER_WATER_DG.toString());}

        if (data.getStatus().equals("reject_truck_in_accepted_water_dg")||data.getStatus().equals(EStatus.REJECT_TRUCK_IN_ACCEPTED_WATER_DG.toString())){
            flag=false;
            data.setStatus(EStatus.REJECT_TRUCK_IN_ACCEPTED_WATER_DG.toString());}

        if (data.getStatus().equals("reject_water_dg_accepted_truck_in")||data.getStatus().equals(EStatus.REJECT_WATER_DG_ACCEPTED_TRUCK_IN.toString())){
            flag=false;
            data.setStatus(EStatus.REJECT_WATER_DG_ACCEPTED_TRUCK_IN.toString());}

        if (data.getStatus().equals("reject_truck_in_and_water_dg")||data.getStatus().equals(EStatus.REJECT_TRUCK_IN_AND_WATER_DG.toString())){
            flag=false;
            data.setStatus(EStatus.REJECT_TRUCK_IN_AND_WATER_DG.toString());}

        if (data.getStatus().equals("accept_checkin")||data.getStatus().equals(EStatus.ACCEPT_CHECKIN.toString())){
            flag=false;
            data.setStatus(EStatus.ACCEPT_CHECKIN.toString());}



        return data;

    }
    public PosCheckinFar ReturnPandoraCheckStausCorrect(PosCheckinFar data){


        Boolean flag=true;
        if (data.getPandora_check().getStatus().equals("accept_farmer")||data.getPandora_check().getStatus().equals(EStatus.ACCEPT_FARMER.toString())){
            flag=false;
            data.getPandora_check().setStatus(EStatus.ACCEPT_FARMER.toString());}
        if (data.getPandora_check().getStatus().equals("accept_factory")||data.getPandora_check().getStatus().equals(EStatus.ACCEPT_FACTORY.toString())){
            flag=false;
            data.getPandora_check().setStatus(EStatus.ACCEPT_FACTORY.toString());}
        if (data.getPandora_check().getStatus().equals("reject_farmer")||data.getPandora_check().getStatus().equals(EStatus.REJECT_FARMER.toString())){
            flag=false;
            data.getPandora_check().setStatus(EStatus.REJECT_FARMER.toString());}
        if (data.getPandora_check().getStatus().equals("reject_factory")||data.getPandora_check().getStatus().equals(EStatus.REJECT_FACTORY.toString())){
            flag=false;
            data.getPandora_check().setStatus(EStatus.REJECT_FACTORY.toString());}
        if (data.getPandora_check().getStatus().equals("accept_factory_truck_in")||data.getPandora_check().getStatus().equals(EStatus.ACCEPT_FACTORY_TRUCK_IN.toString())){
            flag=false;
            data.getPandora_check().setStatus(EStatus.ACCEPT_FACTORY_TRUCK_IN.toString());}
        if (data.getPandora_check().getStatus().equals("accept_factory_water_dg")||data.getPandora_check().getStatus().equals(EStatus.ACCEPT_FACTORY_WATER_DG.toString())){
            flag=false;
            data.getPandora_check().setStatus(EStatus.ACCEPT_FACTORY_WATER_DG.toString());}
        if (data.getPandora_check().getStatus().equals("accept_farmer_truck_in")||data.getPandora_check().getStatus().equals(EStatus.ACCEPT_FARMER_TRUCK_IN.toString())){
            flag=false;
            data.getPandora_check().setStatus(EStatus.ACCEPT_FARMER_TRUCK_IN.toString());}
        if (data.getPandora_check().getStatus().equals("accept_farmer_water_dg")||data.getPandora_check().getStatus().equals(EStatus.ACCEPT_FARMER_WATER_DG.toString())){
            flag=false;
            data.getPandora_check().setStatus(EStatus.ACCEPT_FARMER_WATER_DG.toString());}
        if (data.getPandora_check().getStatus().equals("reject_farmer_truck_in")||data.getPandora_check().getStatus().equals(EStatus.REJECT_FARMER_TRUCK_IN.toString())){
            flag=false;
            data.getPandora_check().setStatus(EStatus.REJECT_FARMER_TRUCK_IN.toString());}
        if (data.getPandora_check().getStatus().equals("reject_farmer_water_dg")||data.getPandora_check().getStatus().equals(EStatus.REJECT_FARMER_WATER_DG.toString())){
            flag=false;
            data.getPandora_check().setStatus(EStatus.REJECT_FARMER_WATER_DG.toString());}
        if (data.getPandora_check().getStatus().equals("reject_truck_in_accepted_water_dg")||data.getPandora_check().getStatus().equals(EStatus.REJECT_TRUCK_IN_ACCEPTED_WATER_DG.toString())){
            flag=false;
            data.getPandora_check().setStatus(EStatus.REJECT_TRUCK_IN_ACCEPTED_WATER_DG.toString());}
        if (data.getPandora_check().getStatus().equals("reject_water_dg_accepted_truck_in")||data.getPandora_check().getStatus().equals(EStatus.REJECT_WATER_DG_ACCEPTED_TRUCK_IN.toString())){
            flag=false;
            data.getPandora_check().setStatus(EStatus.REJECT_WATER_DG_ACCEPTED_TRUCK_IN.toString());}
        if (data.getPandora_check().getStatus().equals("reject_truck_in_and_water_dg")||data.getPandora_check().getStatus().equals(EStatus.REJECT_TRUCK_IN_AND_WATER_DG.toString())){
            flag=false;
            data.getPandora_check().setStatus(EStatus.REJECT_TRUCK_IN_AND_WATER_DG.toString());}
        if (data.getPandora_check().getStatus().equals("accept_checkin")||data.getPandora_check().getStatus().equals(EStatus.ACCEPT_CHECKIN.toString())){
            flag=false;
            data.getPandora_check().setStatus(EStatus.ACCEPT_CHECKIN.toString());}


        return data;
    }

    public Boolean IsInvalid(PosCheckinFar data){
        Boolean flag=true;


        if (data.getStatus().equalsIgnoreCase("accept_farmer")||data.getStatus().equals(EStatus.ACCEPT_FARMER.toString())){
        System.out.println("Entramos al if"+data.getStatus().toString());
            flag=false;
            data.setStatus(EStatus.ACCEPT_FARMER.toString());}

        if (data.getStatus().equalsIgnoreCase("accept_factory")||data.getStatus().equals(EStatus.ACCEPT_FACTORY.toString())){
        System.out.println("Entramos al if"+data.getStatus().toString());
            flag=false;
            data.setStatus(EStatus.ACCEPT_FACTORY.toString());}

        if (data.getStatus().equalsIgnoreCase("reject_farmer")||data.getStatus().equals(EStatus.REJECT_FARMER.toString())){
        System.out.println("Entramos al if"+data.getStatus().toString());
            flag=false;
            data.setStatus(EStatus.REJECT_FARMER.toString());}

        if (data.getStatus().equalsIgnoreCase("reject_factory")||data.getStatus().equals(EStatus.REJECT_FACTORY.toString())){
        System.out.println("Entramos al if"+data.getStatus().toString());
            flag=false;
            data.setStatus(EStatus.REJECT_FACTORY.toString());}

        if (data.getStatus().equalsIgnoreCase("accept_factory_truck_in")||data.getStatus().equals(EStatus.ACCEPT_FACTORY_TRUCK_IN.toString())){
        System.out.println("Entramos al if"+data.getStatus().toString());
            flag=false;
            data.setStatus(EStatus.ACCEPT_FACTORY_TRUCK_IN.toString());}

        if (data.getStatus().equalsIgnoreCase("accept_factory_water_dg")||data.getStatus().equals(EStatus.ACCEPT_FACTORY_WATER_DG.toString())){
        System.out.println("Entramos al if"+data.getStatus().toString());
            flag=false;
            data.setStatus(EStatus.ACCEPT_FACTORY_WATER_DG.toString());}

        if (data.getStatus().equalsIgnoreCase("accept_farmer_truck_in")||data.getStatus().equals(EStatus.ACCEPT_FARMER_TRUCK_IN.toString())){
        System.out.println("Entramos al if"+data.getStatus().toString());
            flag=false;
            data.setStatus(EStatus.ACCEPT_FARMER_TRUCK_IN.toString());}

        if (data.getStatus().equalsIgnoreCase("accept_farmer_water_dg")||data.getStatus().equals(EStatus.ACCEPT_FARMER_WATER_DG.toString())){
        System.out.println("Entramos al if"+data.getStatus().toString());
            flag=false;
            data.setStatus(EStatus.ACCEPT_FARMER_WATER_DG.toString());}

        if (data.getStatus().equalsIgnoreCase("reject_farmer_truck_in")||data.getStatus().equals(EStatus.REJECT_FARMER_TRUCK_IN.toString())){
        System.out.println("Entramos al if"+data.getStatus().toString());
            flag=false;
            data.setStatus(EStatus.REJECT_FARMER_TRUCK_IN.toString());}

        if (data.getStatus().equalsIgnoreCase("reject_farmer_water_dg")||data.getStatus().equals(EStatus.REJECT_FARMER_WATER_DG.toString())){
        System.out.println("Entramos al if"+data.getStatus().toString());
            flag=false;
            data.setStatus(EStatus.REJECT_FARMER_WATER_DG.toString());}

        if (data.getStatus().equalsIgnoreCase("reject_truck_in_accepted_water_dg")||data.getStatus().equals(EStatus.REJECT_TRUCK_IN_ACCEPTED_WATER_DG.toString())){
        System.out.println("Entramos al if"+data.getStatus().toString());
            flag=false;
            data.setStatus(EStatus.REJECT_TRUCK_IN_ACCEPTED_WATER_DG.toString());}

        if (data.getStatus().equalsIgnoreCase("reject_water_dg_accepted_truck_in")||data.getStatus().equals(EStatus.REJECT_WATER_DG_ACCEPTED_TRUCK_IN.toString())){
        System.out.println("Entramos al if"+data.getStatus().toString());
            flag=false;
            data.setStatus(EStatus.REJECT_WATER_DG_ACCEPTED_TRUCK_IN.toString());}

        if (data.getStatus().equalsIgnoreCase("reject_truck_in_and_water_dg")||data.getStatus().equals(EStatus.REJECT_TRUCK_IN_AND_WATER_DG.toString())){
        System.out.println("Entramos al if"+data.getStatus().toString());
            flag=false;
            data.setStatus(EStatus.REJECT_TRUCK_IN_AND_WATER_DG.toString());}

        if (data.getStatus().equalsIgnoreCase("accept_checkin")||data.getStatus().equals(EStatus.ACCEPT_CHECKIN.toString())){
        System.out.println("Entramos al if"+data.getStatus().toString());
            flag=false;
            data.setStatus(EStatus.ACCEPT_CHECKIN.toString());}
        //------------------
        if (data.getPandora_check().getStatus().equalsIgnoreCase("accept_farmer")||data.getPandora_check().getStatus().equals(EStatus.ACCEPT_FARMER.toString())){
        System.out.println("Entramos al if"+data.getStatus().toString());
            flag=false;
            data.getPandora_check().setStatus(EStatus.ACCEPT_FARMER.toString());}
        if (data.getPandora_check().getStatus().equalsIgnoreCase("accept_factory")||data.getPandora_check().getStatus().equals(EStatus.ACCEPT_FACTORY.toString())){
        System.out.println("Entramos al if"+data.getStatus().toString());
            flag=false;
            data.getPandora_check().setStatus(EStatus.ACCEPT_FACTORY.toString());}
        if (data.getPandora_check().getStatus().equalsIgnoreCase("reject_farmer")||data.getPandora_check().getStatus().equals(EStatus.REJECT_FARMER.toString())){
        System.out.println("Entramos al if"+data.getStatus().toString());
            flag=false;
            data.getPandora_check().setStatus(EStatus.REJECT_FARMER.toString());}
        if (data.getPandora_check().getStatus().equalsIgnoreCase("reject_factory")||data.getPandora_check().getStatus().equals(EStatus.REJECT_FACTORY.toString())){
        System.out.println("Entramos al if"+data.getStatus().toString());
            flag=false;
            data.getPandora_check().setStatus(EStatus.REJECT_FACTORY.toString());}
        if (data.getPandora_check().getStatus().equalsIgnoreCase("accept_factory_truck_in")||data.getPandora_check().getStatus().equals(EStatus.ACCEPT_FACTORY_TRUCK_IN.toString())){
        System.out.println("Entramos al if"+data.getStatus().toString());
            flag=false;
            data.getPandora_check().setStatus(EStatus.ACCEPT_FACTORY_TRUCK_IN.toString());}
        if (data.getPandora_check().getStatus().equalsIgnoreCase("accept_factory_water_dg")||data.getPandora_check().getStatus().equals(EStatus.ACCEPT_FACTORY_WATER_DG.toString())){
        System.out.println("Entramos al if"+data.getStatus().toString());
            flag=false;
            data.getPandora_check().setStatus(EStatus.ACCEPT_FACTORY_WATER_DG.toString());}
        if (data.getPandora_check().getStatus().equalsIgnoreCase("accept_farmer_truck_in")||data.getPandora_check().getStatus().equals(EStatus.ACCEPT_FARMER_TRUCK_IN.toString())){
        System.out.println("Entramos al if"+data.getStatus().toString());
            flag=false;
            data.getPandora_check().setStatus(EStatus.ACCEPT_FARMER_TRUCK_IN.toString());}
        if (data.getPandora_check().getStatus().equalsIgnoreCase("accept_farmer_water_dg")||data.getPandora_check().getStatus().equals(EStatus.ACCEPT_FARMER_WATER_DG.toString())){
        System.out.println("Entramos al if"+data.getStatus().toString());
            flag=false;
            data.getPandora_check().setStatus(EStatus.ACCEPT_FARMER_WATER_DG.toString());}
        if (data.getPandora_check().getStatus().equalsIgnoreCase("reject_farmer_truck_in")||data.getPandora_check().getStatus().equals(EStatus.REJECT_FARMER_TRUCK_IN.toString())){
        System.out.println("Entramos al if"+data.getStatus().toString());
            flag=false;
            data.getPandora_check().setStatus(EStatus.REJECT_FARMER_TRUCK_IN.toString());}
        if (data.getPandora_check().getStatus().equalsIgnoreCase("reject_farmer_water_dg")||data.getPandora_check().getStatus().equals(EStatus.REJECT_FARMER_WATER_DG.toString())){
        System.out.println("Entramos al if"+data.getStatus().toString());
            flag=false;
            data.getPandora_check().setStatus(EStatus.REJECT_FARMER_WATER_DG.toString());}
        if (data.getPandora_check().getStatus().equalsIgnoreCase("reject_truck_in_accepted_water_dg")||data.getPandora_check().getStatus().equals(EStatus.REJECT_TRUCK_IN_ACCEPTED_WATER_DG.toString())){
        System.out.println("Entramos al if"+data.getStatus().toString());
            flag=false;
            data.getPandora_check().setStatus(EStatus.REJECT_TRUCK_IN_ACCEPTED_WATER_DG.toString());}
        if (data.getPandora_check().getStatus().equalsIgnoreCase("reject_water_dg_accepted_truck_in")||data.getPandora_check().getStatus().equals(EStatus.REJECT_WATER_DG_ACCEPTED_TRUCK_IN.toString())){
        System.out.println("Entramos al if"+data.getStatus().toString());
            flag=false;
            data.getPandora_check().setStatus(EStatus.REJECT_WATER_DG_ACCEPTED_TRUCK_IN.toString());}
        if (data.getPandora_check().getStatus().equalsIgnoreCase("reject_truck_in_and_water_dg")||data.getPandora_check().getStatus().equals(EStatus.REJECT_TRUCK_IN_AND_WATER_DG.toString())){
        System.out.println("Entramos al if"+data.getStatus().toString());
            flag=false;
            data.getPandora_check().setStatus(EStatus.REJECT_TRUCK_IN_AND_WATER_DG.toString());}
        if (data.getPandora_check().getStatus().equalsIgnoreCase("accept_checkin")||data.getPandora_check().getStatus().equals(EStatus.ACCEPT_CHECKIN.toString())){
        System.out.println("Entramos al if"+data.getStatus().toString());
            flag=false;
            data.getPandora_check().setStatus(EStatus.ACCEPT_CHECKIN.toString());}

        System.out.println("el valor del flag vale" +flag.toString());
        return flag;



    }
    private static ResponseEntity<Map<String, String>> ValidateData(BindingResult result) {
        Map<String,String> errores= new HashMap<>();
        result.getFieldErrors().forEach(err->{
            errores.put(err.getField(),"El campo"+" "+err.getField()+" "+err.getDefaultMessage());

        });
        return ResponseEntity.badRequest().body(errores);
    }



}
