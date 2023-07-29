package com.pandoracheckout.checkout.service;


import com.pandoracheckout.checkout.client.PandoraCenterClientRest;
import com.pandoracheckout.checkout.entity.*;
import com.pandoracheckout.checkout.repository.IRepoCheckout;
import com.pandoracheckout.checkout.repository.IRepoPoshchekin;
import com.pandoracheckout.checkout.repository.IReporPandoraCheck;
import com.pandoracheckout.checkout.repository.IRepotrucks;
import org.hibernate.annotations.Check;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Service

public class ServiceCheckout implements IServiceCheckout{
    @Autowired
    private PandoraCenterClientRest client;
    @Autowired
    private IRepoCheckout repo;

    @Autowired
    private IRepotrucks repotruck;
    @Autowired
    private IReporPandoraCheck reporPandoraCheck;
    @Autowired
    private IRepoPoshchekin repoPoshchekin;


    @Override
    @Transactional
    public Checkout savecheckout(Checkout data) {
        Checkout dtsen=new Checkout();
        Mytruck mytruck=repotruck.save(data.getPoscheckin().getTruck());
    //SI O SI GUARDAR EN ORDEN POR HIBERNEATE TIRA ERROR DE CLAVE DUPLICADA U OTRO TIPÓ


        PandoraCheckFarmer pandoraCheckFarmer=reporPandoraCheck.save(data.getPoscheckin().getPandora_check());
        PosCheckinFar dtsave=new PosCheckinFar();
        dtsave.setStatus(data.getPoscheckin().getStatus());
        dtsave.setPandora_check(pandoraCheckFarmer);
        dtsave.setTruck(mytruck);

       PosCheckinFar posCheckinFar=repoPoshchekin.save(dtsave);
       dtsen.setPoscheckin(posCheckinFar);
       dtsen.setSubstatus(data.getSubstatus());
       dtsen.setStatus(data.getStatus());
       return repo.save(dtsen);

    }

    @Override
    public List<Checkout>  Searchbyfarmer(Long data) {
        return repo.findByIdFarmerNoStatus(data);
         }

    @Override
    public List<Checkout>  Searchbyfactory(Long data) {
        return  repo.findByIdFactoryNoStatus(data);
    }

    @Override
    public List<Checkout> SearchdataByID(IPKSubStatus data) {
        return repo.findByIdFactory(data.getIduserfactory(), data.getStatus(), data.getSubstatus());
    }

    @Override
    public List<Checkout> SearchdataByIDFarmer(IPKSubStatus data) {
        return repo.findByIdFarmer(data.getIduserfarmer() ,data.getStatus(), data.getSubstatus());
    }

    @Override
    @Transactional
    public Checkout EditCheckOut(Checkout data, Long id) {
        Checkout dtsearch= repo.findById(id).orElseThrow();
        dtsearch.setSubstatus(data.getSubstatus());
        dtsearch.setStatus(data.getStatus());
        dtsearch.getPoscheckin().setStatus(data.getPoscheckin().getStatus());
        dtsearch.getPoscheckin().getPandora_check().setName(data.getPoscheckin().getPandora_check().getName());
        dtsearch.getPoscheckin().getPandora_check().setStatus(data.getPoscheckin().getPandora_check().getStatus());
        dtsearch.getPoscheckin().getPandora_check().setIdUserfarmer(data.getPoscheckin().getPandora_check().getIdUserfarmer());
        dtsearch.getPoscheckin().getPandora_check().setIdUserfactory(data.getPoscheckin().getPandora_check().getIdUserfactory());
        dtsearch.getPoscheckin().getPandora_check().setTransacc_id(data.getPoscheckin().getPandora_check().getTransacc_id());
        dtsearch.getPoscheckin().getPandora_check().setCant_te_no_certi_nominal_now(data.getPoscheckin().getPandora_check().getCant_te_no_certi_nominal_now());
        dtsearch.getPoscheckin().getPandora_check().setCant_te_certi_nominal_now(data.getPoscheckin().getPandora_check().getCant_te_certi_nominal_now());
        dtsearch.getPoscheckin().getPandora_check().setCant_te_palo_nominal_now(data.getPoscheckin().getPandora_check().getCant_te_palo_nominal_now());
        dtsearch.getPoscheckin().getPandora_check().setData_delivery_first(data.getPoscheckin().getPandora_check().getData_delivery_first());
        dtsearch.getPoscheckin().getPandora_check().setData_delivery_last(data.getPoscheckin().getPandora_check().getData_delivery_last());

        dtsearch.getPoscheckin().getTruck().setId_truck(data.getPoscheckin().getTruck().getId_truck());
        dtsearch.getPoscheckin().getTruck().setWeigh_truck_in(data.getPoscheckin().getTruck().getWeigh_truck_in());
        dtsearch.getPoscheckin().getTruck().setQuantity_water(data.getPoscheckin().getTruck().getQuantity_water());
        dtsearch.getPoscheckin().getTruck().setWeigh_truck_out(data.getPoscheckin().getTruck().getWeigh_truck_out());
        dtsearch.getPoscheckin().getTruck().setBrand_camion(data.getPoscheckin().getTruck().getBrand_camion());
        dtsearch.getPoscheckin().getTruck().setName_carrier(data.getPoscheckin().getTruck().getName_carrier());

        return repo.save(dtsearch);

    }

    @Override
    public List<Checkout> Searchdata(IPKSubStatus data) {
    return repo.findByIdandStatus(data.getIduserfactory(),data.getIduserfarmer(),data.getStatus(), data.getSubstatus());

    }

    @Override
    @Transactional
    public List<PosCheckinFar> ReturnAllnoUsed(IPKstatus data) {
        List<PosCheckinFar> dataout=new ArrayList<>();
        List<PosCheckinFar> resultdb=repoPoshchekin.findByIdUserfactoryandStatus(data.getIduserfactory(), data.getIduserfarmer(), data.getStatus());
        System.out.println("valor encontrado en bdd"+resultdb.toString());
        List<UUID>  uuiddiff= new ArrayList<>();
        PosCheckinFar aux= new PosCheckinFar();
        List<PosCheckinFar> resulclient =client.TraePoscheckinIpkdata(data);
        System.out.println("valor encontrado en client"+resulclient.toString());
        //declaramos iteradores
        Iterator<PosCheckinFar> resultdbiter=resultdb.iterator();
        Iterator<PosCheckinFar> resulclientiter=resulclient.iterator();
        while(resultdbiter.hasNext()) {
            aux = resultdbiter.next();
            uuiddiff.add(aux.getPandora_check().getTransacc_id());
        }
        System.out.println("valores encontrados de uuid"+uuiddiff.toString());

        Iterator<UUID> uuidIterator = uuiddiff.iterator();

        while (resulclientiter.hasNext()) {
            aux = resulclientiter.next();
            System.out.println("el valor es" + aux.toString());
            while (uuidIterator.hasNext()) {
                UUID uuidej = uuidIterator.next();
                if (aux.getPandora_check().getTransacc_id().equals(uuidej)) {
                    resulclientiter.remove();
                    System.out.println("removimos un valor");
                }

            }
            uuidIterator = uuiddiff.iterator();

        }











            return resulclient;
    }
}

