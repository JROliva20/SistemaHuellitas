/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thecorralcoffee.sistemahuellitas.controlador;

import com.thecorralcoffee.sistemahuellitas.DAO.ClienteDAO;
import com.thecorralcoffee.sistemahuellitas.model.Cliente;
import java.util.List;

/**
 *
 * @author oliva
 */
public class ClienteController {
    private final ClienteDAO clienteDAO;

    public ClienteController() {
        clienteDAO = new ClienteDAO();
    }

    public List<Cliente> listarClientes() {
        return clienteDAO.listar();
    }

    public Cliente buscarCliente(int id) {
        return clienteDAO.buscarPorId(id);
    }

    public boolean guardarCliente(Cliente cliente) {
        return clienteDAO.insertar(cliente);
    }

    public boolean actualizarCliente(Cliente cliente) {
        return clienteDAO.actualizar(cliente);
    }

    public boolean eliminarCliente(int id) {
        return clienteDAO.eliminar(id);
    }
    
    public List<Cliente> buscarClientes(String texto) {
    return clienteDAO.buscar(texto);
    }
}
