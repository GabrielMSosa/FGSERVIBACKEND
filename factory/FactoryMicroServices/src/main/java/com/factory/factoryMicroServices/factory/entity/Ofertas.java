/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.factory.factoryMicroServices.factory.entity;

import com.factory.factoryMicroServices.factory.entity.BasculaParametro;
import com.factory.factoryMicroServices.factory.entity.Datouser_factory;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.util.Date;
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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
@Entity(name = "ofertas")
public class Ofertas {
   
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    
    @NotNull
    @Column(name = "idUser")
    private Long idUser;
    
    
    
    @NotNull
    @Column(name = "nombre_campo")
    private String nombre_campo;
    
    @NotNull
    @Column(name = "te_verde_certificado")
    private Float te_verde_certificado;
    
    @NotNull
    @Column(name = "te_verde_no_certificado")
    private Float te_verde_no_certificado;
    
    @NotNull
    @Column(name = "te_verde_palo")
    private Float te_verde_palo;
    
    @NotNull
    @Column(name = "data_receiving_first")
     @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date data_receiving_first;
    @NotNull
    @Column(name = "data_receiving_last")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date data_receiving_last;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="ofertas_ID", nullable=false)
    private Set<BasculaParametro> basculaParametro=new HashSet<>();
   
 /*   

  @ManyToMany(fetch = FetchType.LAZY,
      cascade = {
          CascadeType.PERSIST,
          CascadeType.MERGE
      },
      mappedBy = "ofertas")
         @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private Set<Datouser_factory> datouser_factory= new HashSet<>() ;
       
*/

    
}
