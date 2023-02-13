/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.farmer.farmerservices.ResponsePersonalData;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author gabriel
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponsePersonalData implements Serializable {
    
    private Long id;
    
    private String name;
    
    private String cellphone;
    
    
    
    
}
