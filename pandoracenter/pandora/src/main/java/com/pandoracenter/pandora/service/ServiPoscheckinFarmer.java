/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pandoracenter.pandora.service;

import com.pandoracenter.pandora.entity.EStatus;
import com.pandoracenter.pandora.entity.IPKstatus;
import com.pandoracenter.pandora.entity.IPk;
import com.pandoracenter.pandora.entity.PosCheckinFar;
import com.pandoracenter.pandora.repository.IRepoPoscheckiFar;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import org.springframework.stereotype.Service;

/**
 *
 * @author gabriel
 */
@Service
@Transactional
public class ServiPoscheckinFarmer implements IServiPoscheckinFarmer {

    @Autowired
    private IRepoPoscheckiFar repofar;

    @Override
    public List<PosCheckinFar>  FindMydataackfarmer(Long id) {
        
       return repofar.findByIdUserfactoryandAckFarmer(id);        
    }

    @Override
    public List<PosCheckinFar> FindMydataackfactory(Long id) {
        
    
    return repofar.findByIdUserfactoryandAckFactory(id);
    
    }

    @Override
    public PosCheckinFar SaveGeneric(PosCheckinFar data) {
        return repofar.save(data);
    }

    @Override
    public List<PosCheckinFar> ReturnAllPoscheckin() {
        return repofar.findAll();
    }

    @Override
    public List<PosCheckinFar> ReturnAllPoscheckinxPk(IPk data) {
        return repofar.findAllxIPk(data.getIduserfactory(),data.getIduserfarmer());
    }

    @Override
    public List<PosCheckinFar> ReturnAllPoscheckinxPkandstatus(IPKstatus data) {
        return repofar.findByIdUserfactoryandStatus(data.getIduserfactory(), data.getIduserfarmer(),data.getStatus());
    }

    @Override
    public List<PosCheckinFar> FindMydataallstatus(Long id) {
       return repofar.findByIdUserfactoryAllstatus(id);
    }

    @Override
    public PosCheckinFar SavebyFarmer(PosCheckinFar data) {
        PosCheckinFar x = new PosCheckinFar();
        PosCheckinFar y=  new PosCheckinFar();
        
          try {
          x= repofar.save(data);
        } catch (DataAccessException ex) {

            System.out.println(ex.getCause().getMessage());
              return y;
        }
        return x;
       }


    @Override
    public PosCheckinFar AuditbyFarmerAccepted(PosCheckinFar data) {
        //aca lo que hacemos es solo cambiar el estado a accept_factory
        //en auditoria empezamos a usar el status de pandora check que estaba en none.
        //y agregamos el status accept_check in en el status ; claro este es el camino feliz.

        PosCheckinFar x = new PosCheckinFar();
        x=repofar.findByIdUserfactoryandAckFarmerandStatus(data.getPandora_check().getIdUserfactory(),data.getPandora_check().getIdUserfarmer(),EStatus.ACCEPT_FACTORY_WATER_DG.toString() );
        System.out.println("-------------------------");
        System.out.println(x.toString());
        System.out.println("-------------------------");
        if (data.getStatus().equals(EStatus.ACCEPT_FARMER_TRUCK_IN.toString())){

            x.getPandora_check().setStatus(EStatus.ACCEPT_FARMER_TRUCK_IN.toString());
            repofar.save(x);
        }
        if (data.getStatus().equals(EStatus.ACCEPT_FARMER_WATER_DG.toString())&&x.getPandora_check().getStatus().equals(EStatus.ACCEPT_FARMER_TRUCK_IN.toString()))
        {

            x.setStatus(EStatus.ACCEPT_CHECKIN.toString());
            x.getPandora_check().setStatus(EStatus.ACCEPT_FARMER_WATER_DG.toString());
            repofar.save(x);

        }
    return x;
    }

