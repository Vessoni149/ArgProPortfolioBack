/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.Vessoni.Security.Service;

import com.portfolio.Vessoni.Security.Entity.Rol;
import com.portfolio.Vessoni.Security.Enums.RolNombre;
import com.portfolio.Vessoni.Security.Repository.iRolRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Agustin
 */
@Service
@Transactional
public class RolService {
    @Autowired
    iRolRepository irolRepository;
    
   public Optional<Rol> getByRolNombre(RolNombre rolNombre){
       return irolRepository.findByRolNombre(rolNombre);
   }
   
   public void save(Rol rol){
       irolRepository.save(rol);
   }
}
