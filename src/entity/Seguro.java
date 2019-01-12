/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.time.Clock;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author joshu
 */
public class Seguro implements Serializable{
    
    private int IdSeguro, edad, numHijos;
    private String nif, nombre, ape1, ape2;
    private Date fechaCreacion;

    public Seguro() {
        
    }
    
    public Seguro(int id) {
        this.IdSeguro = id;
    }

    public Seguro(int IdSeguro, String nif, String nombre, String ape1, String ape2, int edad, int numHijos) {
        this.IdSeguro = IdSeguro;
        this.edad = edad;
        this.numHijos = numHijos;
        this.nif = nif;
        this.nombre = nombre;
        this.ape1 = ape1;
        this.ape2 = ape2;
        this.fechaCreacion = new Date();
    }

    @Override
    public String toString() {
        return "Seguro{" + "IdSeguro=" + IdSeguro + ", edad=" + edad + ", numHijos=" + numHijos + ", nif=" + nif + ", nombre=" + nombre + ", ape1=" + ape1 + ", ape2=" + ape2 + ", fechaCreacion=" + fechaCreacion + '}';
    }
    
    public int getIdSeguro() {
        return IdSeguro;
    }

    public void setIdSeguro(int IdSeguro) {
        this.IdSeguro = IdSeguro;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getNumHijos() {
        return numHijos;
    }

    public void setNumHijos(int numHijos) {
        this.numHijos = numHijos;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApe1() {
        return ape1;
    }

    public void setApe1(String ape1) {
        this.ape1 = ape1;
    }

    public String getApe2() {
        return ape2;
    }

    public void setApe2(String ape2) {
        this.ape2 = ape2;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    
    
}
