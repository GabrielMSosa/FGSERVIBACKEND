/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.frontend.msvcfrontend.Menu.MenuEntity;

import java.io.Serializable;
import java.util.Optional;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 *
 * @author gabriel
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "menu")
public class Menu implements Serializable {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "text")
    private String text;
    @Column(name = "icon")
    private String icon;
    @Column(name = "routerLink")
    private String routerLink;
    
            @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
            @JoinColumn(name = "children_id")
            private Set<Children>  children;
     
            
  
            
            
            
    
    
    
}
