package com.authservice.auth.security.services;

//import com.authservice.auth.kafka.LoginServicesKafka;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.authservice.auth.models.User;
import com.authservice.auth.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
  @Autowired
  UserRepository userRepository;

//  @Autowired
 // LoginServicesKafka servi;
  
 
  @Override
  @Transactional
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException  {
    User user = userRepository.findByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
  
  
    
      
    return UserDetailsImpl.build(user);
  }

}
