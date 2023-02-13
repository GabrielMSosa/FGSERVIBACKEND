/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.authservice.auth.SignupAuteticateServices;

import com.authservice.auth.KVS.EntityMatchIdUserKVS;
import com.authservice.auth.ResponsePersonalData.ResponsePersonalData;
import com.authservice.auth.models.User;
import com.authservice.auth.payload.request.SignUpFullDataRequest;



/**
 *
 * @author gabriel
 */
public interface ISignupServices {
    
    
    public String CreateUserFullData(User user,SignUpFullDataRequest signUpFullDataRequest);
    
    public ResponsePersonalData ReturnPersonalData(Long id);
    
    
    
    
    
    
    
    
    
    
    
    
}
