/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.farmer.farmerservices.UnitGlobal.repository;


import com.farmer.farmerservices.UnitGlobal.entity.UnitTransTransaccTe;
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
public interface IRepoUnitTranssaccTe extends JpaRepository<UnitTransTransaccTe, Long>{
    
    @Query(value="select * from bootdb.unit_trans_transacc_te as A INNER JOIN bootdb.unittransaccion as B ON B.id=A.unittrans_id WHERE B.id_userfarmer=:iduserfarmer AND B.id_userfactory=:iduserfactory AND  B.ack_campo=true AND B.reject_campo=false",nativeQuery = true)
    List<UnitTransTransaccTe> findByIdUserfactoryandAckFarmer(@Param("iduserfactory") Long iduserfactory,@Param("iduserfarmer") Long iduserfarmer );
    
    
}
