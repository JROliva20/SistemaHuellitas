/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thecorralcoffee.sistemahuellitas.model;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author oliva
 */
public class Producto {
   private int id;
    private String codigo;
    private String nombre;
    private String categoria;
    private BigDecimal precio;
    private int stockMin;
    private LocalDate vence;

    public Producto() {
    }

    public Producto(int id, String codigo, String nombre, String categoria, BigDecimal precio, int stockMin, LocalDate vence) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.stockMin = stockMin;
        this.vence = vence;
    }

    public Producto(String codigo, String nombre, String categoria, BigDecimal precio, int stockMin, LocalDate vence) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.stockMin = stockMin;
        this.vence = vence;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public int getStockMin() {
        return stockMin;
    }

    public void setStockMin(int stockMin) {
        this.stockMin = stockMin;
    }

    public LocalDate getVence() {
        return vence;
    }

    public void setVence(LocalDate vence) {
        this.vence = vence;
    }
    
    
}
