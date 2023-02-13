/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.authservice.auth.Menu.MenuController;

import com.authservice.auth.Menu.MenuEntity.DTOMenu;
import com.authservice.auth.Menu.MenuEntity.Menu;
import com.authservice.auth.Menu.MenuService.IServiMenu;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author gabriel
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/fronend/menu")
public class FrontEndMenu {
    @Autowired
    private IServiMenu servi;
    
    
    
    @PostMapping("/write")
    public String WriteMenu(@RequestBody Menu data ){
    
    return servi.InsertMenu(data);
}
    
    
    @GetMapping("/read")
    @PreAuthorize("hasRole('ROLE_FACTORY') or hasRole('ADMIN') or hasRole('ROLE_PROPIETARIOS')")
    public List<Menu> AllMenuFactory(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

      Set<String> roles = authentication.getAuthorities().stream()
     .map(r -> r.getAuthority()).collect(Collectors.toSet());
      System.out.println("roles valen "+roles);
        
        
        System.out.println("este endpoint es para factory");
        return servi.TraerMenu(roles);
        
    }
    
    
    
       
}