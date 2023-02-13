/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.farmer.farmerservices.UnitGlobal.services;

import com.farmer.farmerservices.KVS.IRepoKvs;
import com.farmer.farmerservices.UnitGlobal.entity.UnitTransTransaccTe;
import com.farmer.farmerservices.UnitGlobal.entity.UnitTransaccion;
import com.farmer.farmerservices.UnitGlobal.repository.IRepoUnitTranssaccTe;
import com.farmer.farmerservices.UnitGlobal.repository.IRepositoryUnitGlobal;
//import com.example.demo.UnitGlobal.entity.UnitTransTransaccTe;
//import com.example.demo.UnitGlobal.entity.UnitTransaccion;
//import com.example.demo.UnitGlobal.repository.IRepoUnitTranssaccTe;
//import com.example.demo.UnitGlobal.repository.IRepositoryUnitGlobal;
import com.farmer.farmerservices.campo.entity.Datauser_campo;
import com.farmer.farmerservices.campo.entity.TeNomDec;
import com.farmer.farmerservices.campo.entity.Transaccion_te;
import com.farmer.farmerservices.campo.repository.IRepoDataUserCampo;
import com.farmer.farmerservices.campo.repository.IRepoMytruck;
import com.farmer.farmerservices.campo.repository.IRepoTeNominalDeclarado;
import com.farmer.farmerservices.campo.repository.IRepoTransaccionTe;
import com.farmer.farmerservices.factory.repository.IRepoDatoUser;
import com.farmer.farmerservices.repository.UserRepository;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import javax.transaction.Transactional;
import org.bouncycastle.operator.AADProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/**
 *
 * @author gabriel
 * 
 * METODO LogicTransacci:
 * 
 * Aca vamos a tener que guardar el dataunit y  la transaccion ademas vamos a tener que crear una nueva entidad para guardar la transaccion ya que lo que vamos a hacer es lo siguientes:
 * 1-agregamos dataunit
 * 2-buscamos la transaccion
 * 3-guardamos en otra entidad
 * 4- hacemos la resta de la transaccion con el te nominal
 * 5-eliminamos esa transaccion de te nominal de datauser.
 * 5-guardamos el te nominal
 * 
 * 
 * 
 */
/*
















ejemplo de data send enviado desde el front para una aceptacion de los dos casos
condiciones logicas:

aceptar:
        "ack_campo": true,
        "reject_campo": false

rechazar:
        "ack_campo": false,
        "reject_campo": true

pendiente:
        "ack_campo": true,
        "reject_campo": true





[
    {
        "idUserfactory": 2,
        "idUserfarmer": 1,
        "idTenomdec": 14,
        "idtransaccion": 18,
        "transacciUUID": "f1993ff7-3dab-4fce-86d0-2a994abdc163",
        "ack_campo": true,
        "reject_campo": false
    },
    {
        "idUserfactory": 2,
        "idUserfarmer": 1,
        "idTenomdec": 14,
        "idtransaccion": 21,
        "transacciUUID": "3b7022c1-bac1-4420-a890-9773fea33927",
        "ack_campo": true,
        "reject_campo": false
    }
]





*/




@Service
@Transactional
public class ServiceUnit implements IServiceUnit{
   
    
     @Autowired
    private UserRepository userRepository;
     
    @Autowired
    private IRepoDatoUser repofactory;
    @Autowired
    private IRepoKvs repkvs;

    @Autowired
    private IRepoDataUserCampo repDataUs;
    @Autowired
    private IRepoMytruck repTruck;
    
    @Autowired
    private IRepoDataUserCampo repcampo;
    @Autowired
    private IRepoTeNominalDeclarado reptenom;
    @Autowired
    private IRepoTransaccionTe reptranss;
    @Autowired
    private IRepositoryUnitGlobal repounit;
    @Autowired
    private IRepoUnitTranssaccTe repobackup;

    
    Boolean flag=false;

