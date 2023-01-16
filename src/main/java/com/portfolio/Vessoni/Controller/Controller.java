
package com.portfolio.Vessoni.Controller;


import com.portfolio.Vessoni.Entity.Persona;
import com.portfolio.Vessoni.Interface.PersonaInterface;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "https://vessweb.web.app")
public class Controller {
    
    @Autowired PersonaInterface personaInterface;
    
    @GetMapping("/personas/traer")
    public List<Persona> getPersona(){
        return personaInterface.getPersona();
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/personas/crear")
    public String createPersona(@RequestBody Persona persona){
        personaInterface.savePersona(persona);
        return "person created correctly";  
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        personaInterface.deletePersona(id);
        return "Person deleted correctly";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping ("/personas/editar/{id}")
    public Persona editPersona(@PathVariable Long id,
                                @RequestParam("nombre") String nuevoNombre,
                                @RequestParam("apellido") String nuevoApellido,
                                @RequestParam("img") String nuevoImg){
        Persona persona = personaInterface.findPersona(id);
        persona.setNombre (nuevoNombre);
        persona.setApellido (nuevoApellido);
        persona.setImg (nuevoImg);
        personaInterface.savePersona(persona);
        return persona;  
    }   
    
     @GetMapping("/personas/traer/perfil")
    public Persona findPersona(){
        return personaInterface.findPersona((long)1);
    }
    
    
}



