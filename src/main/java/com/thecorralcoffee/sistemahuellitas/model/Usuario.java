/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thecorralcoffee.sistemahuellitas.model;

/**
 *
 * @author oliva
 */
public class Usuario {
    private int id;
    private String nombre;
    private String usuario;
    private String claveHash;
    private String rol;
    
    public Usuario(){
    }

    public Usuario(int id, String nombre, String usuario, String claveHash, String rol) {
        this.id = id;
        this.nombre = nombre;
        this.usuario = usuario;
        this.claveHash = claveHash;
        this.rol = rol;
    }

    public Usuario(String nombre, String usuario, String claveHash, String rol) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.claveHash = claveHash;
        this.rol = rol;
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClaveHash() {
        return claveHash;
    }

    public void setClaveHash(String claveHash) {
        this.claveHash = claveHash;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
    
}
