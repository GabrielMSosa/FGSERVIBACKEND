/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.farmer.farmerservices.campo.services;

import com.farmer.farmerservices.KVS.EntityMatchIdUserKVS;
import com.farmer.farmerservices.KVS.IRepoKvs;
import com.farmer.farmerservices.ResponsePersonalData.ResponsePersonalData;
import com.farmer.farmerservices.UnitGlobal.entity.UnitTransaccion;
import com.farmer.farmerservices.UnitGlobal.repository.IRepositoryUnitGlobal;
import com.farmer.farmerservices.campo.entity.Datauser_campo;
import com.farmer.farmerservices.campo.entity.Mytruck;
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
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import javax.transaction.Transactional;
import org.bouncycastle.math.Primes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gabriel
 */
@Service
@Transactional
public class ServiceFarm implements IServiceFarm {

    @Autowired
    private UserRepository userRepository;
     
    @Autowired
    private IRepoDatoUser repofactory;
    @Autowired
    private IRepoKvs repkvs;

    
    


    @Autowired
    private IRepositoryUnitGlobal repoUnit;
    @Autowired
    private IRepoDataUserCampo repDataUs;
    @Autowired
    private IRepoMytruck repTruck;
    @Autowired
    private IRepoTeNominalDeclarado repTenominal;
    @Autowired    
    private IRepoTransaccionTe repotransacc;

    
    
    @Override
    public TeNomDec AddTruckforTenomDec(Mytruck data, Long id) {
            TeNomDec dataout=repTenominal.findById(id).orElseThrow();
        
            Set<Mytruck> arrtruck =dataout.getMytrucks();
            
            arrtruck.add(data);
            return dataout;
            
            
        
        
    }

    @Override
    public Set<TeNomDec> ReturnTruckforIdDataUser(Long id) {

        Datauser_campo datasearch=repDataUs.findById(id).orElseThrow();
        
        Set<TeNomDec> tenom=datasearch.getTenominal();
        
        
        return tenom;
        
    }

    private boolean valuesss=false;
    private Mytruck valuesearch= new Mytruck();
    @Override
    public TeNomDec DeleteTruckforIdDataUser(Long idtnominal,Mytruck datadelet) {
        valuesss=false;
        TeNomDec datasearch=repTenominal.findById(idtnominal).orElseThrow();
        
        
                
        System.out.println("el valor de truck vale"+datadelet.toString());
        
        
        datasearch.getMytrucks().forEach(action->{
        if (action.equals(datadelet)==true) {
            
            valuesearch=action;
            
            valuesss=true;
            System.out.println("entramos al if");
            System.out.println("vale"+action.toString());
            //datasearch.getMytrucks().remove(datadelet);
                    
            
        }
        
        
        });
        
        if (valuesss==true) {
                datasearch.getMytrucks().remove(valuesearch);
            }
            else
                {System.out.println("no encontramos valor");}
        
        
        
        
        
        
        
        
        return datasearch;
        
    }

    
    
    
    
    
    
    
    @Override
    public TeNomDec AddTransaccionTe(Transaccion_te data, Long id) {
        
        TeNomDec dataout=repTenominal.findById(id).orElseThrow();
        
        Set<Transaccion_te> x=dataout.getTransaccion_te();
        
        
        x.add(data);
        
        dataout.setTransaccion_te(x);
        
        return repTenominal.save(dataout);
        
    }
    
    
    
    @Override
    public List<TeNomDec> GetTeNomAll() {
    
        return repTenominal.findAll();
        
        
    }
    
    
    
//GetTeNomById(id)    
    @Override
    public String LoadCampo(TeNomDec data) {
        System.out.println("el valor de data en el servicio vale"+data.toString());
        ResponsePersonalData dataout=new ResponsePersonalData();
        EntityMatchIdUserKVS data1=repkvs.findByPkuser(data.getIdUser());//aca obtenemos el id de las entidades Datauser_campo o Datouser_factory del kvs 
        System.out.println("el valor de data 1 vale"+data1.toString());
        Datauser_campo data2=repDataUs.findById(data1.getPkdata()).orElseThrow();
       
        System.out.println("el vlaorl de data2 vvale"+data2.toString()); 
       
        
        Transaccion_te tetran=new Transaccion_te();               
        Mytruck truck=new Mytruck();
        Set<Mytruck> arrtruck=new HashSet<>();
        System.out.println("el valor dearraytruck vale inicialmente"+arrtruck.toString());
        
        arrtruck.add(truck);
        System.out.println("el valor dearraytruck con el add "+arrtruck.toString());
        arrtruck.remove(truck);
        System.out.println("el valor dearraytruck luego del remove vale "+arrtruck.toString());
        
        
        
        
        data.getTransaccion_te().forEach((data45)->{
         
        tetran.setData_delivery_first(data45.getData_delivery_first());
        tetran.setData_delivery_last(data45.getData_delivery_last());
        tetran.setMytrucks(arrtruck);
        tetran.setCant_te_certi_nominal_now(data45.getCant_te_certi_nominal_now());
        tetran.setCant_te_no_certi_nominal_now(data45.getCant_te_no_certi_nominal_now());
        tetran.setIdUser(data45.getIdUser());
        
                
         });
         
       
        
        Set<Transaccion_te> transaset=new HashSet<>();
        transaset.add(tetran);
        
        
        
        
        
        TeNomDec dataNom=new TeNomDec();
        Set<TeNomDec> tenom=new HashSet<>();
        
       dataNom.setCant_te_certificado_nominal(data.getCant_te_certificado_nominal());
       dataNom.setCant_te_sin_certificado_nominal(data.getCant_te_sin_certificado_nominal());
       dataNom.setCant_te_palo_nominal(data.getCant_te_palo_nominal());
       dataNom.setMytrucks(arrtruck);
       dataNom.setIdUser(data.getIdUser());
       dataNom.setNombrecampo(data2.getTitulo());
       dataNom.setTransaccion_te(transaset);
       tenom.add(dataNom);
       data2.getTenominal().clear();
        data2.getTenominal().addAll(tenom);
        
       
       
        System.out.println("sout en servicio "+data2.toString());
         repDataUs.save(data2);
    
    return "OK";
    }
    

