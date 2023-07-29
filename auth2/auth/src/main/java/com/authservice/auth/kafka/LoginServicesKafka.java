/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
package com.authservice.auth.kafka;

import com.authservice.auth.models.User;
import com.authservice.auth.models.UserMQ;
import com.authservice.auth.models.UserMQQT;
import com.authservice.auth.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.time.LocalDateTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


 *
 * @author gabriel

 


@Slf4j
@Service
public class LoginServicesKafka {

        private final Producer producer;

    @Autowired
    public LoginServicesKafka(Producer producer) {
        this.producer = producer;
    }        
    
    
    @Autowired
    UserRepository userRepository;



    
    public String createLoginOrder(UserMQ  username) throws JsonProcessingException {
    
        User usersearch=userRepository.findByUsername(username.getUsername()).orElseThrow();
       // UserMQ valor= new UserMQ(usersearch.getUsername());
     UserMQQT  ftosend=new UserMQQT();
     ftosend.setRoles(usersearch.getRoles());
     ftosend.setUsername(usersearch.getUsername());
     ftosend.setId(usersearch.getId());
     
        this.producer.sendMessage( ftosend);
		return "Published Successfully";
        
    }
}
 */
