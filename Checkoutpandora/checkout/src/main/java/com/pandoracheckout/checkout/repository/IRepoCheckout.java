package com.pandoracheckout.checkout.repository;

import com.pandoracheckout.checkout.entity.Checkout;
import com.pandoracheckout.checkout.entity.PosCheckinFar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Repository
public interface IRepoCheckout extends JpaRepository<Checkout,Long> {

    @Query(value="select * from pandoradbout.checkout as a INNER JOIN pandoradbout.poscheckinfar as b  ON a.poscheckin_id = b.id INNER JOIN pandoradbout.pandoracheckfarmer as c ON b.pandora_check_id=c.id WHERE c.id_userfactory=:iduserfactory AND c.id_userfarmer=:iduserfarmer AND a.status=:status AND a.substatus=:substatusa ;",nativeQuery = true)
    List<Checkout> findByIdandStatus( @Param("iduserfactory") Long iduserfactory,@Param("iduserfarmer") Long iduserfarmer, @Param("status") String status,@Param("substatusa") String substatusa);

    @Query(value="select COUNT(a.id) = 1 from pandoradbout.checkout as a INNER JOIN pandoradbout.poscheckinfar as b  ON a.poscheckin_id = b.id INNER JOIN pandoradbout.pandoracheckfarmer as c ON b.pandora_check_id=c.id WHERE c.id_userfactory=:iduserfactory AND c.id_userfarmer=:iduserfarmer AND a.status=:status AND a.substatus=:substatusa ;",nativeQuery = true)
    Integer existsByParamIdandStatus( @Param("iduserfactory") Long iduserfactory,@Param("iduserfarmer") Long iduserfarmer, @Param("status") String status,@Param("substatusa") String substatusa);

    @Query(value="select COUNT(a.id) = 1 from pandoradbout.checkout as a INNER JOIN pandoradbout.poscheckinfar as b  ON a.poscheckin_id = b.id INNER JOIN pandoradbout.pandoracheckfarmer as c ON b.pandora_check_id=c.id WHERE c.id_userfactory=:iduserfactory AND c.id_userfarmer=:iduserfarmer AND a.status=:status AND a.substatus=:substatusa AND c.transacc_id=:transacc_id ;",nativeQuery = true)
    Integer existsByParamIdanduuid( @Param("iduserfactory") Long iduserfactory,@Param("iduserfarmer") Long iduserfarmer, @Param("status") String status,@Param("substatusa") String substatusa,@Param("transacc_id") String transacc_id);



}
