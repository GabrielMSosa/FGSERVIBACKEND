/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servicewebeg.egwebclien.model;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author gabriel
 */

@Getter
@ToString
@NoArgsConstructor
@Setter
public class ConnValidationResponse {
    private String status;
    private boolean isAuthenticated;
    private String methodType;
    private String username;
    private String token;
    private List<Authorities> authorities;
}