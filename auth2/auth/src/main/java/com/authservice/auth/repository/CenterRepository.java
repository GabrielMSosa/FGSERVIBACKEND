/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.authservice.auth.repository;

import com.authservice.auth.models.Center;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gasosa
 */
@Repository
public interface CenterRepository extends JpaRepository<Center, Long> {

    Boolean existsByCenter(String center);

    Optional<Center> findByCenter(String center);

}
