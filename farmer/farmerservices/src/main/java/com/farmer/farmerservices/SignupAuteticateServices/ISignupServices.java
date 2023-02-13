/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.farmer.farmerservices.SignupAuteticateServices;

import com.farmer.farmerservices.KVS.EntityMatchIdUserKVS;
import com.farmer.farmerservices.ResponsePersonalData.ResponsePersonalData;
import com.farmer.farmerservices.models.User;
import com.farmer.farmerservices.request.SignUpFullDataRequest;

/**
 *
 * @author gabriel
 */
public interface ISignupServices {
    
    
    public String CreateUserFullData(User user,SignUpFullDataRequest signUpFullDataRequest);
    
    public ResponsePersonalData ReturnPersonalData(Long id);
    
    
    
    
    
    
    
    
    
    
    
    
}
