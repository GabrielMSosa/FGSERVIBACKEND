package com.pandoracheckout.checkout.repository;

import com.pandoracheckout.checkout.entity.Checkout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepoCheckout extends JpaRepository<Checkout,Long> {

}
