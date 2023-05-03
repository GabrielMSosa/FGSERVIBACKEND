package com.pandoracheckout.checkout.repository;

import com.pandoracheckout.checkout.entity.Checkout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRepoCheckout extends JpaRepository<Checkout,Long> {

    @Query(value="select * from pandoradb.checkout as a INNER JOIN pandoradb.poscheckinfar as b  ON a.poscheckin_id = b.id WHERE a.status='ACCEPT_FACTORY' AND b.id_userfactory=:iduserfactory",nativeQuery = true)
    List<Checkout> findByIdandStatus(@Param("iduserfactory") Long iduserfactory );


}
