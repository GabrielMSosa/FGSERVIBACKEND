package com.pandoracheckout.checkout.repository;

import com.pandoracheckout.checkout.entity.Mytruck;
import com.pandoracheckout.checkout.entity.PandoraCheckFarmer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepotrucks extends JpaRepository<Mytruck,Long> {
}
