/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pandoracheckin.farmer.service;


import com.pandoracheckin.farmer.DTO.IPk;
import com.pandoracheckin.farmer.DTO.PandoraCheckFarmer;
import com.pandoracheckin.farmer.DTO.PosCheckinFar;
import com.pandoracheckin.farmer.DTO.ResponsePersonalData;
import com.pandoracheckin.farmer.UnitGlobal.entity.UnitTransTransaccTe;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


/**
 *
 * @author gabriel
 */

@Service
public class ServiceCheckin implements IService{
        
final String UNIT_URI = "https://farmer-service/unit/retallpk";//retallpk/ es el nuevo endpoint que creamos 
final String PDATA_URI = "https://auth-service/pdata/";
final String POSCHECKIN_URI="https://pandoracenter-service/pandoraposcheckin/allposcheckinpk";

   @Autowired
	RestTemplate restTemplate;
        
    //  @Autowired
   // private CircuitBreakerFactory circuitBreakerFactory;

      @Override
      //@TimeLimiter(name = "pandora-service", fallbackMethod = "getDefaultPandora")
        @io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker (name = "pandora-service", fallbackMethod = "getDefaultPandora")
    public List<PandoraCheckFarmer> ReturnAll(IPk data,String token) {
        
           List<PandoraCheckFarmer> tosend=new ArrayList<>();
        String url=UNIT_URI;
             System.out.println("el valor de url vale"+url);
      //    String serverid="farmer-service";
        //  String homePageUrl = eurekaClient.getNextServerFromEureka(serverid, false).getHomePageUrl();
          List<UnitTransTransaccTe> vlor=new ArrayList<>();
            List<UnitTransTransaccTe> vlorfiltrado=new ArrayList<>();
       
          
		 vlor= restTemplate.exchange(url,HttpMethod.POST,new HttpEntity<IPk>(data, createHttpHeaders(token)),
				new ParameterizedTypeReference<List<UnitTransTransaccTe>>(){}).getBody();
                 
                 System.out.println("-------------/n");
                 System.out.println("El valor de data unit"+vlor.toString());
                 System.out.println("-------------/n");
                       
                 
          //buscamos el valor 
          List<PosCheckinFar> valfromposcheck=this.ReturnAllfromPoscheckin(data, token);
                   System.out.println("el valor de postchein encontrado es "+valfromposcheck.toString());
                   
          List<UUID> uuidcomm= new ArrayList<>();
           
          valfromposcheck.forEach(value->{
              uuidcomm.add(value.getPandora_check().getTransacc_id());
          
          });
          
          System.out.println("valor encontrados de uuid"+uuidcomm.toString());
         
          Boolean flag=false;
                   
          for (int i = 0; i <vlor.size() ; i++) {
              
              for (int j = 0; j < uuidcomm.size(); j++) {
                  System.out.println("estamos en el elemento "+i+"    "+vlor.get(i).toString());
                  
                  if(vlor.get(i).getTransate().getTransacc_id().equals(uuidcomm.get(j))==false){
                      System.out.println("ENCONTRADO VALOR DISTINTO AGREGAMOS!!!!/n/n");
                      System.out.println("---------------------------------/n");
                      flag=true;
                      System.out.println("valor encontrado vale"+vlor.get(i).toString());
                      System.out.println("---------------------------------/n");
                                }
                  
              }
              if(flag==false){
              vlorfiltrado.add(vlor.get(i));
              flag=false;
              
              }
              
              
          }
          
          //vamos con  la logica recorremos primero el array valposcheckin y vemos los que no coinciden
          
          
                 
                 
                 System.out.println("el valor es "+vlor.toString());
                 vlorfiltrado.forEach(action->{
                 PandoraCheckFarmer data1=new PandoraCheckFarmer();
                 ResponsePersonalData pdata=new ResponsePersonalData();
                 pdata=this.SerachforId(action.getUnittrans().getIdUserfactory(),token);
                     System.out.println("el valor de pdata vale"+pdata.toString());
                 //--------------------
                // data1.setId(id);
                data1.setStatus("NONE_PANDORA");
                 data1.setCant_te_certi_nominal_now(action.getTransate().getCant_te_certi_nominal_now());
                 data1.setCant_te_no_certi_nominal_now(action.getTransate().getCant_te_no_certi_nominal_now());
                 data1.setData_delivery_first(action.getTransate().getData_delivery_first());
                 data1.setData_delivery_last(action.getTransate().getData_delivery_last());
                 data1.setName(pdata.getName());
                 data1.setIdUserfarmer(action.getUnittrans().getIdUserfarmer());
                 data1.setIdUserfactory(action.getUnittrans().getIdUserfactory());
                 data1.setTransacc_id(UUID.fromString(action.getUnittrans().getTransacciUUID()));
                 tosend.add(data1);
                 
                 
                 
                 
                 
                 
                 }
                 
                 
                 
                 
                 );
                 
                 
                 
                 
     
    return tosend;
    
    
    
    
    
    }
    
    
    
    
       @Override
          //  @TimeLimiter(name = "pandora-service", fallbackMethod = "getDefaultPandora")
           @io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker (name = "pandora-service", fallbackMethod = "getDefaultPdata")
    public ResponsePersonalData SerachforId(Long id,String token) {
        String url=PDATA_URI+id.toString();
             System.out.println("el valor de url vale"+url);
    
        
        return restTemplate.exchange(url,HttpMethod.GET,new HttpEntity( createHttpHeaders(token)),
				 ResponsePersonalData.class).getBody() ;
    
    }

