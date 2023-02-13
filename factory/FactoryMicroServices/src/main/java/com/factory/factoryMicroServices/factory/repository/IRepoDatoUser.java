/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.factory.factoryMicroServices.factory.repository;

import com.factory.factoryMicroServices.factory.entity.Datouser_factory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gabriel
 */
@Repository
public interface IRepoDatoUser extends JpaRepository< Datouser_factory , Long> {
    
}
