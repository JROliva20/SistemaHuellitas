/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thecorralcoffee.sistemahuellitas.DAO;

import com.thecorralcoffee.sistemahuellitas.model.Usuario;
import com.thecorralcoffee.sistemahuellitas.util.Conexion;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author oliva
 */
public class UsuarioDAO {
    //listar
    public List<Usuario> listar(){List<Usuario> lista = new ArrayList<>();

        String sql = "SELECT id, nombre, usuario, clave_hash, rol FROM usuario";
        try (Connection cn = Conexion.obtener();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {

                Usuario u = new Usuario();

                u.setId(rs.getInt("id"));
                u.setNombre(rs.getString("nombre"));
                u.setUsuario(rs.getString("usuario"));
                u.setClaveHash(rs.getString("clave_hash"));
                u.setRol(rs.getString("rol"));

                lista.add(u);
            }
        } catch (SQLException e) {System.out.println("Error al listar usuarios: " + e.getMessage());
        }
        return lista;
    }
    //buscamos por id
    public Usuario buscarPorId(int id) {
        String sql = "SELECT id, nombre, usuario, clave_hash, rol " + "FROM usuario WHERE id = ?";

        try (Connection cn = Conexion.obtener();
             PreparedStatement ps = cn.prepareStatement(sql)) {ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {

                    Usuario u = new Usuario();

                    u.setId(rs.getInt("id"));
                    u.setNombre(rs.getString("nombre"));
                    u.setUsuario(rs.getString("usuario"));
                    u.setClaveHash(rs.getString("clave_hash"));
                    u.setRol(rs.getString("rol"));

                    return u;
                }
            }
        } catch (SQLException e) {System.out.println("Error al buscar usuario: " + e.getMessage());
        }
        return null;
    }
    //insertar
     public boolean insertar(Usuario u) {
        String sql = "INSERT INTO usuario " + "(nombre, usuario, clave_hash, rol) "
                   + "VALUES (?, ?, ?, ?)";

        try (Connection cn = Conexion.obtener();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, u.getNombre());
            ps.setString(2, u.getUsuario());
            ps.setString(3, u.getClaveHash());
            ps.setString(4, u.getRol());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al insertar usuario: " + e.getMessage());
            return false;
        }
    }
     //actualizaf
    public boolean actualizar(Usuario u) {

        String sql = "UPDATE usuario SET "
                   + "nombre = ?, "
                   + "usuario = ?, "
                   + "clave_hash = ?, "
                   + "rol = ? "
                   + "WHERE id = ?";

        try (Connection cn = Conexion.obtener();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, u.getNombre());
            ps.setString(2, u.getUsuario());
            ps.setString(3, u.getClaveHash());
            ps.setString(4, u.getRol());
            ps.setInt(5, u.getId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al actualizar usuario: " + e.getMessage());
            return false;
        }
    }
    //eliminar
     public boolean eliminar(int id) {
        String sql = "DELETE FROM usuario WHERE id = ?";
        try (Connection cn = Conexion.obtener();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setInt(1, id);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al eliminar usuario: " + e.getMessage());
            return false;
        }
    }
     
    public Usuario login(String usuario, String clave) {
    String sql = "SELECT id, nombre, usuario, clave_hash, rol FROM usuario WHERE usuario = ? AND clave_hash = ?";
    try (Connection cn = Conexion.obtener();
         PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, usuario);
            ps.setString(2, clave);
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                Usuario u = new Usuario();

                u.setId(rs.getInt("id"));
                u.setNombre(rs.getString("nombre"));
                u.setUsuario(rs.getString("usuario"));
                u.setClaveHash(rs.getString("clave_hash"));
                u.setRol(rs.getString("rol"));

                return u;
            }
        }

    } catch (SQLException e) {
        System.out.println("Error al iniciar sesión: " + e.getMessage());
    }

    return null;
} 
}
