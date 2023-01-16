/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.Vessoni.Controller;


import com.portfolio.Vessoni.Dto.DtoExp;
import com.portfolio.Vessoni.Entity.ExpLab;
import com.portfolio.Vessoni.Security.Controller.Mensaje;
import com.portfolio.Vessoni.Service.ExpService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
/**
 *
 * @author Agustin
 */
@RestController
@RequestMapping("/explab")
@CrossOrigin(origins = "https://vessweb.web.app")
public class ExpController {
@Autowired
ExpService expService;


@GetMapping("/lista")
public ResponseEntity<List<ExpLab>> list() {
List<ExpLab> list = expService.list();
return new ResponseEntity(list, HttpStatus.OK);
}

@GetMapping("/detail/{id}")
    public ResponseEntity<ExpLab> getById(@PathVariable("id") int id){
        if(!expService.existById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        ExpLab expLab = expService.getOne(id).get();
        return new ResponseEntity(expLab, HttpStatus.OK);
    }



@PostMapping("/create")
public ResponseEntity<?> create(@RequestBody DtoExp dtoexp){

    if(StringUtils.isBlank(dtoexp.getNombreE()))
        return new ResponseEntity(new Mensaje("Name is required"), HttpStatus.BAD_REQUEST);

    if(expService.existByNombreE(dtoexp.getNombreE()))
        return new ResponseEntity(new Mensaje("That experience already exist"), HttpStatus.BAD_REQUEST);

    ExpLab expLab = new ExpLab(dtoexp.getNombreE(), dtoexp.getDescripcionE());
    expService.save(expLab);
    return new ResponseEntity(new Mensaje("Experience added"), HttpStatus.OK);
}

@PutMapping("/update/{id}")
public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoExp dtoexp){
    if(!expService.existById(id))
        return new ResponseEntity(new Mensaje("Id doesn't exist"), HttpStatus.BAD_REQUEST);

    if(expService.existByNombreE(dtoexp.getNombreE()) && expService.getByNombreE(dtoexp.getNombreE()).get().getId() != id)
        return new ResponseEntity(new Mensaje("That experience already exist"), HttpStatus.BAD_REQUEST);


    if(StringUtils.isBlank(dtoexp.getNombreE()))
    return new ResponseEntity(new Mensaje("Name is required"), HttpStatus.BAD_REQUEST);

        ExpLab expLab = expService.getOne(id).get();
        expLab.setNombreE(dtoexp.getNombreE());
        expLab.setDescripcionE(dtoexp.getDescripcionE());
        expService.save(expLab);
        return new ResponseEntity(new Mensaje("Experience updated"), HttpStatus.OK);

}

@DeleteMapping("/delete/{id}")
public ResponseEntity<?> delete(@PathVariable("id") int id){
    if(!expService.existById(id)){
        return new ResponseEntity(new Mensaje("Id doesn't exist"), HttpStatus.NOT_FOUND);
    }
    expService.delete(id);
    return new ResponseEntity(new Mensaje("Experience deleted"), HttpStatus.OK);

}
}
