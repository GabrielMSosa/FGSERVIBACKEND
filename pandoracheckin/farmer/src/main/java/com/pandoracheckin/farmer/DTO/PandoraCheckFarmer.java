/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pandoracheckin.farmer.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
public class PandoraCheckFarmer implements Serializable {
      
       @GeneratedValue(strategy = GenerationType.AUTO)
       private Long id;  
       private String name;
       private Long idUserfactory;
       private Long idUserfarmer;
       @NotNull
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "transacc_id",unique = true)
       private UUID transacc_id= UUID.randomUUID();
       private Float cant_te_certi_nominal_now;
       private Float cant_te_no_certi_nominal_now;
       private Float cant_te_palo_nominal_now;        
            @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
       private String data_delivery_first;  
            @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
        private String data_delivery_last;     
    
}
