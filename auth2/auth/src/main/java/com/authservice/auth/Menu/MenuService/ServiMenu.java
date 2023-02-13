/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.authservice.auth.Menu.MenuService;

import com.authservice.auth.Menu.MenuEntity.Children;
import com.authservice.auth.Menu.MenuEntity.DTOMenu;
import com.authservice.auth.Menu.MenuEntity.Menu;
import com.authservice.auth.MenuRepository.IRepoChildren;
import com.authservice.auth.MenuRepository.IRepoItemMenu;
import java.io.DataOutput;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gabriel
 */
@Service
public class ServiMenu implements IServiMenu {
    @Autowired
    private IRepoChildren repochi;
    @Autowired
    private IRepoItemMenu menu;
         
    
    @Override
    public List<Menu> TraerMenu(Set<String> rol) {
    
    List<Menu> mimenu=menu.findAll();
    List<Menu> menurol=new ArrayList<>();
    List<String> rolstr=new ArrayList<>();
    
        System.out.println("el valor de rol en servicio  vale"+ rol.toString());
            
        
        Iterator roles=rol.iterator();
        
        
        while(roles.hasNext()){
            rolstr.add(roles.next().toString());
            System.out.println("el valor  del rol  vale "+rolstr.toString());
        
        
        }
        
        
        
            for (int i = 0; i < rolstr.size(); i++) {
                for (int j = 0; j < mimenu.size(); j++) {
                    System.out.println("el valor de menu con indice "+j+" vale "+mimenu.get(j).toString());
                    
                    Menu datain=new Menu();
                    if(rolstr.get(i).toString()=="ROLE_FACTORY"){
                        System.out.println("encontramos factory");
                           
                            if(j==0||j==6||j==4||j==5){
                                datain.setId(mimenu.get(j).getId());
                                datain.setIcon(mimenu.get(j).getIcon());
                                datain.setRouterLink(mimenu.get(j).getRouterLink());
                                datain.setText(mimenu.get(j).getText());
                                datain.setChildren(mimenu.get(j).getChildren());
                                
                                System.out.println("entramos al if j");
                                menurol.add(datain);                                
                            }}
                        
                    if(rolstr.get(i).toString()=="ROLE_PROPIETARIOS"){
                     System.out.println("encontramos propietarios");
                            if(j==1||j==2||j==3||j==7){
                                datain.setId(mimenu.get(j).getId());
                                datain.setIcon(mimenu.get(j).getIcon());
                                datain.setRouterLink(mimenu.get(j).getRouterLink());
                                datain.setText(mimenu.get(j).getText());
                                datain.setChildren(mimenu.get(j).getChildren());
                                
                                System.out.println("entramos al if j");
                                menurol.add(datain);
                            }}
                    
                                                        }
                                                             }
                                                
        System.out.println("el valor  de menu vale "+menurol.toString());
        
        return menurol;
        
            
    
    
    
    }

    @Override
    public String InsertAllMenu(List<Menu> data) {
        data.forEach((valor) -> {
        menu.save(valor);
            
        });
        
        
        
        
        return "ok";
        
    }
    
    

    @Override
    public String InsertMenu(Menu data) {
            System.out.println(data.toString());
            menu.save(data);
      return "ok";
        
    }
    
    
}
