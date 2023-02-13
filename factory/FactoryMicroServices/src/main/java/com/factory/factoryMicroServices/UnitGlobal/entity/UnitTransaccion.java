/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.factory.factoryMicroServices.UnitGlobal.entity;

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
 * Esta entidad va a tener informacion de las transacciones el id del user que hace la peticion
 * 
 * 
 * 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "unittransaccion")
public class UnitTransaccion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    
    @NotNull
    @Column(name = "idUserfactory")
    private Long idUserfactory;

    @NotNull
    @Column(name = "idUserfarmer")
    private Long idUserfarmer;
    
    
    @NotNull
    @Column(name = "idTenomdec")
    private Long idTenomdec;
            
    @NotNull
    @Column(name = "idtransaccion")
    private Long idtransaccion;
    
    @NotNull
    @Column(name = "transacciUUID")    
    private String transacciUUID;
    
    @NotNull
    @Column(name = "ack_campo")    
    private Boolean ack_campo;
    
    @NotNull
    @Column(name = "reject_campo")    
    private Boolean reject_campo;
    
    
    //si los campos ack campo y recect campo estan en falso  es porque no se actualizo la novedad.
    //Es decir que ni rechazo ni ni acepto.
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
