/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pandoracheckin.farmer.campo.entity;

import com.pandoracheckin.farmer.models.User;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import com.pandoracheckin.farmer.campo.entity.TeNomDec;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.HashSet;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

/**
 *
 * @author gabriel
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "datauser_campo")
public class Datauser_campo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotNull
    @Column(name = "titulo",length = 200)
    private String titulo;
    
    @NotNull
    @Column(name = "telefono",length = 200)
    private String telefono;    
    
    @NotNull
    @Column(name = "fecha_creacion",length = 200)
    private String fecha_creacion;

    
    /*
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "users_id")
    private User user;
    */


        @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
        @JoinColumn(name = "datausercampo_id")  
    private Set<TeNomDec> tenominal=new HashSet<>();
    

    }


