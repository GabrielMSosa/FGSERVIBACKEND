/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.farmer.farmerservices.factory.service;

import com.farmer.farmerservices.factory.entity.BasculaParametro;
import com.farmer.farmerservices.factory.entity.Datouser_factory;
import com.farmer.farmerservices.factory.entity.Ofertas;
import com.farmer.farmerservices.factory.repository.IRepoBascula;
import com.farmer.farmerservices.factory.repository.IRepoDatoUser;
import com.farmer.farmerservices.factory.repository.IRepoOfertas;
import com.farmer.farmerservices.factory.response.FactoryResponse;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gabriel
 */
@Service
public class ServiceFactory implements IServiFactory{

    @Autowired
    private IRepoDatoUser repdato;
    @Autowired
    private IRepoBascula repbascula;
    @Autowired
    private IRepoOfertas repoferta;

    @Override
    public String CreateDataUserFactory(Datouser_factory data) {
    
        repdato.save(data);
        
        return "OK";
        
        
    }

    @Override
    public Datouser_factory GetByID(Long id) {
        
return   repdato.findById(id).orElseThrow();
    }
    
    
    @Override
    public Ofertas GetOfertasByID(Long id){
    
    
    return   repoferta.findById(id).orElseThrow();
    
    }

    @Override
    public List<Datouser_factory> GetAllDatouserFactory() {
    
        
        return repdato.findAll();
        
    }
    
    
    


    
    
    
    
    
    @Override
    public String AddDatoUser(Datouser_factory data) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        
        
        
    }

    @Override
    public Ofertas AddBascula(BasculaParametro data, Long id) {
       
       Ofertas x= repoferta.findById(id).orElseThrow();
       Set<BasculaParametro> dataout=x.getBasculaParametro();
       
       dataout.add(data);
       
       x.setBasculaParametro(dataout);

       return repoferta.save(x);
       
       
    }
    

    @Override
    public Ofertas AddOferta(Ofertas data, Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Ofertas> GetAllDatas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
    
    
}