    @Override
    public List<UnitTransTransaccTe> ReturnAll(Long id) {

        //id es el id factory 
         List<UnitTransTransaccTe> datasearch=repobackup.findAll();
         List<UnitTransTransaccTe> datafind=new ArrayList<>();
        
        
         datasearch.forEach(valor->{
         
             if (valor.getUnittrans().getIdUserfactory().equals(id)) {
                 System.out.println("valor encontrado es "+valor.toString());
                 datafind.add(valor);
                 
                        } 
                    });
        
         
             System.out.println("--------------------------------------------");
             System.out.println("valor recolectados vale"+datafind.toString());
             return datafind;
         
         
         
         
        
    }

    @Override
    public List<UnitTransTransaccTe> ReturnAllxfarm(Long id) {
    
        //id es el id factory 
         List<UnitTransTransaccTe> datasearch=repobackup.findAll();
         List<UnitTransTransaccTe> datafind=new ArrayList<>();
        
        
         datasearch.forEach(valor->{
         
             if (valor.getUnittrans().getIdUserfarmer().equals(id)) {
                 System.out.println("valor encontrado es "+valor.toString());
                 datafind.add(valor);
                 
                        } 
                    });
        
         
             System.out.println("--------------------------------------------");
             System.out.println("valor recolectados vale"+datafind.toString());
             return datafind;
         
         
         
    
        
        
        
        
    }

    





    
    @Override
    public String ScanUT(UnitTransaccion data) {
       UnitTransTransaccTe backupvalor= new UnitTransTransaccTe();
        TeNomDec tesearch=reptenom.findById(data.getIdTenomdec()).orElseThrow();
        System.out.println("el valor de te nominal buscado vale"+tesearch.toString());
        
        Set<Transaccion_te> vtrans=tesearch.getTransaccion_te();
        
        
        
        vtrans.forEach(i->{
            if (i.getTransacc_id().toString()==data.getTransacciUUID()) {
                System.out.println("encontramo el elemento de transaccion y vale "+i.toString());
                
                
           } });
       
    
        
        //tengo que ver porque al cambiar un valor de lo que tengo en la base directamente me cambia el valor en la base de datos
       
     
       Transaccion_te findval=new Transaccion_te();
        
     //----------------CON ESTE BLOQUE BUSCAMOS LA TRANSACCION CON EL TRANSACCION ID   
       vtrans.forEach(i->{
       
            if (i.getTransacc_id().toString().equals(data.getTransacciUUID())) {
                System.out.println("el valor encontrado es "+i.toString());
                
                 findval.setCant_te_certi_nominal_now(i.getCant_te_certi_nominal_now());
                 findval.setCant_te_no_certi_nominal_now(i.getCant_te_no_certi_nominal_now());
                 findval.setData_delivery_first(i.getData_delivery_first());
                 findval.setData_delivery_last(i.getData_delivery_last());
                 findval.setId(i.getId());
                 findval.setIdUser(i.getIdUser());
                 findval.setTransacc_id(i.getTransacc_id());
                 
                backupvalor.setTransate(i);
                System.out.println("encontramo el elemento de transaccion y vale "+i.toString());
                flag=true;
           } });
       
        //---------------------------------------------------------------------------------------
       backupvalor.setUnittrans(data);
       
        System.out.println("el valor de backup vale"+backupvalor.toString());
        
        
        if (data.getAck_campo()==true&&data.getReject_campo()==false) {
             //entramos al accepted
            if (flag) {
                
            
                flag=false;
            System.out.println("el valor guardado vale"+repobackup.save(backupvalor));// guardamos los valores
            
        System.out.println("-----------------------------------------------------------------------------------------------------------");
        System.out.println("El valor guardado en find vale"+ findval.toString());
            if (findval.getCant_te_certi_nominal_now()>0.0) {
                tesearch.setCant_te_certificado_nominal(tesearch.getCant_te_certificado_nominal()-findval.getCant_te_certi_nominal_now());
                System.out.println("el nuevo valor de tesearch vale despues del if de te certificado"+tesearch.toString());
                }
            if (findval.getCant_te_no_certi_nominal_now()>0.0) {
                
               tesearch.setCant_te_sin_certificado_nominal(tesearch.getCant_te_sin_certificado_nominal()-findval.getCant_te_no_certi_nominal_now());
            System.out.println("el nuevo valor de tesearch vale despues del if de sin certificado"+tesearch.toString());    
            }
            
        //antes de borrar debo hacer la resta
        vtrans.remove(findval);//el update va a borrar soo
        
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        System.out.println("el valor del nuevo arrat vale"+vtrans.toString());
        
        
       //backupvalor.setUnittrans(data);
              System.out.println("el valor de backup vale"+backupvalor.toString());
    
                
                
                
            }
             
             
            
        
        }
        
        ///----------------------
        if (data.getAck_campo()==false&&data.getReject_campo()==true) {
        //entramos al reject
        if (flag==true) {
            flag=false;
            System.out.println("el valor guardado vale"+repobackup.save(backupvalor));// guardamos los valores
            
        System.out.println("-----------------------------------------------------------------------------------------------------------");
        System.out.println("El valor guardado en find vale"+ findval.toString());
            
        //antes de borrar debo hacer la resta
        vtrans.remove(findval);//el update va a borrar soo
        
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        System.out.println("el valor del nuevo arrat vale"+vtrans.toString());
        
        
       //backupvalor.setUnittrans(data);
              System.out.println("el valor de backup vale"+backupvalor.toString());
    
        }
      
        
        }
        
        if (data.getAck_campo()==true&&data.getReject_campo()==true) {
         
        if (flag==true) {
            flag=false;
            System.out.println("el valor guardado vale"+repobackup.save(backupvalor));// guardamos los valores
            
        System.out.println("-----------------------------------------------------------------------------------------------------------");
        System.out.println("El valor guardado en find vale"+ findval.toString());
            
        //antes de borrar debo hacer la resta
        
        
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        System.out.println("el valor del nuevo arrat vale"+vtrans.toString());
        
        
       //backupvalor.setUnittrans(data);
              System.out.println("el valor de backup vale"+backupvalor.toString());
    
        }
    
         
            
        }
    
         
        return "ok"; 
            }
    

    
    
    
    
