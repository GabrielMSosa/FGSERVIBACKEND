package com.pandoracheckout.checkout.entity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class IPKSubStatus implements Serializable {

    @NotNull
    private Long iduserfactory;
    @NotNull
    private Long iduserfarmer;
    @NotEmpty
    private String status;
    @NotEmpty
    private String substatus;

}
