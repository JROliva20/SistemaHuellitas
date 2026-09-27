/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thecorralcoffee.sistemahuellitas.controlador;

import com.thecorralcoffee.sistemahuellitas.DAO.MascotaDAO;
import com.thecorralcoffee.sistemahuellitas.model.Mascota;
import java.util.List;

/**
 *
 * @author oliva
 */
public class MascotaController {
    
    private final MascotaDAO mascotaDAO;
    
    public MascotaController() {
        mascotaDAO = new MascotaDAO();
    }
    
    public List<Mascota> listarMascotas() {
        return mascotaDAO.listar();
    }
    
    public Mascota buscarMascota(int id) {
        return mascotaDAO.buscarPorId(id);
    }
    
    public boolean insertarMascota(Mascota mascota) {
        return mascotaDAO.insertar(mascota);
    }
    
    public boolean actualizarMascota(Mascota mascota) {
        return mascotaDAO.actualizar(mascota);
    }
    
    public boolean eliminarMascota(int id) {
        return mascotaDAO.eliminar(id);
    }
    
    public List<Mascota> buscarMascotas(String texto) {
    return mascotaDAO.buscar(texto);
}
}