    @Override
    public PosCheckinFar AuditbyFarmerRejected(PosCheckinFar data) {
        PosCheckinFar x = new PosCheckinFar();

        x=repofar.findByIdUserfactoryandAckFarmerandStatus(data.getPandora_check().getIdUserfactory(),data.getPandora_check().getIdUserfarmer(), EStatus.ACCEPT_FACTORY_WATER_DG.toString() );
        if (data.getStatus().equals(EStatus.REJECT_FARMER_TRUCK_IN.toString()))
        {
            x.setStatus(EStatus.ACCEPT_FACTORY.toString());
            x.getPandora_check().setStatus(EStatus.REJECT_TRUCK_IN_ACCEPTED_WATER_DG.toString());
            x.getTruck().setWeigh_truck_in(1.0F);


        }
        if (data.getStatus().equals(EStatus.REJECT_FARMER_WATER_DG.toString())&&x.getPandora_check().getStatus().equals(EStatus.REJECT_TRUCK_IN_ACCEPTED_WATER_DG.toString())){
            x.setStatus(EStatus.ACCEPT_FACTORY_TRUCK_IN.toString());
            x.getPandora_check().setStatus(EStatus.REJECT_TRUCK_IN_AND_WATER_DG.toString());
            x.getTruck().setQuantity_water(1.0F);

        }
        if (data.getStatus().equals(EStatus.REJECT_FARMER_WATER_DG.toString())&&x.getPandora_check().getStatus().equals(EStatus.ACCEPT_FACTORY_TRUCK_IN.toString())){
            x.setStatus(EStatus.ACCEPT_FACTORY_TRUCK_IN.toString());
            x.getPandora_check().setStatus(EStatus.REJECT_WATER_DG_ACCEPTED_TRUCK_IN.toString());
            x.getTruck().setQuantity_water(1.0F);


        }

    return  repofar.save(x);



    }

    @Override
    public PosCheckinFar ChangebyFactory(PosCheckinFar data) {
        //aca lo que hacemos es solo cambiar el estado a accept_factory
        PosCheckinFar x = new PosCheckinFar();
        x=repofar.findByIdUserfactoryandAckFarmerandStatus(data.getPandora_check().getIdUserfactory(),data.getPandora_check().getIdUserfarmer(), data.getStatus());
        System.out.println("el valor encontrado en la db"+x.toString());
        if (x==null) {
            System.out.println("no encontramos nada retornamos null x ");
            return x;
        }
        else{
                if (data.getTruck().getWeigh_truck_in()!=1.0&& data.getStatus().equals(EStatus.ACCEPT_FACTORY.toString())){
                    System.out.println("ingresando truckin"+data.getTruck().getWeigh_truck_in());
                    x.getTruck().setWeigh_truck_in(data.getTruck().getWeigh_truck_in());
                    x.setStatus(EStatus.ACCEPT_FACTORY_TRUCK_IN.toString());
                }
                if (data.getTruck().getQuantity_water()!=1.0&&data.getStatus().equals(EStatus.ACCEPT_FACTORY_TRUCK_IN.toString())){
                x.getTruck().setQuantity_water(data.getTruck().getQuantity_water());
                    System.out.println("ingresando humedad"+data.getTruck().getQuantity_water());
                x.setStatus(EStatus.ACCEPT_FACTORY_WATER_DG.toString());
            }
            if (data.getTruck().getQuantity_water()==1.0||data.getTruck().getWeigh_truck_in()==1.0){
                    System.out.println("no encontramos salidas");
                }


            repofar.save(x);
        }
        return x;

    }

    @Override
    public PosCheckinFar SavebyFactory(PosCheckinFar data) {

        //aca lo que hacemos es solo cambiar el estado a accept_factory
        PosCheckinFar x = new PosCheckinFar();
        //(@Param("iduserfactory") Long iduserfactory,@Param("iduserfarmer") Long iduserfarmer,@Param("status") String status )
        x=repofar.findByIdUserfactoryandAckFarmerandStatus(data.getPandora_check().getIdUserfactory(),data.getPandora_check().getIdUserfarmer(), data.getStatus());
        if (x==null) {
            System.out.println("no encontramos nada retornamos null x ");
            return x;
        }
        else{
        x.setStatus(EStatus.ACCEPT_FACTORY.toString());
            repofar.save(x);
        }
        return x;
    }
}
