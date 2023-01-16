
package com.portfolio.Vessoni.Service;

import com.portfolio.Vessoni.Entity.Persona;
import com.portfolio.Vessoni.Repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portfolio.Vessoni.Interface.PersonaInterface;

@Service
public class ImpPersonaService implements PersonaInterface{
    @Autowired PersonaRepository ipersonaRepository;
    
    @Override
    public List<Persona> getPersona() {
         List<Persona> persona = ipersonaRepository.findAll();
                 return persona;
    }

    @Override
    public void savePersona(Persona persona) {
        ipersonaRepository.save(persona);
    }

    @Override
    public void deletePersona(Long id) {
      ipersonaRepository.deleteById(id);

    }

    @Override
    public Persona findPersona(Long id) {
      Persona persona = ipersonaRepository.findById(id).orElse(null);
      return persona;
    }
    
    
}
