package com.authservice.auth.controllers;


import com.authservice.auth.SignupAuteticateServices.ISignupServices;
import com.authservice.auth.kafka.LoginServicesKafka;
//import com.authservice.auth.kafka.LoginServicesKafka;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.authservice.auth.models.ERole;
import com.authservice.auth.models.Role;
import com.authservice.auth.models.User;
import com.authservice.auth.models.UserMQ;
import com.authservice.auth.payload.request.LoginRequest;
import com.authservice.auth.payload.request.SignUpFullDataRequest;
import com.authservice.auth.payload.request.SignupRequest;
import com.authservice.auth.response.JwtResponse;
import com.authservice.auth.response.MessageResponse;
import com.authservice.auth.repository.RoleRepository;
import com.authservice.auth.repository.UserRepository;
import com.authservice.auth.security.jwt.JwtUtils;
import com.authservice.auth.security.services.UserDetailsImpl;
import com.fasterxml.jackson.core.JsonProcessingException;

import org.springframework.context.annotation.Lazy;
import org.springframework.kafka.core.KafkaTemplate;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
    @RequestMapping("/auth")
public class AuthController {
  @Autowired
  AuthenticationManager authenticationManager;

  
  @Autowired
  private ISignupServices servi;

  
  @Autowired
  UserRepository userRepository;

  @Autowired
  RoleRepository roleRepository;

  @Autowired
  PasswordEncoder encoder;

  @Autowired
  JwtUtils jwtUtils;

  @Autowired
  LoginServicesKafka servikafka;

  
  
  
  @PostMapping("/signin")
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) throws JsonProcessingException {

    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = jwtUtils.generateJwtToken(authentication);
    
    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();    
    List<String> roles = userDetails.getAuthorities().stream()
        .map(item -> item.getAuthority())
        .collect(Collectors.toList());
      UserMQ valor=new UserMQ(loginRequest.getUsername());
      servikafka.createLoginOrder(valor);
		
        
    return ResponseEntity.ok(new JwtResponse(jwt, 
                         userDetails.getId(), 
                         userDetails.getUsername(), 
                         userDetails.getEmail(), 
                         roles));
    
    
  }

  @PostMapping("/signupfull")
 public ResponseEntity<?> registerFullUser( @Valid @RequestBody SignUpFullDataRequest signUpFullDataRequest) {
 
     //hacemos algunas validaciones
     if(userRepository.existsByUsername(signUpFullDataRequest.getUsername())){
     
     return ResponseEntity
             .badRequest()
             .body(new MessageResponse("Error Username is al ready taken!"));
            
     }
     
     if(userRepository.existsByEmail(signUpFullDataRequest.getEmail())){
     
         
         return ResponseEntity
                 .badRequest()
                 .body(new MessageResponse("Email is already exist!"));
    
     }
     
     User user= new User(signUpFullDataRequest.getUsername(), signUpFullDataRequest.getEmail(), encoder.encode(signUpFullDataRequest.getPassword()));
     //aca vamos a hacer las validaciones de roles segun el tipo 
     String tipouser=signUpFullDataRequest.getTipousuerValue();
     Set<Role> roles = new HashSet<>();
     if(tipouser==null){
     
         
         Role userRole = roleRepository.findByName(ERole.ROLE_USER)
          .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
      roles.add(userRole);
         System.out.println("vacio");
     
     }
     
     if(tipouser.equals("Propietario de Campo")){
          Role propRole = roleRepository.findByName(ERole.ROLE_PROPIETARIOS)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(propRole);
         System.out.println("elegimos propietarios");
     
     
     }
     
     if(tipouser.equals("Propietario de Secadero")){
          Role factRole = roleRepository.findByName(ERole.ROLE_FACTORY)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(factRole);
         
         System.out.println("secadero");
     }
     
     user.setRoles(roles);
     
     return ResponseEntity
             .ok(new MessageResponse(servi.CreateUserFullData(user, signUpFullDataRequest)));
     
     
 }
  
  //IMPORTANTE!!! CARGAR LOS ROLES EN LA BASE DE DATOS
  
  @PostMapping("/signup")
  public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
    if (userRepository.existsByUsername(signUpRequest.getUsername())) {
      return ResponseEntity
          .badRequest()
          .body(new MessageResponse("Error: Username is already taken!"));
    }

    if (userRepository.existsByEmail(signUpRequest.getEmail())) {
      return ResponseEntity
          .badRequest()
          .body(new MessageResponse("Error: Email is already in use!"));
    }

    // Create new user's account
    User user = new User(signUpRequest.getUsername(), 
               signUpRequest.getEmail(),
               encoder.encode(signUpRequest.getPassword()));

    Set<String> strRoles = signUpRequest.getRole();
    Set<Role> roles = new HashSet<>();

    if (strRoles == null) {
      Role userRole = roleRepository.findByName(ERole.ROLE_USER)
          .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
      roles.add(userRole);
    } else {
      strRoles.forEach(role -> {
        switch (role) {
        case "admin":
          Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(adminRole);

          break;
        case "mod":
          Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(modRole);

          break;
          //vamos agregar los dos roles nuevos
                  case "fact":
          Role factRole = roleRepository.findByName(ERole.ROLE_FACTORY)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(factRole);

          break;
          case "prop":
          Role propRole = roleRepository.findByName(ERole.ROLE_PROPIETARIOS)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(propRole);
          break;
          
          
        default:
          Role userRole = roleRepository.findByName(ERole.ROLE_USER)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(userRole);
        }
      });
    }

    user.setRoles(roles);
    userRepository.save(user);

    return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
  }
}
