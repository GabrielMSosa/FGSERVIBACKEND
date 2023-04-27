package com.pandoracenter.pandora.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IPKstatus implements Serializable {
    @NotNull
    private Long iduserfactory;
    @NotNull
    private Long iduserfarmer;
    @NotBlank
    private String status;

}
