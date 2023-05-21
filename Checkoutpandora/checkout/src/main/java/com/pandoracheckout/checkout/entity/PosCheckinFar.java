/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pandoracheckout.checkout.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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


    @NotEmpty
    @Column(name = "status")
    private String status;
    
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pandora_check_id")
    private PandoraCheckFarmer pandora_check;
    

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "truck_id")
    private Mytruck truck;



    
    
}
