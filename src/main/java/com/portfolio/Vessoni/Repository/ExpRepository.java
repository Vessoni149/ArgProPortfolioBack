/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.Vessoni.Repository;

import com.portfolio.Vessoni.Entity.ExpLab;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Agustin
 */
@Repository
public interface ExpRepository extends JpaRepository<ExpLab, Integer> {
public Optional<ExpLab> findByNombreE(String nombreE);
public boolean existsByNombreE(String nombreE);
}
