package com.pandoracheckout.checkout.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
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
