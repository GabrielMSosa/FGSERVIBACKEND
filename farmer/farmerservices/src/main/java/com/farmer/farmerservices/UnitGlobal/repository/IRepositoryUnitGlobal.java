/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.farmer.farmerservices.UnitGlobal.repository;


import com.farmer.farmerservices.UnitGlobal.entity.UnitTransaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 *
 * 
 * 
 *
 * @author gabriel
 */
@Repository
public interface IRepositoryUnitGlobal extends JpaRepository<UnitTransaccion, Long> {
    
}
