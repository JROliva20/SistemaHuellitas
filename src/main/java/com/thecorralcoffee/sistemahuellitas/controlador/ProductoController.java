/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thecorralcoffee.sistemahuellitas.controlador;

import com.thecorralcoffee.sistemahuellitas.DAO.ProductoDAO;
import com.thecorralcoffee.sistemahuellitas.model.Producto;
import java.util.List;

/**
 *
 * @author oliva
 */
public class ProductoController {
    private final ProductoDAO productoDAO;
    
    public ProductoController() {
        productoDAO = new ProductoDAO();
    }
    
    public List<Producto> listarProductos(){
        return productoDAO.listar();
    }
    
    public Producto buscarProducto(int id) {
        return productoDAO.buscarPorId(id);
    }
    
    public boolean guardarProducto(Producto producto) {
        return productoDAO.insertar(producto);
    }
    
    public boolean actualizarProducto(Producto producto) {
        return productoDAO.actualizar(producto);
    }
    
    public boolean eliminarProducto(int id) {
        return productoDAO.eliminar(id);
    }
    
    public List<Producto> buscarProductos(String texto) {
        return productoDAO.buscar(texto);
    }
}
