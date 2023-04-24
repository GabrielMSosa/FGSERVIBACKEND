/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pandoracenter.pandora.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
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
@Entity(name = "pandoracheckfarmer")
public class PandoraCheckFarmer {
      
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
       private Long id;

        @NotBlank
       @Column(name = "name")
       private String name;
       
         @NotNull
        @Column(name = "idUserfactory")
       private Long idUserfactory;
         @NotNull
        @Column(name = "idUserfarmer")
       private Long idUserfarmer;
            
       @Column(name = "status",columnDefinition = "varchar(255) default 'NONE_PANDORA'")
       @NotBlank
       private String status;
         
         @NotNull
       @GeneratedValue(generator="system-uuid")
       @GenericGenerator(name="system-uuid", strategy = "uuid")
       @Column(name = "transacc_id",unique = true)
       private UUID transacc_id= UUID.randomUUID();
       
       @NotNull
       @Column(name = "cant_te_certi_nominal_now")
       private Float cant_te_certi_nominal_now;
         @NotNull
         @Column(name = "cant_te_no_certi_nominal_now")
       private Float cant_te_no_certi_nominal_now;
         
         @NotNull
         @Column(name = "cant_te_palo_nominal_now")
       private Float cant_te_palo_nominal_now;

            @NotBlank
            @Column(name = "data_delivery_first")
            @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
       private String data_delivery_first;

            @NotBlank
            @Column(name = "data_delivery_last")
            @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
        private String data_delivery_last;     
    
}
