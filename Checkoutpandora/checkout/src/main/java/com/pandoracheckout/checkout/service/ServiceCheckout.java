package com.pandoracheckout.checkout.service;

import com.pandoracheckout.checkout.client.PandoraCenterClientRest;
import com.pandoracheckout.checkout.entity.Checkout;
import com.pandoracheckout.checkout.entity.IPKSubStatus;
import com.pandoracheckout.checkout.entity.PosCheckinFar;
import com.pandoracheckout.checkout.repository.IRepoCheckout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ServiceCheckout implements IServiceCheckout{
    @Autowired
    private PandoraCenterClientRest client;
    @Autowired
    private IRepoCheckout repo;
    @Override
    public Checkout savecheckout(Checkout data) {
        Checkout checkout = new Checkout();
        PosCheckinFar dataresp=new PosCheckinFar();
        try {
            dataresp = client.Saveposcheckin(data.getPoscheckin());
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
            return checkout;
        }

        //usamos el response por si falla no cargamos

        checkout.setPoscheckin(dataresp);
        checkout.setSubstatus(data.getSubstatus());

        checkout.setStatus(data.getStatus());

        return repo.save(checkout);

    }


    @Override
    public Checkout Searchdata(IPKSubStatus data) {



    }
}
