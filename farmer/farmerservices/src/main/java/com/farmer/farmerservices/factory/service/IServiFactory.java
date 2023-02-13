/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.farmer.farmerservices.factory.service;

import com.farmer.farmerservices.factory.entity.BasculaParametro;
import com.farmer.farmerservices.factory.entity.Datouser_factory;
import com.farmer.farmerservices.factory.entity.Ofertas;
import com.farmer.farmerservices.factory.repository.IRepoDatoUser;
import com.farmer.farmerservices.factory.response.FactoryResponse;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author gabriel
 */
public interface IServiFactory {
 
    
    public String AddDatoUser(Datouser_factory  data);
    
    public String CreateDataUserFactory(Datouser_factory data);
    
    
    
    public Ofertas AddBascula(BasculaParametro  data, Long id);
    
    public Ofertas AddOferta(Ofertas data, Long id);
    
    public List<Datouser_factory> GetAllDatouserFactory();

    
    public Ofertas GetOfertasByID(Long id);
    
    public Datouser_factory GetByID(Long id);
    
    public List<Ofertas> GetAllDatas();
    
    
    }
