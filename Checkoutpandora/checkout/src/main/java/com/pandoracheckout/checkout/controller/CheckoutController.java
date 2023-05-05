package com.pandoracheckout.checkout.controller;

import com.netflix.discovery.converters.Auto;
import com.pandoracheckout.checkout.client.PandoraCenterClientRest;
import com.pandoracheckout.checkout.entity.*;
import com.pandoracheckout.checkout.repository.IRepoCheckout;
import com.pandoracheckout.checkout.service.IServiceCheckout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;


//checkout

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/pandoraout")
public class CheckoutController {
    @Autowired
    private IRepoCheckout repo;
@Autowired
private PandoraCenterClientRest client;
@Autowired
private IServiceCheckout servi;
    @PostMapping("/checkoutpk")
    ResponseEntity<?> ReturnAllfarmeraxPk(@Valid @RequestBody IPk data, BindingResult result){
        //cambiamos el list por ? para enviar bad request
        if (result.hasErrors()){
            return ValidateData(result);
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body(client.TraePoscheckin(data));

    }

    @PostMapping("/checkoutpkstatus")
    ResponseEntity<?> ReturnAllfarmeraxPkstatus(@Valid @RequestBody IPKstatus data, BindingResult result){
        //cambiamos el list por ? para enviar bad request
        if (result.hasErrors()){
            return ValidateData(result);
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body(servi.ReturnAllnoUsed(data));
            }

    @PostMapping("/checkoutpkstatusvalid")
    ResponseEntity<?> ReturnAllfarmeraxPkstatusValid(@Valid @RequestBody IPKstatus data, BindingResult result){
        //cambiamos el list por ? para enviar bad request
        if (result.hasErrors()){
            return ValidateData(result);
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body(servi.ReturnAllnoUsed(data));
    }


    @PostMapping("/acceptcheckout")
    ResponseEntity<?> AcceptCheckou(@Valid @RequestBody Checkout data, BindingResult result){
        //cambiamos el list por ? para enviar bad request


        if (result.hasErrors()){
            return ValidateData(result);
        }
        if(repo.existsByParamIdanduuid(data.getPoscheckin().getPandora_check().getIdUserfactory(),data.getPoscheckin().getPandora_check().getIdUserfarmer(),data.getStatus(), data.getSubstatus(),data.getPoscheckin().getPandora_check().getTransacc_id().toString())>=1){

            return ResponseEntity.badRequest().body(Collections.singletonMap("Error","Valor ya fue guardado!"));
        }
        else{

        if((       data.getStatus().equalsIgnoreCase(StatusOut.REJECT_FACTORY_TRUCK_OUT.toString())
                ||data.getStatus().equalsIgnoreCase(StatusOut.ACCEPT_CHECKOUT.toString())
                ||data.getStatus().equalsIgnoreCase(StatusOut.ACCEPT_CHECKOUT.toString())
                ||data.getStatus().equalsIgnoreCase(StatusOut.REJECT_FARMER_TRUCK_OUT.toString())
                ||data.getStatus().equalsIgnoreCase(StatusOut.ACCEPT_FARMER.toString())
                ||data.getStatus().equalsIgnoreCase(StatusOut.ACCEPT_FACTORY.toString())
                ||data.getStatus().equalsIgnoreCase(StatusOut.REJECT_FARMER.toString())
                ||data.getStatus().equalsIgnoreCase(StatusOut.REJECT_FACTORY.toString())
                ||data.getStatus().equalsIgnoreCase(StatusOut.ACCEPT_FACTORY_TRUCK_OUT.toString())
                ||data.getStatus().equalsIgnoreCase(StatusOut.ACCEPT_FARMER_TRUCK_OUT.toString())
                ||data.getStatus().equalsIgnoreCase(StatusOut.AUDIT.toString()) )&&(
                         data.getSubstatus().equalsIgnoreCase(StatusOut.REJECT_FACTORY_TRUCK_OUT.toString())
                                 || data.getSubstatus().equalsIgnoreCase(StatusOut.ACCEPT_CHECKOUT.toString())
                        ||data.getSubstatus().equalsIgnoreCase(StatusOut.ACCEPT_CHECKOUT.toString())
                        ||data.getSubstatus().equalsIgnoreCase(StatusOut.REJECT_FARMER_TRUCK_OUT.toString())
                        ||data.getSubstatus().equalsIgnoreCase(StatusOut.ACCEPT_FARMER.toString())
                        ||data.getSubstatus().equalsIgnoreCase(StatusOut.ACCEPT_FACTORY.toString())
                        ||data.getSubstatus().equalsIgnoreCase(StatusOut.REJECT_FARMER.toString())
                        ||data.getSubstatus().equalsIgnoreCase(StatusOut.REJECT_FACTORY.toString())
                        ||data.getSubstatus().equalsIgnoreCase(StatusOut.ACCEPT_FACTORY_TRUCK_OUT.toString())
                        ||data.getSubstatus().equalsIgnoreCase(StatusOut.ACCEPT_FARMER_TRUCK_OUT.toString())
                        ||data.getSubstatus().equalsIgnoreCase(StatusOut.AUDIT.toString()))){

            System.out.println("pasamos el ok."+data.toString());
            return ResponseEntity.status(HttpStatus.OK)
                    .body(servi.savecheckout(data));

        }
                   else{


            return ResponseEntity.badRequest().body(Collections.singletonMap("Error","Status fuera de rango"));

        }
        }



    }
    @PostMapping("/searchchkout")
    ResponseEntity<?> SearchCheckou(@Valid @RequestBody IPKSubStatus data, BindingResult result){
        if (result.hasErrors()){
            return ValidateData(result);
        }

        return ResponseEntity.status(HttpStatus.OK)
                .body(servi.Searchdata(data));

    }

    @PutMapping("/editcheckout/{id}")
    ResponseEntity<?> Editdata(@Valid @RequestBody Checkout data, BindingResult result,@PathVariable Long id){
        if (result.hasErrors()){
            return ValidateData(result);
        }

        if((       data.getStatus().equalsIgnoreCase(StatusOut.REJECT_FACTORY_TRUCK_OUT.toString())
                ||data.getStatus().equalsIgnoreCase(StatusOut.ACCEPT_CHECKOUT.toString())
                ||data.getStatus().equalsIgnoreCase(StatusOut.ACCEPT_CHECKOUT.toString())
                ||data.getStatus().equalsIgnoreCase(StatusOut.REJECT_FARMER_TRUCK_OUT.toString())
                ||data.getStatus().equalsIgnoreCase(StatusOut.ACCEPT_FARMER.toString())
                ||data.getStatus().equalsIgnoreCase(StatusOut.ACCEPT_FACTORY.toString())
                ||data.getStatus().equalsIgnoreCase(StatusOut.REJECT_FARMER.toString())
                ||data.getStatus().equalsIgnoreCase(StatusOut.REJECT_FACTORY.toString())
                ||data.getStatus().equalsIgnoreCase(StatusOut.ACCEPT_FACTORY_TRUCK_OUT.toString())
                ||data.getStatus().equalsIgnoreCase(StatusOut.ACCEPT_FARMER_TRUCK_OUT.toString())
                ||data.getStatus().equalsIgnoreCase(StatusOut.AUDIT.toString()) )&&(
                data.getSubstatus().equalsIgnoreCase(StatusOut.REJECT_FACTORY_TRUCK_OUT.toString())
                        || data.getSubstatus().equalsIgnoreCase(StatusOut.ACCEPT_CHECKOUT.toString())
                        ||data.getSubstatus().equalsIgnoreCase(StatusOut.ACCEPT_CHECKOUT.toString())
                        ||data.getSubstatus().equalsIgnoreCase(StatusOut.REJECT_FARMER_TRUCK_OUT.toString())
                        ||data.getSubstatus().equalsIgnoreCase(StatusOut.ACCEPT_FARMER.toString())
                        ||data.getSubstatus().equalsIgnoreCase(StatusOut.ACCEPT_FACTORY.toString())
                        ||data.getSubstatus().equalsIgnoreCase(StatusOut.REJECT_FARMER.toString())
                        ||data.getSubstatus().equalsIgnoreCase(StatusOut.REJECT_FACTORY.toString())
                        ||data.getSubstatus().equalsIgnoreCase(StatusOut.ACCEPT_FACTORY_TRUCK_OUT.toString())
                        ||data.getSubstatus().equalsIgnoreCase(StatusOut.ACCEPT_FARMER_TRUCK_OUT.toString())
                        ||data.getSubstatus().equalsIgnoreCase(StatusOut.AUDIT.toString()))){

            System.out.println("pasamos el ok."+data.toString());
            return ResponseEntity.status(HttpStatus.OK)
                    .body(servi.EditCheckOut(data,id));//el id del POJO este caso Checkout

        }
        else{

            return ResponseEntity.badRequest().body(Collections.singletonMap("Error","Status fuera de rango"));

        }







    }

    @PostMapping("/searchchkoutbin")
    ResponseEntity<?> ReturnOk(@Valid @RequestBody IPKSubStatus data, BindingResult result){
        if (result.hasErrors()){
            return ValidateData(result);
        }
    if(repo.existsByParamIdandStatus(data.getIduserfactory(),data.getIduserfarmer(),data.getStatus(), data.getSubstatus())>=1){
        return ResponseEntity.status(HttpStatus.OK)
                .body(Collections.singletonMap("Salida","Valor encontrado exitosamente"));}
    else{
        return ResponseEntity.badRequest().body(Collections.singletonMap("Error","Valor no encontrado"));


    }


    }














    private static ResponseEntity<Map<String, String>> ValidateData(BindingResult result) {
        Map<String,String> errores= new HashMap<>();
        result.getFieldErrors().forEach(err->{
            errores.put(err.getField(),"El campo"+err.getField()+""+err.getDefaultMessage());

        });
        return ResponseEntity.badRequest().body(errores);
    }


}
