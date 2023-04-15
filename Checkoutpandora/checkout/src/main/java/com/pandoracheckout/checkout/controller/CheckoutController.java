package com.pandoracheckout.checkout.controller;

import com.netflix.discovery.converters.Auto;
import com.pandoracheckout.checkout.client.PandoraCenterClientRest;
import com.pandoracheckout.checkout.entity.IPk;
import com.pandoracheckout.checkout.entity.PosCheckinFar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;




@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/checkout")
public class CheckoutController {
@Autowired
private PandoraCenterClientRest client;

    @PostMapping("/checkoutpk")
    ResponseEntity<List<PosCheckinFar>> ReturnAllfarmerxPk(@RequestBody IPk data){

        return ResponseEntity.status(HttpStatus.OK)
                .body(client.TraePoscheckin(data));

    }








}
