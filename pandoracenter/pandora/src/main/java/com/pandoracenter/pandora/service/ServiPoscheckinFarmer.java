/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pandoracenter.pandora.service;

import com.pandoracenter.pandora.entity.PosCheckinFar;
import com.pandoracenter.pandora.repository.IRepoPoscheckiFar;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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
    public PosCheckinFar SavebyFarmer(PosCheckinFar data) {
        PosCheckinFar x = new PosCheckinFar();

        
          try {
          x= repofar.save(data);
        } catch (DataAccessException ex) {

            System.out.println(ex.getCause().getMessage());
        }
        
        
        return x;
        
   
        
    }
    
    
}
