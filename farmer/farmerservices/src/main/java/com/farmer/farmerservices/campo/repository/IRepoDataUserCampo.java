/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.farmer.farmerservices.campo.repository;

import com.farmer.farmerservices.campo.entity.Datauser_campo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gabriel
 */


@Repository
public interface IRepoDataUserCampo extends JpaRepository<Datauser_campo, Long> {
    
}

