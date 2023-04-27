package com.pandoracheckin.farmer.ClienHttp;

import com.pandoracheckin.farmer.DTO.IPk;
import com.pandoracheckin.farmer.DTO.PosCheckinFar;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@FeignClient(name = "pandoracenter-service")
public interface PandoraCenterClient {

    @PostMapping("/pandoraposcheckin/allposcheckinpk")
    public List<PosCheckinFar> traerdata( @RequestBody IPk data);

}
