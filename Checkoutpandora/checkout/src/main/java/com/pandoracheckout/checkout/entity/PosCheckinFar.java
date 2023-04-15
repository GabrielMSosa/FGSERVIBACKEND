/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pandoracheckout.checkout.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
@Entity(name = "poscheckinfar")
public class PosCheckinFar {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    
    @NotNull
    @Column(name = "status")
    private String status;
    
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pandora_check_id")
    private PandoraCheckFarmer pandora_check;
    
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "truck_id")
    private Mytruck truck;
    
   
    
    
    
}
