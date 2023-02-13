package com.authservice.auth.controllers;

import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
  @GetMapping("/all")
  public String allAccess() {
    return "Public Content.";
  }

  @GetMapping("/user")
  @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
  public String userAccess() {
    return "User Content.";
  }

  @GetMapping("/mod")
  @PreAuthorize("hasRole('MODERATOR')")
  public String moderatorAccess() {
        
      Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

      Set<String> roles = authentication.getAuthorities().stream()
     .map(r -> r.getAuthority()).collect(Collectors.toSet());
      System.out.println("roles valen "+roles);
    return "Moderator Board.";
  }

  @GetMapping("/admin")
  @PreAuthorize("hasRole('ADMIN')")
  public String adminAccess() {
      
      Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

      Set<String> roles = authentication.getAuthorities().stream()
     .map(r -> r.getAuthority()).collect(Collectors.toSet());
      System.out.println("roles valen "+roles);
      
      
    return "Admin Board.";
  }
}