    @Override
    public String AcceptUT(UnitTransaccion data) {
        UnitTransTransaccTe backupvalor= new UnitTransTransaccTe();
        TeNomDec tesearch=reptenom.findById(data.getIdTenomdec()).orElseThrow();
        System.out.println("el valor de te nominal buscado vale"+tesearch.toString());
        
        Set<Transaccion_te> vtrans=tesearch.getTransaccion_te();
        
        
        
        vtrans.forEach(i->{
            if (i.getTransacc_id().toString()==data.getTransacciUUID()) {
                System.out.println("encontramo el elemento de transaccion y vale "+i.toString());
                
                
           } });
       
    
        
        //tengo que ver porque al cambiar un valor de lo que tengo en la base directamente me cambia el valor en la base de datos
       
     
       Transaccion_te findval=new Transaccion_te();
        
     //----------------CON ESTE BLOQUE BUSCAMOS LA TRANSACCION CON EL TRANSACCION ID   
       vtrans.forEach(i->{
       
            if (i.getTransacc_id().toString().equals(data.getTransacciUUID())) {
                System.out.println("el valor encontrado es "+i.toString());
                
                 findval.setCant_te_certi_nominal_now(i.getCant_te_certi_nominal_now());
                 findval.setCant_te_no_certi_nominal_now(i.getCant_te_no_certi_nominal_now());
                 findval.setData_delivery_first(i.getData_delivery_first());
                 findval.setData_delivery_last(i.getData_delivery_last());
                 findval.setId(i.getId());
                 findval.setIdUser(i.getIdUser());
                 findval.setTransacc_id(i.getTransacc_id());
                 
                backupvalor.setTransate(i);
                System.out.println("encontramo el elemento de transaccion y vale "+i.toString());
                flag=true;
           } });
       
        //---------------------------------------------------------------------------------------
       backupvalor.setUnittrans(data);
       
        System.out.println("el valor de backup vale"+backupvalor.toString());
        
        
        if (flag==true) {
            flag=false;
            System.out.println("el valor guardado vale"+repobackup.save(backupvalor));// guardamos los valores
            
        System.out.println("-----------------------------------------------------------------------------------------------------------");
        System.out.println("El valor guardado en find vale"+ findval.toString());
            if (findval.getCant_te_certi_nominal_now()>0.0) {
                tesearch.setCant_te_certificado_nominal(tesearch.getCant_te_certificado_nominal()-findval.getCant_te_certi_nominal_now());
                System.out.println("el nuevo valor de tesearch vale despues del if de te certificado"+tesearch.toString());
                }
            if (findval.getCant_te_no_certi_nominal_now()>0.0) {
                
               tesearch.setCant_te_sin_certificado_nominal(tesearch.getCant_te_sin_certificado_nominal()-findval.getCant_te_no_certi_nominal_now());
            System.out.println("el nuevo valor de tesearch vale despues del if de sin certificado"+tesearch.toString());    
            }
            
        //antes de borrar debo hacer la resta
        vtrans.remove(findval);//el update va a borrar soo
        
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        System.out.println("el valor del nuevo arrat vale"+vtrans.toString());
        
        
       //backupvalor.setUnittrans(data);
              System.out.println("el valor de backup vale"+backupvalor.toString());
    
        }
        
        return "ok";
    }

    
    Boolean flag1=false;
    
