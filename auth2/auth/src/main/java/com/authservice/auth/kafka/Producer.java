/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.authservice.auth.kafka;

import com.authservice.auth.models.User;
import com.authservice.auth.models.UserMQ;
import com.authservice.auth.models.UserMQQT;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 *
 * @author gabriel
 */

@Slf4j
@Component
public class Producer {

    @Value("${topic.name}")
    private String orderTopic;

    private final ObjectMapper objectMapper;
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public Producer(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    
    
    public String sendMessage(UserMQQT user) throws JsonProcessingException {
        String orderAsMessage = objectMapper.writeValueAsString(user);
        kafkaTemplate.send(orderTopic, orderAsMessage);

        log.info(" msg sent to topid t.login.access {}", orderAsMessage);

        return "message sent";
    }
}