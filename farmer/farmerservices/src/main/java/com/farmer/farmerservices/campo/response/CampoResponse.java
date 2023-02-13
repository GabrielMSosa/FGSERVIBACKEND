/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.farmer.farmerservices.campo.response;

import com.farmer.farmerservices.campo.entity.Datauser_campo;
import com.farmer.farmerservices.campo.entity.TeNomDec;
import com.farmer.farmerservices.campo.entity.Transaccion_te;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author gabriel
 */
@Data
public class CampoResponse implements Serializable {
    
    private Datauser_campo datauser;
    
    private TeNomDec tenominal;
    
    private Transaccion_te transacc;
    
    
    
}
