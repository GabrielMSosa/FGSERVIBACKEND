/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.farmer.farmerservices.campo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//import com.example.demo.campo.entity.Transaccion_te;
//import com.example.demo.campo.entity.Datauser_campo;
import java.util.HashSet;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

/** 
 *
 * @author gabriel
 */




@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tenomdec")
public class TeNomDec {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotNull
    @Column(name = "nombrecampo",length = 200)
    private String nombrecampo;
    
    @NotNull
    @Column(name = "idUser")
    private Long idUser;
    
    
    
    @NotNull    
    @Column(name = "cant_te_certificado_nominal",length = 200)
    private Float cant_te_certificado_nominal;
    
    
    @NotNull    
    @Column(name = "cant_te_sin_certificado_nominal",length = 200)
    private Float  cant_te_sin_certificado_nominal ;
    
    
    
        @NotNull
    @Column(name = "cant_te_palo_nominal",length = 200)
    private Float cant_te_palo_nominal;
  
    
    
    //nose porque el mappedby esta tirando tando errores se soluciono agregando target entitty
    /*
    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,
      cascade = {
          CascadeType.PERSIST,
          CascadeType.MERGE
      },
      mappedBy = "tenominal")
     private Set<Datauser_campo> datauser=new HashSet<>();
      */ 
       //one to many unidireccional
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "transaccion_te_id")
    private Set<Transaccion_te> transaccion_te;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "mytrucks_id")
    private Set<Mytruck> mytrucks=new HashSet<>();
    
    
    
    
    
    
}
