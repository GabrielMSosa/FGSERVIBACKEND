package com.pandoracheckin.farmer.ClienHttp;

import com.pandoracheckin.farmer.DTO.IPk;
import com.pandoracheckin.farmer.UnitGlobal.entity.UnitTransTransaccTe;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@FeignClient(name = "farmer-service")
public interface ClientFarmer {

    @PostMapping("/unit/retallpk")
    public List<UnitTransTransaccTe> TraeUnitporIPk(@RequestBody IPk data);

}


