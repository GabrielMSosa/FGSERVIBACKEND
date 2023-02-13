/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.farmer.farmerservices.factory.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

    /**
 *
 * @author gabriel
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "basculaparametro")
public class BasculaParametro {

    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
     
    //tengo que enviar el parametro vacio y ahi lo genera solo
    @NotNull
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "transaccion_truck",unique = true)
    private UUID transaccion_truck= UUID.randomUUID();
    
    
    @NotNull
    @Column(name = "idUser")
    private Long idUser;
    
    
    @NotNull
    @Column(name = "brand_camion")
    private String brand_camion;//marca de camion
    
    @NotNull
    @Column(name = "id_truck")
    private String id_truck;
    
    @NotNull
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
    
    @NotNull
    @Column(name = "ack_carrier")
    private String ack_carrier;
    
    
    
    
    
   
}
