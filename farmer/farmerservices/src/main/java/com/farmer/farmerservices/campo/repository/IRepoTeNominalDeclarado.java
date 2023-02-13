/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.farmer.farmerservices.campo.repository;

import com.farmer.farmerservices.campo.entity.TeNomDec;
import com.farmer.farmerservices.campo.entity.TeNomDec;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 *
 * @author gabriel
 */


@Repository
public interface IRepoTeNominalDeclarado extends JpaRepository<TeNomDec, Long>  {

    Optional<TeNomDec> findByIdUser(Long idUser);
    
}

