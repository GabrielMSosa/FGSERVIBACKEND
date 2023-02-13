/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.factory.factoryMicroServices.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author gabriel
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignUpFullDataRequest {
    

    
    private Long id;

    @NotBlank
    @Size(min = 4, max = 20)
    private String name;
    @NotBlank
    @Size(min = 4, max = 20)
    private String lastname;
    
    @NotBlank
    @Size(min = 4, max = 20)
    private String username;
    
    @NotBlank
    @Size(min = 4, max = 20)
    private String password;
    
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;
    @NotBlank
    @Size(min = 4, max = 20)
    private String celphone;
    
    @NotBlank
    @Size(min = 4, max = 20)
    private String datebrith;
    
    @NotBlank
    @Size(min = 4, max = 30)
    private String tipousuerValue;
    @NotBlank
    @Size(min = 4, max = 30)
    private String nameFactory;
    
    




}
