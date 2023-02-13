/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.farmer.farmerservices.KVS;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gabriel
 */
@Repository
public interface IRepoKvs extends JpaRepository<EntityMatchIdUserKVS, Long> {

	EntityMatchIdUserKVS findByPkuser(Long pkuser);
        
        EntityMatchIdUserKVS findByPkdata(Long pkdata);
        
        



    
}
