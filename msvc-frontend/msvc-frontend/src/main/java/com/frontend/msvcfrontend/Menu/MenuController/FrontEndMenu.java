/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.frontend.msvcfrontend.Menu.MenuController;

import com.frontend.msvcfrontend.Menu.MenuEntity.DTOMenu;
import com.frontend.msvcfrontend.Menu.MenuEntity.Menu;
import com.frontend.msvcfrontend.Menu.MenuService.IServiMenu;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
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
 
@RestController
@RequestMapping("/frontend/menu")
public class FrontEndMenu {
    @Autowired
    private IServiMenu servi;
    
    
       @CrossOrigin(origins = "*")
       @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/write")
    public String WriteMenu(@RequestBody Menu data ){
    
    return servi.InsertMenu(data);
}
    
     @CrossOrigin(origins = "*")
    @GetMapping("/read")
    @PreAuthorize("hasRole('ROLE_FACTORY') or hasRole('ADMIN') or hasRole('ROLE_PROPIETARIOS')")
    public List<Menu> AllMenuFactory(@AuthenticationPrincipal Jwt principal){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
       //    List<Menu> dummy= new ArrayList<>();
        
        
     Set<String> roles = authentication.getAuthorities().stream()
     .map(r -> r.getAuthority()).collect(Collectors.toSet());
      System.out.println("roles valen "+roles);
        
        
        System.out.println("este endpoint es para factory");
        return servi.TraerMenu(roles);
        
       // return dummy;
    }
    
   
       
}