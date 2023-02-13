/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.authservice.auth.models;

import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author gabriel
 */

@Getter
@Builder
@ToString
@Data
public class ConnValidationResponse {
    private String status;
    private boolean isAuthenticated;
    private String methodType;
    private String username;
    private String token;
    private List<GrantedAuthority> authorities;
}