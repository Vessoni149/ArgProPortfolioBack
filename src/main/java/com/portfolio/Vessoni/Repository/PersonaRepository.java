
package com.portfolio.Vessoni.Repository;

import com.portfolio.Vessoni.Entity.Persona;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PersonaRepository extends JpaRepository <Persona, Long>{
    
}
