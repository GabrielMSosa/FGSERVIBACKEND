package com.pandoracheckout.checkout.repository;

import com.pandoracheckout.checkout.entity.PandoraCheckFarmer;
import com.pandoracheckout.checkout.entity.PosCheckinFar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReporPandoraCheck extends JpaRepository<PandoraCheckFarmer,Long> {
}
