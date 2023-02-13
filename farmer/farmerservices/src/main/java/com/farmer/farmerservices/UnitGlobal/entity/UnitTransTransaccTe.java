/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.farmer.farmerservices.UnitGlobal.entity;

import com.farmer.farmerservices.campo.entity.Transaccion_te;
import com.sun.istack.NotNull;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
@Entity(name = "unitTransTransaccTe")
public class UnitTransTransaccTe implements Serializable {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

            @OneToOne(cascade = CascadeType.ALL)
            @JoinColumn(name = "unittrans_id")
            private UnitTransaccion unittrans;
       
       
            @OneToOne(cascade = CascadeType.ALL)
            @JoinColumn(name = "transate_id")
            private Transaccion_te transate;
    //PUEDO HACER ONE TO ONE PORQUE ESTAS ENTIDADES NO ESTAN ENLAZADAS CON NINGUNA OOTRAS ASI QUE VAMOS DE LUJO!
    
    
    
}



