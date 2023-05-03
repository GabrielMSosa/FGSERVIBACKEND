package com.pandoracheckout.checkout.controller;

import com.netflix.discovery.converters.Auto;
import com.pandoracheckout.checkout.client.PandoraCenterClientRest;
import com.pandoracheckout.checkout.entity.*;
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
                .body(client.TraePoscheckinIpkdata(data));
            }

    @PostMapping("/acceptCheckout")
    ResponseEntity<?> AcceptCheckou(@Valid @RequestBody Checkout data, BindingResult result){
        //cambiamos el list por ? para enviar bad request
        if (result.hasErrors()){
            return ValidateData(result);
        }
        ResponseEntity<Object> build = ValidStauts(data);
        if (build != null) return build;

        return ResponseEntity.status(HttpStatus.OK)
                .body(servi.savecheckout(data));

    }
    @PostMapping("/searchchkout")
    ResponseEntity<?> SearchCheckou(@Valid @RequestBody Checkout data, BindingResult result){
        if (result.hasErrors()){
            return ValidateData(result);
        }
        ResponseEntity<Object> build = ValidStauts(data);
        if (build != null) return build;

        return ResponseEntity.status(HttpStatus.OK)
                .body(servi.savecheckout(data));

    }











    private static ResponseEntity<Object> ValidStauts(Checkout data) {
        if(!data.getStatus().equalsIgnoreCase(StatusOut.REJECT_FACTORY_TRUCK_OUT.toString()) || !data.getSubstatus().equalsIgnoreCase(StatusOut.REJECT_FACTORY_TRUCK_OUT.toString())){
            return ResponseEntity.badRequest().build();
        }
        if(!data.getStatus().equalsIgnoreCase(StatusOut.ACCEPT_CHECKOUT.toString()) || !data.getSubstatus().equalsIgnoreCase(StatusOut.ACCEPT_CHECKOUT.toString())){
            return ResponseEntity.badRequest().build();
        }
        if(!data.getStatus().equalsIgnoreCase(StatusOut.REJECT_FARMER_TRUCK_OUT.toString()) || !data.getSubstatus().equalsIgnoreCase(StatusOut.REJECT_FARMER_TRUCK_OUT.toString())){
            return ResponseEntity.badRequest().build();
        }
        if(!data.getStatus().equalsIgnoreCase(StatusOut.ACCEPT_FARMER.toString()) || !data.getSubstatus().equalsIgnoreCase(StatusOut.ACCEPT_FARMER.toString())){
            return ResponseEntity.badRequest().build();
        }
        if(!data.getStatus().equalsIgnoreCase(StatusOut.ACCEPT_FACTORY.toString()) || !data.getSubstatus().equalsIgnoreCase(StatusOut.ACCEPT_FACTORY.toString())){
            return ResponseEntity.badRequest().build();
        }
        if(!data.getStatus().equalsIgnoreCase(StatusOut.REJECT_FARMER.toString()) || !data.getSubstatus().equalsIgnoreCase(StatusOut.REJECT_FARMER.toString())){
            return ResponseEntity.badRequest().build();
        }
        if(!data.getStatus().equalsIgnoreCase(StatusOut.REJECT_FACTORY.toString()) || !data.getSubstatus().equalsIgnoreCase(StatusOut.REJECT_FACTORY.toString())){
            return ResponseEntity.badRequest().build();
        }
        if(!data.getStatus().equalsIgnoreCase(StatusOut.ACCEPT_FACTORY_TRUCK_OUT.toString()) || !data.getSubstatus().equalsIgnoreCase(StatusOut.ACCEPT_FACTORY_TRUCK_OUT.toString())){
            return ResponseEntity.badRequest().build();
        }
        if(!data.getStatus().equalsIgnoreCase(StatusOut.ACCEPT_FARMER_TRUCK_OUT.toString()) || !data.getSubstatus().equalsIgnoreCase(StatusOut.ACCEPT_FARMER_TRUCK_OUT.toString())){
            return ResponseEntity.badRequest().build();
        }
        if(!data.getStatus().equalsIgnoreCase(StatusOut.AUDIT.toString()) || !data.getSubstatus().equalsIgnoreCase(StatusOut.AUDIT.toString())){
            return ResponseEntity.badRequest().build();
        }
        return null;
    }


    private static ResponseEntity<Map<String, String>> ValidateData(BindingResult result) {
        Map<String,String> errores= new HashMap<>();
        result.getFieldErrors().forEach(err->{
            errores.put(err.getField(),"El campo"+err.getField()+""+err.getDefaultMessage());

        });
        return ResponseEntity.badRequest().body(errores);
    }


}
