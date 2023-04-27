package com.pandoracheckout.checkout.client;

import com.pandoracheckout.checkout.entity.IPKstatus;
import com.pandoracheckout.checkout.entity.IPk;
import com.pandoracheckout.checkout.entity.PosCheckinFar;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "pandoracenter-service")
public interface PandoraCenterClientRest {


    @PostMapping("/pandoraposcheckin/allposcheckinpk")
    public List<PosCheckinFar> TraePoscheckin(@RequestBody IPk data);

    @PostMapping("/pandoraposcheckin/return/allstatusandid")
    public List<PosCheckinFar> TraePoscheckinIpkdata(@RequestBody IPKstatus data);


    @PostMapping("/pandoraposcheckin/audit/master")
    PosCheckinFar Saveposcheckin(@RequestBody PosCheckinFar data);

}