    @Override
    public String RejectUT(UnitTransaccion data) {
            UnitTransTransaccTe backupvalor= new UnitTransTransaccTe();
            TeNomDec tesearch=reptenom.findById(data.getIdTenomdec()).orElseThrow();
            System.out.println("el valor de te nominal buscado vale"+tesearch.toString());
        
        Set<Transaccion_te> vtrans=tesearch.getTransaccion_te();
        
        
        
        vtrans.forEach(i->{
            if (i.getTransacc_id().toString()==data.getTransacciUUID()) {
                System.out.println("encontramo el elemento de transaccion y vale "+i.toString());
                
           } });
       
       backupvalor.setUnittrans(data);
       
        System.out.println("el valor de backup vale"+backupvalor.toString());
        
        
        //tengo que ver porque al cambiar un valor de lo que tengo en la base directamente me cambia el valor en la base de datos
       
     
       Transaccion_te findval=new Transaccion_te();
        
     //----------------CON ESTE BLOQUE BUSCAMOS LA TRANSACCION CON EL TRANSACCION ID   
       vtrans.forEach(i->{
       
            if (i.getTransacc_id().toString().equals(data.getTransacciUUID())) {
                System.out.println("el valor encontrado es "+i.toString());
                
                 findval.setCant_te_certi_nominal_now(i.getCant_te_certi_nominal_now());
                 findval.setCant_te_no_certi_nominal_now(i.getCant_te_no_certi_nominal_now());
                 findval.setData_delivery_first(i.getData_delivery_first());
                 findval.setData_delivery_last(i.getData_delivery_last());
                 findval.setId(i.getId());
                 findval.setIdUser(i.getIdUser());
                 findval.setTransacc_id(i.getTransacc_id());
                 
                backupvalor.setTransate(i);
                System.out.println("encontramo el elemento de transaccion y vale "+i.toString());
                flag1=true;
           } });
       
       
       
        if (flag1==true) {
            flag1=false;
            System.out.println("el valor guardado vale"+repobackup.save(backupvalor));// guardamos los valores
            
        System.out.println("-----------------------------------------------------------------------------------------------------------");
        System.out.println("El valor guardado en find vale"+ findval.toString());
            
        //antes de borrar debo hacer la resta
        vtrans.remove(findval);//el update va a borrar soo
        
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        System.out.println("el valor del nuevo arrat vale"+vtrans.toString());
        
        
       //backupvalor.setUnittrans(data);
              System.out.println("el valor de backup vale"+backupvalor.toString());
    
        }
       
       
        
        return "ok, relizamos el reject exitosamente";
    }

    
    
    Boolean flag2=false;
    
