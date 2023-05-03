package com.pandoracheckout.checkout.service;

import com.pandoracheckout.checkout.entity.Checkout;
import com.pandoracheckout.checkout.entity.IPKSubStatus;
import com.pandoracheckout.checkout.entity.PosCheckinFar;
import org.hibernate.annotations.Check;

public interface IServiceCheckout {


public Checkout savecheckout(Checkout data);
public Checkout Searchdata(IPKSubStatus data);

}
