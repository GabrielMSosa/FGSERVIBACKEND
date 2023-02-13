/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.authservice.auth.Menu.MenuEntity;

import java.io.Serializable;
import java.util.Optional;
import java.util.Set;
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
public class DTOMenu implements Serializable {

    
    
    private Long id;

    
    private String text;
    
    private String icon;
    
    private Optional<String> routerLink;
    
    private Optional<Set<Children>> children;
    
    
    
    
    
    
}
