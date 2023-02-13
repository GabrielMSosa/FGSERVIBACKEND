/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.farmer.farmerservices.KVS;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author gabriel
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "matchiduserkvs")
public class EntityMatchIdUserKVS {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        
        @NotNull
        @Column(name = "pkuser")
        private Long pkuser;//este es el PK del user del login
        @NotNull
        @Column(name = "pkdata") 
        private Long pkdata;

        @NotNull
        @Column(name = "tipo")
        private String tipo;//aca vamos a guardar el tipo de usuario que vamos a guardar campo o factory;
        
    
}
