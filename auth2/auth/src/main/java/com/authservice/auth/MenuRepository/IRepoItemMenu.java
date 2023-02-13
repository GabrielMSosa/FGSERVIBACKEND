/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.authservice.auth.MenuRepository;

import com.authservice.auth.Menu.MenuEntity.Menu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gabriel
 */
@Repository
public interface IRepoItemMenu extends JpaRepository<Menu, Long> {
    
}
