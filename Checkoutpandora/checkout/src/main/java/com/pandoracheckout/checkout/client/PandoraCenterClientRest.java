package com.pandoracheckout.checkout.client;

import com.pandoracheckout.checkout.entity.IPk;
import com.pandoracheckout.checkout.entity.PosCheckinFar;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "pandoracenter-service")
public interface PandoraCenterClientRest {


    @PostMapping("/pandoraposcheckin/allposcheckinpk")
    public List<PosCheckinFar> TraePoscheckin(@RequestBody IPk data);



}
