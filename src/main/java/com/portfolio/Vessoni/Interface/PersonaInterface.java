
package com.portfolio.Vessoni.Interface;

import com.portfolio.Vessoni.Entity.Persona;
import java.util.List;


public interface PersonaInterface {
    public List<Persona> getPersona();
    
    public void savePersona(Persona persona);
    
    public void deletePersona(Long id);
    
    public Persona findPersona(Long id);
}
