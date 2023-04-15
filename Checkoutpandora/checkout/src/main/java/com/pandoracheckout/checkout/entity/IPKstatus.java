package com.pandoracheckout.checkout.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IPKstatus implements Serializable {
    private Long iduserfactory;
    private Long iduserfarmer;
    private String status;

}
