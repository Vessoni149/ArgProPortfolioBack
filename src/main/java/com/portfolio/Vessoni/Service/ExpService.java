/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.Vessoni.Service;


import com.portfolio.Vessoni.Entity.ExpLab;
import com.portfolio.Vessoni.Repository.ExpRepository;
import java.util.List;
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
public class ExpService {
@Autowired
ExpRepository expRepository;

public List<ExpLab> list(){
return expRepository.findAll();

	}

public Optional<ExpLab> getOne(int id){
return expRepository.findById(id);
	}

public Optional<ExpLab> getByNombreE(String nombreE){
return expRepository.findByNombreE(nombreE);
	}

public void save(ExpLab exp){
expRepository.save(exp);
	}

public void delete(int id){
expRepository.deleteById(id);
	}

public boolean existById(int id){
return expRepository.existsById(id);
	}

public boolean existByNombreE(String nombreE){
return expRepository.existsByNombreE(nombreE);
	}
}
