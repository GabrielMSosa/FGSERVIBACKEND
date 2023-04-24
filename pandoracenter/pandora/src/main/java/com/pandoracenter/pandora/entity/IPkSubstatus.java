package com.pandoracenter.pandora.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Data
public class IPkSubstatus implements Serializable {

    @NotNull
    private Long iduserfactory;
    @NotNull
    private Long iduserfarmer;
    @NotBlank
    private String status;
    @NotBlank
    private String substatus;

}
