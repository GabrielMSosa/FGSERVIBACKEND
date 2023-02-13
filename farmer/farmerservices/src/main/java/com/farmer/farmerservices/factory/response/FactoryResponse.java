/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.farmer.farmerservices.factory.response;

import com.farmer.farmerservices.factory.entity.Datouser_factory;
import com.farmer.farmerservices.factory.entity.Ofertas;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author gabriel
 */
@Data
public class FactoryResponse implements Serializable {
    
    
    private Datouser_factory dato;
    
    private Ofertas oferta;
    
}
