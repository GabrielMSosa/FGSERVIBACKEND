/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.pandoracenter.pandora.repository;

import com.pandoracenter.pandora.entity.PosCheckinFar;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gabriel
 */
@Repository
public interface IRepoPoscheckiFar extends JpaRepository<PosCheckinFar, Long> {
    
    
    
    @Query(value="select * from pandoradb.poscheckinfar as a INNER JOIN pandoradb.pandoracheckfarmer as b  ON a.pandora_check_id = b.id WHERE a.status='ACCEPT_FARMER' AND b.id_userfactory=:iduserfactory",nativeQuery = true)
    List<PosCheckinFar> findByIdUserfactoryandAckFarmer(@Param("iduserfactory") Long iduserfactory );
    
    
    @Query(value="select * from pandoradb.poscheckinfar as a INNER JOIN pandoradb.pandoracheckfarmer as b  ON a.pandora_check_id = b.id WHERE a.status='ACCEPT_FACTORY' AND b.id_userfactory=:iduserfactory",nativeQuery = true)
    List<PosCheckinFar> findByIdUserfactoryandAckFactory(@Param("iduserfactory") Long iduserfactory );
    
    
    
}



