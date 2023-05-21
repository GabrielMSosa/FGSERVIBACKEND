package com.pandoracheckout.checkout.service;

import com.pandoracheckout.checkout.entity.Checkout;
import com.pandoracheckout.checkout.entity.IPKSubStatus;
import com.pandoracheckout.checkout.entity.IPKstatus;
import com.pandoracheckout.checkout.entity.PosCheckinFar;
import org.hibernate.annotations.Check;

import java.util.List;

public interface IServiceCheckout {

    public Checkout EditCheckOut(Checkout data,Long id);
public Checkout savecheckout(Checkout data);
public List<Checkout> Searchdata(IPKSubStatus data);
public  List<PosCheckinFar> ReturnAllnoUsed(IPKstatus data);

    public List<Checkout> SearchdataByID(IPKSubStatus data);
    public List<Checkout> SearchdataByIDFarmer(IPKSubStatus data);
    public List<Checkout>  Searchbyfarmer(Long data);
    public List<Checkout>  Searchbyfactory(Long data);



}
