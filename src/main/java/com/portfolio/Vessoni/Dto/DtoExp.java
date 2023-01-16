/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.Vessoni.Dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author Agustin
 */
public class DtoExp {
@NotBlank
private String nombreE;
@NotBlank
private String descripcionE;

    public DtoExp() {
    }

    public DtoExp(String nombreE, String despricpionE) {
        this.nombreE = nombreE;
        this.descripcionE = despricpionE;
    }

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String despricpionE) {
        this.descripcionE = despricpionE;
    }



}
