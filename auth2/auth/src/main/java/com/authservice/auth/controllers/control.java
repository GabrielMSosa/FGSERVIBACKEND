/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.authservice.auth.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author gabriel
 */

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/control/test")
public class control {
    
    
  @GetMapping("/all")
  public String allAccess() {
    return "private.";
  }
    
    
    
    
}