    @Override
               @io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker (name = "pandora-service", fallbackMethod = "getDefaultPosCheckinFar")
    public List<PosCheckinFar> ReturnAllfromPoscheckin(IPk data, String token) {
       String url=POSCHECKIN_URI;
           List<PosCheckinFar> vlor=new ArrayList<>();
       
		 vlor= restTemplate.exchange(url,HttpMethod.POST,new HttpEntity<IPk>(data, createHttpHeaders(token)),
				new ParameterizedTypeReference<List<PosCheckinFar>>(){}).getBody();
                 System.out.println("el valor de poscheckin vale"+vlor.toString());
        return vlor;
        
    }
    
    
    
    
      /*
      //--------ESTO ES COMO FUNCIONO INICIALMENTE
    @Override
    public List<PandoraCheckFarmer> ReturnAll(Long id,String token) {
        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("circuitbreaker");
        
        List<PandoraCheckFarmer> tosend=new ArrayList<>();
        String url=UNIT_URI+id.toString();
             System.out.println("el valor de url vale"+url);
      //    String serverid="farmer-service";
        //  String homePageUrl = eurekaClient.getNextServerFromEureka(serverid, false).getHomePageUrl();
          List<UnitTransTransaccTe> vlor=new ArrayList<>();
          
          
           
          
          
          
          
		 vlor= circuitBreaker.run(() -> restTemplate.exchange(url,HttpMethod.GET,new HttpEntity( createHttpHeaders(token)),
				new ParameterizedTypeReference<List<UnitTransTransaccTe>>(){}).getBody(), 
      throwable -> getDefaultPandora());
                 vlor.forEach(action->{
                 PandoraCheckFarmer data1=new PandoraCheckFarmer();
                 ResponsePersonalData pdata=new ResponsePersonalData();
                 pdata=this.SerachforId(action.getUnittrans().getIdUserfactory(),token);
                 //--------------------
                 data1.setId(id);
                 data1.setCant_te_certi_nominal_now(action.getTransate().getCant_te_certi_nominal_now());
                 data1.setCant_te_no_certi_nominal_now(action.getTransate().getCant_te_no_certi_nominal_now());
                 data1.setData_delivery_first(action.getTransate().getData_delivery_first());
                 data1.setData_delivery_last(action.getTransate().getData_delivery_last());
                 data1.setName(pdata.getName());
                 data1.setIdUserfarmer(action.getUnittrans().getIdUserfarmer());
                 data1.setIdUserfactory(action.getUnittrans().getIdUserfactory());
                 data1.setTransacc_id(UUID.fromString(action.getUnittrans().getTransacciUUID()));
                 tosend.add(data1);
                 
                 
                 
                 
                 
                 
                 }
                 
                 
                 
                 
                 );
                 
                 
                 
                 
     
    return tosend;
    
    }

    
    @Override
    public ResponsePersonalData SerachforId(Long id,String token) {
        String url=PDATA_URI+id.toString();
             System.out.println("el valor de url vale"+url);
             
            CircuitBreaker circuitBreaker = circuitBreakerFactory.create("circuitbreakerpdata");
        
        return circuitBreaker.run(() -> restTemplate.exchange(url,HttpMethod.GET,new HttpEntity( createHttpHeaders(token)),
				 ResponsePersonalData.class).getBody(), 
      throwable -> getDefaultPdata());
        
    }
    
    */
    
      public List<PosCheckinFar> getDefaultPosCheckinFar(Exception e){
          List<PosCheckinFar> vlor1=new ArrayList<>();
    System.out.println(e);
    return vlor1;
      }
    
    
     public ResponsePersonalData  getDefaultPdata(Exception e){
ResponsePersonalData vlor1=new ResponsePersonalData();
         System.out.println(e);
    return vlor1;
    
    }
    
    

     public List<UnitTransTransaccTe>  getDefaultPandora(Exception e){
    List<UnitTransTransaccTe> vlor1=new ArrayList<>();
    System.out.println(e);
    return vlor1;
    
    }
    
    
    private HttpHeaders createHttpHeaders(String token)
{
  
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    headers.add("Authorization", token);
    return headers;
}

    
    
    
    
}
