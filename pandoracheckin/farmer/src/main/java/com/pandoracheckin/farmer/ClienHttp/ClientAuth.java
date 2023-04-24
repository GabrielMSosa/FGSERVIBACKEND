package com.pandoracheckin.farmer.ClienHttp;

import com.pandoracheckin.farmer.DTO.ResponsePersonalData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "auth-service")
public interface ClientAuth {


    @GetMapping("/pdata/{id}")
    public ResponsePersonalData AllMenuFactory(@RequestHeader("Authorization") String authHeader, @PathVariable Long id);

}