    @Override
    public String PendingUT(UnitTransaccion data) {
    UnitTransTransaccTe backupvalor= new UnitTransTransaccTe();
            TeNomDec tesearch=reptenom.findById(data.getIdTenomdec()).orElseThrow();
            System.out.println("el valor de te nominal buscado vale"+tesearch.toString());
        
        Set<Transaccion_te> vtrans=tesearch.getTransaccion_te();
        
        
        
        vtrans.forEach(i->{
            if (i.getTransacc_id().toString()==data.getTransacciUUID()) {
                System.out.println("encontramo el elemento de transaccion y vale "+i.toString());
                
           } });
       
       backupvalor.setUnittrans(data);
       
        System.out.println("el valor de backup vale"+backupvalor.toString());
        
        
        //tengo que ver porque al cambiar un valor de lo que tengo en la base directamente me cambia el valor en la base de datos
       
     
       Transaccion_te findval=new Transaccion_te();
        
     //----------------CON ESTE BLOQUE BUSCAMOS LA TRANSACCION CON EL TRANSACCION ID   
       vtrans.forEach(i->{
       
            if (i.getTransacc_id().toString().equals(data.getTransacciUUID())) {
                System.out.println("el valor encontrado es "+i.toString());
                
                 findval.setCant_te_certi_nominal_now(i.getCant_te_certi_nominal_now());
                 findval.setCant_te_no_certi_nominal_now(i.getCant_te_no_certi_nominal_now());
                 findval.setData_delivery_first(i.getData_delivery_first());
                 findval.setData_delivery_last(i.getData_delivery_last());
                 findval.setId(i.getId());
                 findval.setIdUser(i.getIdUser());
                 findval.setTransacc_id(i.getTransacc_id());
                 
                backupvalor.setTransate(i);
                System.out.println("encontramo el elemento de transaccion y vale "+i.toString());
                flag2=true;
           } });
       
       
       
        if (flag2==true) {
            flag2=false;
            System.out.println("el valor guardado vale"+repobackup.save(backupvalor));// guardamos los valores
            
        System.out.println("-----------------------------------------------------------------------------------------------------------");
        System.out.println("El valor guardado en find vale"+ findval.toString());
            
        //antes de borrar debo hacer la resta
        
        
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        System.out.println("el valor del nuevo arrat vale"+vtrans.toString());
        
        
       //backupvalor.setUnittrans(data);
              System.out.println("el valor de backup vale"+backupvalor.toString());
    
        }
    
        
    
    
    
    
    
   return "ok, relizamos el pending exitosamente"; 
    }
    
    
    
    @Override
    public List<UnitTransaccion> traerTodo() {
            return repounit.findAll();
    }

