/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thecorralcoffee.sistemahuellitas.controlador;

import com.thecorralcoffee.sistemahuellitas.DAO.CitaDAO;
import com.thecorralcoffee.sistemahuellitas.model.Cita;
import java.util.List;

/**
 *
 * @author oliva
 */
public class CitaController {
    private final CitaDAO citaDAO;

    public CitaController() {
        citaDAO = new CitaDAO();
    }

    public List<Cita> listarCitas() {
        return citaDAO.listar();
    }

    public Cita buscarCita(int id) {
        return citaDAO.buscarPorId(id);
    }

    public boolean insertarCita(Cita cita) {
        return citaDAO.insertar(cita);
    }

    public boolean actualizarCita(Cita cita) {
        return citaDAO.actualizar(cita);
    }

    public boolean eliminarCita(int id) {
        return citaDAO.eliminar(id);
    }
}
