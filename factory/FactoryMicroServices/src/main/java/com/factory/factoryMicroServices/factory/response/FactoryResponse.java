/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.factory.factoryMicroServices.factory.response;

import com.factory.factoryMicroServices.factory.entity.Datouser_factory;
import com.factory.factoryMicroServices.factory.entity.Ofertas;
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
