package com.pandoracheckout.checkout.repository;

import com.pandoracheckout.checkout.entity.Checkout;
import com.pandoracheckout.checkout.entity.PosCheckinFar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRepoPoshchekin extends JpaRepository<PosCheckinFar,Long> {


    @Query(value="select * from pandoradbout.poscheckinfar as a INNER JOIN pandoradbout.pandoracheckfarmer as b  ON a.pandora_check_id = b.id WHERE a.status=:status AND b.id_userfactory=:iduserfactory AND b.id_userfarmer=:iduserfarmer",nativeQuery = true)
    List<PosCheckinFar> findByIdUserfactoryandStatus(@Param("iduserfactory") Long iduserfactory, @Param("iduserfarmer") Long iduserfarmer, @Param("status") String status );







}
