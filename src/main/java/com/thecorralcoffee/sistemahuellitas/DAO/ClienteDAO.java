/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thecorralcoffee.sistemahuellitas.DAO;

import com.thecorralcoffee.sistemahuellitas.model.Cliente;
import com.thecorralcoffee.sistemahuellitas.util.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author oliva
 */
public class ClienteDAO {
  public List<Cliente> listar() {List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT id, nombre, telefono, correo FROM cliente";
        try (Connection cn = Conexion.obtener();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Cliente c = new Cliente();
                c.setId(rs.getInt("id"));
                c.setNombre(rs.getString("nombre"));
                c.setTelefono(rs.getString("telefono"));
                c.setCorreo(rs.getString("correo"));
                lista.add(c);
            }
        } catch (SQLException e) {System.out.println("Error al listar clientes: " + e.getMessage());
        }
        return lista;
    }

    public Cliente buscarPorId(int id) {

        String sql = "SELECT id, nombre, telefono, correo " + "FROM cliente WHERE id = ?";
        try (Connection cn = Conexion.obtener();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Cliente c = new Cliente();
                    c.setId(rs.getInt("id"));
                    c.setNombre(rs.getString("nombre"));
                    c.setTelefono(rs.getString("telefono"));
                    c.setCorreo(rs.getString("correo"));

                    return c;
                }
            }
        } catch (SQLException e) {System.out.println("Error al buscar cliente: " + e.getMessage());
        }
        return null;
    }

    public boolean insertar(Cliente c) {
        String sql = "INSERT INTO cliente "
                   + "(nombre, telefono, correo) "
                   + "VALUES (?, ?, ?)";

        try (Connection cn = Conexion.obtener();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, c.getNombre());
            ps.setString(2, c.getTelefono());
            ps.setString(3, c.getCorreo());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {System.out.println("Error al insertar cliente: " + e.getMessage());
            return false;
        }
    }

    public boolean actualizar(Cliente c) {
        String sql = "UPDATE cliente SET "
                   + "nombre = ?, "
                   + "telefono = ?, "
                   + "correo = ? "
                   + "WHERE id = ?";

        try (Connection cn = Conexion.obtener();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, c.getNombre());
            ps.setString(2, c.getTelefono());
            ps.setString(3, c.getCorreo());
            ps.setInt(4, c.getId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {System.out.println("Error al actualizar cliente: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM cliente WHERE id = ?";

        try (Connection cn = Conexion.obtener();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setInt(1, id);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {System.out.println("Error al eliminar cliente: " + e.getMessage());
            return false;
        }
    }  
}
