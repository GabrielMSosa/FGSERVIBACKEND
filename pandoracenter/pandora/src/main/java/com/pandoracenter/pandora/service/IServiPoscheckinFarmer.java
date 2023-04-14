/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.pandoracenter.pandora.service;

import com.pandoracenter.pandora.entity.IPKstatus;
import com.pandoracenter.pandora.entity.IPk;
import com.pandoracenter.pandora.entity.PosCheckinFar;
import java.util.List;

/**
 *
 * @author gabriel
 */
public interface IServiPoscheckinFarmer {
    
    public PosCheckinFar SavebyFarmer(PosCheckinFar data);
    
    public List<PosCheckinFar> FindMydataackfarmer(Long id);
    public List<PosCheckinFar> FindMydataackfactory(Long id);
    public List<PosCheckinFar> ReturnAllPoscheckin();
    public List<PosCheckinFar> ReturnAllPoscheckinxPk(IPk data);


    public List<PosCheckinFar> ReturnAllPoscheckinxPkandstatus(IPKstatus data);

    public List<PosCheckinFar> FindMydataallstatus(Long id);

    public PosCheckinFar SavebyFactory(PosCheckinFar data);
    public PosCheckinFar ChangebyFactory(PosCheckinFar data);
    public PosCheckinFar AuditbyFarmerAccepted(PosCheckinFar data);
    public PosCheckinFar AuditbyFarmerRejected(PosCheckinFar data);

    public PosCheckinFar SaveGeneric(PosCheckinFar data);
}
