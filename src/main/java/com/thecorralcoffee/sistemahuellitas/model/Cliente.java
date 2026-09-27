/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thecorralcoffee.sistemahuellitas.model;

/**
 *
 * @author oliva
 */
public class Cliente {
   private int id;
   private String nombre;
   private String dpi;
   private String telefono;
   private String direccion;

    public Cliente() {
    }

    public Cliente(int id, String nombre, String dpi, String telefono, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.dpi = dpi;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public Cliente(String nombre, String dpi, String telefono, String direccion) {
        this.nombre = nombre;
        this.dpi = dpi;
        this.telefono = telefono;
        this.direccion = direccion;
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

    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
