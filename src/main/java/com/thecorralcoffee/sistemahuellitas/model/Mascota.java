/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thecorralcoffee.sistemahuellitas.model;

import java.time.LocalDate;

/**
 *
 * @author oliva
 */
public class Mascota {
   private int id;
    private String nombre;
    private String especie;
    private String raza;
    private LocalDate fechaNac;
    private int clienteId;

    public Mascota() {
    }

    public Mascota(int id, String nombre, String raza, LocalDate fechaNac, int clienteId) {
        this.id = id;
        this.nombre = nombre;
        this.raza = raza;
        this.fechaNac = fechaNac;
        this.clienteId = clienteId;
    }

    public Mascota(String nombre, String especie, String raza, LocalDate fechaNac, int clienteId) {
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.fechaNac = fechaNac;
        this.clienteId = clienteId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }
    
    
}
