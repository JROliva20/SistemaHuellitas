/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thecorralcoffee.sistemahuellitas.model;

import java.time.LocalDateTime;

/**
 *
 * @author oliva
 */
public class Movimientos {
    private int id;
    private String tipo;
    private int cantidad;
    private LocalDateTime fecha;
    private int productoId;
  

    public Movimientos() {
    }

    public Movimientos(int id, String tipo, int cantidad, LocalDateTime fecha, int productoId, int usuarioId) {
        this.id = id;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.productoId = productoId;
    }

    public Movimientos(String tipo, int cantidad, LocalDateTime fecha, int productoId, int usuarioId) {
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.productoId = productoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public int getProductoId() {
        return productoId;
    }

    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }
}
