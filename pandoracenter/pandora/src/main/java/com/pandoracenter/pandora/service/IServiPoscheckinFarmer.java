/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.pandoracenter.pandora.service;

import com.pandoracenter.pandora.entity.PosCheckinFar;
import java.util.List;

/**
 *
 * @author gabriel
 */
public interface IServiPoscheckinFarmer {
    
    public PosCheckinFar SavebyFarmer(PosCheckinFar data);
    
    public List<PosCheckinFar> FindMydata(Long id);
    
}
