/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.farmer.farmerservices.factory.repository;

import com.farmer.farmerservices.factory.entity.BasculaParametro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gabriel
 */

@Repository
public interface IRepoBascula extends JpaRepository<BasculaParametro, Long>  {
    
}
