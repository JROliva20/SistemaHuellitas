/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thecorralcoffee.sistemahuellitas.controlador;

import com.thecorralcoffee.sistemahuellitas.DAO.UsuarioDAO;
import com.thecorralcoffee.sistemahuellitas.model.Usuario;
import java.util.List;

/**
 *
 * @author oliva
 */
public class UsuarioController {
    private final UsuarioDAO usuarioDAO;

    public UsuarioController() {
        usuarioDAO = new UsuarioDAO();
    }

    public List<Usuario> listarUsuarios() {
        return usuarioDAO.listar();
    }

    public Usuario buscarUsuario(int id) {
        return usuarioDAO.buscarPorId(id);
    }

    public boolean insertarUsuario(Usuario usuario) {
        return usuarioDAO.insertar(usuario);
    }

    public boolean actualizarUsuario(Usuario usuario) {
        return usuarioDAO.actualizar(usuario);
    }

    public boolean eliminarUsuario(int id) {
        return usuarioDAO.eliminar(id);
    }
    
    public Usuario login(String usuario, String clave) {
        return usuarioDAO.login(usuario, clave);
    }
}
