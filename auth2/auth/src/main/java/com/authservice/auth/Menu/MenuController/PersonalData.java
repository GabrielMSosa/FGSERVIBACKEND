
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.authservice.auth.Menu.MenuController;



import com.authservice.auth.ResponsePersonalData.ResponsePersonalData;
import com.authservice.auth.SignupAuteticateServices.ISignupServices;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author gabriel
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/pdata")
public class PersonalData {
    
    @Autowired
    private ISignupServices servi;
    
    @GetMapping("/{id}")
        @PreAuthorize("hasRole('ROLE_FACTORY') or hasRole('ROLE_PROPIETARIOS')")
    public ResponseEntity<ResponsePersonalData> AllMenuFactory(@PathVariable Long id){
        System.out.println("este endpoint es para farmer");
        return ResponseEntity.status(HttpStatus.OK).
                            body(servi.ReturnPersonalData(id));
        
    }
    
    
    
    
}
