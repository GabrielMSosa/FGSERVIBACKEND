/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.authservice.auth.models;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

/**
 *
 * @author gabriel
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserMQQT {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String username;

@Basic
@Temporal(TemporalType.TIMESTAMP)
private java.util.Calendar calendarTimestamp;
  
  
  private Set<Role> roles = new HashSet<>();    


}
