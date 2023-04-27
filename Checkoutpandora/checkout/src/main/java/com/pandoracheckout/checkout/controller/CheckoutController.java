package com.pandoracheckout.checkout.controller;

import com.netflix.discovery.converters.Auto;
import com.pandoracheckout.checkout.client.PandoraCenterClientRest;
import com.pandoracheckout.checkout.entity.Checkout;
import com.pandoracheckout.checkout.entity.IPKstatus;
import com.pandoracheckout.checkout.entity.IPk;
import com.pandoracheckout.checkout.entity.PosCheckinFar;
import com.pandoracheckout.checkout.service.IServiceCheckout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
        return ResponseEntity.status(HttpStatus.OK)
                .body(servi.savecheckout(data));

    }



















    private static ResponseEntity<Map<String, String>> ValidateData(BindingResult result) {
        Map<String,String> errores= new HashMap<>();
        result.getFieldErrors().forEach(err->{
            errores.put(err.getField(),"El campo"+err.getField()+""+err.getDefaultMessage());

        });
        return ResponseEntity.badRequest().body(errores);
    }


}
