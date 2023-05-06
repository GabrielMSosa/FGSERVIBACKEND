/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.authservice.auth.campo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

/**
 *
 * @author gabriel
*/ 




@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="transaccion_te")
public class Transaccion_te {
        
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    
@NotNull    
    @Column(name = "idUser")
        private Long idUser;
    
    //tengo que enviar el parametro vacio y ahi lo genera solo
    
@NotNull
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "transacc_id",unique = true)
    @Type(type = "uuid-char")
    private UUID transacc_id= UUID.randomUUID();
   
   
@NotNull
    @Column(name = "cant_te_certi_nominal_now")
    private Float cant_te_certi_nominal_now;
@NotNull
    @Column(name = "cant_te_no_certi_nominal_now")
    private Float cant_te_no_certi_nominal_now;
    
    
@NotNull
    @Column(name = "data_delivery_first",length = 200)
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private String data_delivery_first;
    
    
@NotNull    
    @Column(name = "data_delivery_last",length = 200)
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private String data_delivery_last;

/*
      @JsonIgnore
      @ManyToOne
      @JoinColumn(name="tenomdec_id", nullable=false)
      private TeNomDec tenominial;

*/
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "transaccion_te_id")
    private Set<Mytruck> mytrucks=new HashSet<>();
        
    

}
