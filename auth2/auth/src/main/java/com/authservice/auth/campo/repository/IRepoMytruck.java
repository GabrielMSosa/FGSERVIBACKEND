/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.authservice.auth.campo.repository;


import com.authservice.auth.campo.entity.Mytruck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 *
 * @author gabriel
 */


@Repository
public interface IRepoMytruck extends JpaRepository<Mytruck, Long> {
    
}
