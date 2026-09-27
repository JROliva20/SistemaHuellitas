/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thecorralcoffee.sistemahuellitas.controlador;

import com.thecorralcoffee.sistemahuellitas.DAO.MovimientoDAO;
import com.thecorralcoffee.sistemahuellitas.model.Movimientos;
import java.util.List;

/**
 *
 * @author oliva
 */
public class MovimientoController {
    private final MovimientoDAO movimientoDAO;
    
    public MovimientoController(){
        movimientoDAO = new MovimientoDAO();
    }
    
    public List<Movimientos> listarMovimientos(){
        return movimientoDAO.listar();
    }
    
    public Movimientos buscarPorId(int id) {
        return movimientoDAO.buscarPorId(id);
    }
    
    public boolean insertarMovimiento(Movimientos movimiento) {
        return movimientoDAO.insertar(movimiento);
    }

    public boolean actualizarMovimiento(Movimientos movimiento) {
        return movimientoDAO.actualizar(movimiento);
    }

    public boolean eliminarMovimiento(int id) {
        return movimientoDAO.eliminar(id);
    }
}
