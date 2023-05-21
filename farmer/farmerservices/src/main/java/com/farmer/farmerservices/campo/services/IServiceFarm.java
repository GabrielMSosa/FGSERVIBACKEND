/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.farmer.farmerservices.campo.services;

import com.farmer.farmerservices.campo.entity.Datauser_campo;
import com.farmer.farmerservices.campo.entity.Mytruck;
import com.farmer.farmerservices.campo.entity.TeNomDec;
import com.farmer.farmerservices.campo.entity.Transaccion_te;
import com.farmer.farmerservices.campo.response.CampoResponse;
import com.farmer.farmerservices.factory.entity.Datouser_factory;
import java.util.List;
import java.util.Set;

/**
 *
 * @author gabriel
 */
public interface IServiceFarm {


     public List<TeNomDec> GetTeNomAll();

     public Set<TeNomDec> ReturnTruckforIdDataUser(Long id);
     public TeNomDec DeleteTruckforIdDataUser(Long idtnominal,Mytruck datadelet);//el id de tenominal
      
    public Datauser_campo LoadCampo(TeNomDec data);
    
    public Datauser_campo GetByID(Long id);

    public TeNomDec GetTeNomById(Long id);
    
    public TeNomDec AddTransaccTe(TeNomDec data);
    
    
    public Transaccion_te GetTetransacciById(Long id);
    
    public TeNomDec AddTruckforTenomDec(Mytruck data, Long id);//agregamos el id de tenom dec
    
    public TeNomDec AddTransaccionTe(Transaccion_te data, Long id);

    public Set<TeNomDec> GetTenomByIdUser(Long id);

    public void DeleteTransacc(Long id);
    
}