    @Override
    public TeNomDec GetTeNomById(Long id) {
        return   repTenominal.findById(id).orElseThrow();
    }

    @Override
    public TeNomDec GetTenomByIdUser(Long id) {
        return repTenominal.findByIdUser(id).orElseThrow();
    }

    @Override
    public Transaccion_te GetTetransacciById(Long id) {
        return   repotransacc.findById(id).orElseThrow();
    }

    
    
    @Override
    public Datauser_campo GetByID(Long id) {
        return   repDataUs.findById(id).orElseThrow();
        
    }

    @Override
    public TeNomDec AddTransaccTe(TeNomDec data) {
        TeNomDec ref=repTenominal.findById(data.getId()).orElseThrow();
        Transaccion_te add=new Transaccion_te();
        
        
        Mytruck truck=new Mytruck();
        Set<Mytruck> arrtruck=new HashSet<>();
        System.out.println("el valor dearraytruck vale inicialmente"+arrtruck.toString());
        
        arrtruck.add(truck);
        System.out.println("el valor dearraytruck con el add "+arrtruck.toString());
        arrtruck.remove(truck);
        System.out.println("el valor dearraytruck luego del remove vale "+arrtruck.toString());
        
        
        Set<Transaccion_te>dataout=ref.getTransaccion_te();
     
        
        //hacemos el for solo para engañar el item tiene solo un valor
       for (Transaccion_te x:data.getTransaccion_te() ) {
            add.setCant_te_certi_nominal_now(x.getCant_te_certi_nominal_now());
            add.setCant_te_no_certi_nominal_now(x.getCant_te_no_certi_nominal_now());
            add.setIdUser(x.getIdUser());
            add.setMytrucks(arrtruck);
            add.setData_delivery_first(x.getData_delivery_first());
            add.setData_delivery_last(x.getData_delivery_last());
          }    
     
        //dataout.add(add);
        
        Set<Transaccion_te> nuevo=ref.getTransaccion_te();
      
        
        System.out.println("el valor del nuevo valor que se agrega es "+add.toString());
        nuevo.add(add);
        
        
        
        //Integer iduserint=3;
        //Long iduser=iduserint.longValue();
        
        ref.setTransaccion_te(nuevo);
        
        
        
        
        List<Transaccion_te> x2=repotransacc.findByIdUser(add.getIdUser());
        System.out.println("los valores buscado con"+add.getIdUser()+ "id son "+x2.toString());
        
        
        
        
        
        //vamos a iniciar el guardado de UnitTransaccion
        //el IdUser farm debemos cambiarlos desde el front porque vamos a sacar
        //el id user del usuario de campo.
        
        List<UnitTransaccion> dataUnit=new ArrayList<UnitTransaccion>();
        
        for (int i = 0; i < x2.size(); i++) {
            UnitTransaccion valor=new UnitTransaccion();
            
            valor.setAck_campo(false);
            valor.setReject_campo(false);
            valor.setIdTenomdec(ref.getId());
            valor.setIdUserfarmer(x2.get(i).getIdUser());
            valor.setIdUserfactory(x2.get(i).getIdUser());
            valor.setTransacciUUID(x2.get(i).getTransacc_id().toString());
            valor.setIdtransaccion(x2.get(i).getId());
            
            dataUnit.add(valor);
            
            
            
            
        }
        
        repTenominal.save(ref);
        repoUnit.saveAll(dataUnit);
        
        return ref;
         }


    
    
    
    
    
    
}
