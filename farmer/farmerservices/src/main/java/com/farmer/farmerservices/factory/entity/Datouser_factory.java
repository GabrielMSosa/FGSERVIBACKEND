/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.farmer.farmerservices.factory.entity;

import com.farmer.farmerservices.factory.entity.Ofertas;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
@Entity(name = "datouser_factory")
public class Datouser_factory {
    
        
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
    
        @NotNull
        @Column(name = "name_company",length = 200)
        private String name_company;
        
        
        @NotNull
        @Column(name = "telefono",length = 200)
        private String telefono;
        
        
        
        @NotNull
        @Column(name = "fecha_creacion",length = 200)
        private String fecha_creacion;

        
        /*
          @ManyToMany (fetch = FetchType.LAZY,
            cascade = {
          CascadeType.PERSIST,
          CascadeType.MERGE
                      })
        @JoinTable(name = "Datouser_factory_Project",
        joinColumns = { @JoinColumn(name = "datouser_factory_id") },
        inverseJoinColumns = { @JoinColumn(name = "ofertas_id") })
        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)  
        */
        
        @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
        @JoinColumn(name = "datouser_id")  
        private Set<Ofertas> ofertas= new HashSet<>();
        
}
