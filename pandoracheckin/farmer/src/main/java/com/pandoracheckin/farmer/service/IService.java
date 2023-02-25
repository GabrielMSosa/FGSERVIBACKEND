/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.pandoracheckin.farmer.service;

import com.pandoracheckin.farmer.DTO.PandoraCheckFarmer;
import com.pandoracheckin.farmer.DTO.ResponsePersonalData;
import com.pandoracheckin.farmer.UnitGlobal.entity.UnitTransTransaccTe;
import java.util.List;

/**
 *
 * @author gabriel
 */
public interface IService {
    
    
    public List<PandoraCheckFarmer> ReturnAll(Long id,String token) ;
 
    public ResponsePersonalData SerachforId(Long id,String token) ;
    
    
    
}