    @Override
    public String LogicTransacci(UnitTransaccion data) {
        //repounit.save(data);
        Optional<TeNomDec> tenom=reptenom.findById(data.getIdTenomdec());
        System.out.println("el valor de Tenom antes de los cambios"+tenom.toString());
        Set<Transaccion_te> transa=tenom.get().getTransaccion_te();
        Transaccion_te rettrans=new Transaccion_te();
        Set<Transaccion_te> newtrans=new HashSet<>();
        transa.forEach(val->{
            if (val.getId()==data.getIdtransaccion()) {
                rettrans.setId(val.getId());
                rettrans.setIdUser(val.getIdUser());
                rettrans.setTransacc_id(val.getTransacc_id());
                rettrans.setCant_te_certi_nominal_now(val.getCant_te_certi_nominal_now());
                rettrans.setCant_te_no_certi_nominal_now(val.getCant_te_no_certi_nominal_now());
                rettrans.setData_delivery_first(val.getData_delivery_first());
                rettrans.setData_delivery_last(val.getData_delivery_last());
            }
            newtrans.add(val);
            
        
        });
        
        System.out.println("el valore encontrado de transacci es"+rettrans.toString());
                
        UnitTransTransaccTe backup= new UnitTransTransaccTe();
        
        backup.setTransate(rettrans);
        backup.setUnittrans(data);
        
        repobackup.save(backup);
        
        
        System.out.println("el valor de  backup vale"+backup.toString());
        
        float TVCnom=tenom.get().getCant_te_certificado_nominal();
        float TVnom=tenom.get().getCant_te_sin_certificado_nominal();
        float Palonom=tenom.get().getCant_te_palo_nominal();
        
        
        if ((rettrans.getCant_te_certi_nominal_now()>0.0) && (data.getAck_campo()==true)&& (data.getReject_campo()==false) )
        {
            tenom.get().setCant_te_certificado_nominal((TVCnom-rettrans.getCant_te_certi_nominal_now()));
            
        }
        if ((rettrans.getCant_te_no_certi_nominal_now()>0.0  )&& (data.getAck_campo()==true) && (data.getReject_campo()==false)){
        
             tenom.get().setCant_te_sin_certificado_nominal(TVnom-rettrans.getCant_te_no_certi_nominal_now());
        }
        
        //falta el de palo
        tenom.get().getTransaccion_te().clear();//limpiamos el array de lo que tenia antes
        //sacamos el valor que hay que sacar;
        newtrans.removeIf(filter->filter.getId()==data.getIdtransaccion());
        System.out.println("el valor de transaccion sacado el valor que hay que discriminar"+newtrans.toString());
        
        tenom.get().setTransaccion_te(newtrans);
        
        System.out.println("El nuevo valor de Te nom vale"+reptenom.save(tenom.get())); 
            
        
        
             
        
        
       
        
        
        
        
        
        /*
        Set<Transaccion_te> transa=new HashSet<>();
        Transaccion_te tbus= new Transaccion_te();//vamos a recuperar el transaccion que matche con la IUnit
        UnitTransTransaccTe backup= new UnitTransTransaccTe();
        TeNomDec tedec=new TeNomDec();
        tenom.forEach(action->{
            
            if(action.getId()==data.getIdTenomdec()){
            tedec.setId(action.getId());
                System.out.println("entramos alif");
            tedec.setIdUser(action.getIdUser());
            tedec.setNombrecampo(action.getNombrecampo());
            tedec.setCant_te_certificado_nominal(action.getCant_te_certificado_nominal());
            tedec.setCant_te_palo_nominal(action.getCant_te_palo_nominal());
            tedec.setCant_te_sin_certificado_nominal(action.getCant_te_sin_certificado_nominal());
            tedec.setTransaccion_te(action.getTransaccion_te());
                
            }
            
            
          action.getTransaccion_te().forEach(act1->{
          transa.add(act1);
          
          });
             });
        
        
        transa.forEach(valor->{
                if(valor.getId()==data.getIdtransaccion()){
                            tbus.setId(valor.getId());
                            tbus.setIdUser(valor.getIdUser());
                            tbus.setCant_te_certi_nominal_now(valor.getCant_te_certi_nominal_now());
                            tbus.setCant_te_no_certi_nominal_now(valor.getCant_te_no_certi_nominal_now());
                            tbus.setTransacc_id(valor.getTransacc_id());
                            tbus.setData_delivery_first(valor.getData_delivery_first());
                            tbus.setData_delivery_last(valor.getData_delivery_last());
                    System.out.println("el valor de tbus vale"+tbus.toString());
                        }
                    
        });
        
        backup.setTransate(tbus);
        backup.setUnittrans(data);
        System.out.println("el valor deb backup  vale"+backup.toString());
        System.out.println("El valor de datauser vale"+campo.toString());
        //System.out.println("el valordel save vale "+repobackup.save(backup).toString());
        //vamos a sacarle el te nom lo de la transaccion
        System.out.println("el valor de Te nom decl antes del cambio vale"+tedec.toString());
        
        //tedec es el vvalor de te nominal 
        float TVCnom=tedec.getCant_te_certificado_nominal();
        float TVnom=tedec.getCant_te_sin_certificado_nominal();
        float Palonom=tedec.getCant_te_palo_nominal();
        
        
        if (tbus.getCant_te_certi_nominal_now()>0.0  )
        {
            tedec.setCant_te_certificado_nominal((TVCnom-tbus.getCant_te_certi_nominal_now()));
            
        }
        if (tbus.getCant_te_no_certi_nominal_now()>0.0  ){
        
        tedec.setCant_te_sin_certificado_nominal(TVnom-tbus.getCant_te_no_certi_nominal_now());
        }
        
        //PARA EL PALO TENEMOS QUE IMPLEMENTAR !!!!
        
        //ahora vamos a crear nuestronuevo datauser para guardarlo
        tenom.removeIf(val->val.getId()==data.getIdTenomdec());
        tedec.getTransaccion_te().removeIf(val->val.getId()==data.getIdtransaccion());
        
        System.out.println("el valor de Te nom actualizado valr"+tedec.toString());
        
        
        tenom.add(tedec); //agregamos le valor cambiado de tenom decl
        System.out.println("/n el valor del Set tenom vale"+tenom.toString());
        campo.getTenominal().clear();
        campo.getTenominal().add(tedec);
        
        System.out.println("el nuevo valor de campouser vale "+campo.toString());
        */
        return "ok";
    }}
