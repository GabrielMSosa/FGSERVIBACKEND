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
import javax.validation.constraints.NotEmpty;
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
@Entity(name = "mytruck")
public class Mytruck {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;




    @NotEmpty
    @Column(name = "brand_camion")
    private String brand_camion;//marca de camion

    @NotEmpty
    @Column(name = "id_truck")
    private String id_truck;

    @NotEmpty
    @Column(name = "name_carrier")
    private String name_carrier;

    @NotNull
    @Column(name = "weigh_truck_in")
    private Float weigh_truck_in;

    @NotNull
    @Column(name = "weigh_truck_out")
    private Float weigh_truck_out;

    @NotNull
    @Column(name = "quantity_water")
    private Float quantity_water;
    
  //  @OneToOne(cascade = CascadeType.ALL)
  //  @JoinColumn(name = "transaccion_te_id")
  //  private Transaccion_te transacc_id;
   
    
}