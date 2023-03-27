/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pandoracenter.pandora.service;

import com.pandoracenter.pandora.entity.IPk;
import com.pandoracenter.pandora.entity.PosCheckinFar;
import com.pandoracenter.pandora.repository.IRepoPoscheckiFar;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author gabriel
 */
@Service
@Transactional
public class ServiPoscheckinFarmer implements IServiPoscheckinFarmer {

    @Autowired
    private IRepoPoscheckiFar repofar;

    @Override
    public List<PosCheckinFar>  FindMydataackfarmer(Long id) {
        
       return repofar.findByIdUserfactoryandAckFarmer(id);        
    }

    @Override
    public List<PosCheckinFar> FindMydataackfactory(Long id) {
        
    
    return repofar.findByIdUserfactoryandAckFactory(id);
    
    }

    @Override
    public List<PosCheckinFar> ReturnAllPoscheckin() {
        return repofar.findAll();
    }

    @Override
    public List<PosCheckinFar> ReturnAllPoscheckinxPk(IPk data) {
        return repofar.findAllxIPk(data.getIduserfactory(),data.getIduserfarmer());
    }
    
    
    
    
    
    
    
    @Override
    public PosCheckinFar SavebyFarmer(PosCheckinFar data) {
        PosCheckinFar x = new PosCheckinFar();
        PosCheckinFar y=  new PosCheckinFar();
        
          try {
          x= repofar.save(data);
        } catch (DataAccessException ex) {

            System.out.println(ex.getCause().getMessage());
              return y;
        }
        
        
        return x;
        
   
        
    }
    
    
}
