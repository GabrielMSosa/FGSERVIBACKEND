package com.pandoracheckout.checkout.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "checkout")
public class Checkout {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    @Column(name = "status",columnDefinition = "varchar(255) default 'NONE_PANDORA'")
    private String status;

    @NotEmpty
    @Column(name = "substatus",columnDefinition = "varchar(255) default 'NONE_PANDORA_SUB'")
    private String substatus;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "poscheckin_id")
    private PosCheckinFar poscheckin;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "truck_id")
    private Mytruck truck;




}
