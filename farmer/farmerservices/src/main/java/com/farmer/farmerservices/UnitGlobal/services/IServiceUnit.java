/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.farmer.farmerservices.UnitGlobal.services;


import com.farmer.farmerservices.UnitGlobal.entity.UnitTransTransaccTe;
import com.farmer.farmerservices.UnitGlobal.entity.UnitTransaccion;
import com.farmer.farmerservices.campo.entity.TeNomDec;
import java.util.List;

/**
 *
 * @author gabriel
 */
public interface IServiceUnit {

public List<UnitTransaccion> traerTodo();
       
public String LogicTransacci(UnitTransaccion data);

public String AcceptUT(UnitTransaccion data);

public String RejectUT(UnitTransaccion data);

public String PendingUT(UnitTransaccion data);

public String ScanUT(UnitTransaccion data);

public List<UnitTransTransaccTe> ReturnAll(Long id);
public List<UnitTransTransaccTe> ReturnAllxfarm(Long id);

}

