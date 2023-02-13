/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.farmer.farmerservices.campo.repository;

import com.farmer.farmerservices.campo.entity.Transaccion_te;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gabriel
 */




@Repository
public interface IRepoTransaccionTe extends JpaRepository<Transaccion_te, Long> {


    List<Transaccion_te> findByIdUser(Long idUser);



    
}

