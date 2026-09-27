/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thecorralcoffee.sistemahuellitas.DAO;

import com.thecorralcoffee.sistemahuellitas.model.Mascota;
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
public class MascotaDAO {
    public List<Mascota> listar() {List<Mascota> lista = new ArrayList<>();
        String sql = "SELECT id, nombre, especie, raza, fecha_nac, cliente_id FROM mascota";

        try (Connection cn = Conexion.obtener();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Mascota m = new Mascota();
                m.setId(rs.getInt("id"));
                m.setNombre(rs.getString("nombre"));
                m.setEspecie(rs.getString("especie"));
                m.setRaza(rs.getString("raza"));

                if (rs.getDate("fecha_nac") != null) {
                    m.setFechaNac(rs.getDate("fecha_nac").toLocalDate());
                }

                m.setClienteId(rs.getInt("cliente_id"));
                lista.add(m);
            }
        } catch (SQLException e) {System.out.println("Error al listar mascotas: " + e.getMessage());
        }

        return lista;
    }

    public Mascota buscarPorId(int id) {
        String sql = "SELECT id, nombre, especie, raza, fecha_nac, cliente_id FROM mascota WHERE id = ?";

        try (Connection cn = Conexion.obtener();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Mascota m = new Mascota();
                    m.setId(rs.getInt("id"));
                    m.setNombre(rs.getString("nombre"));
                    m.setEspecie(rs.getString("especie"));
                    m.setRaza(rs.getString("raza"));

                    if (rs.getDate("fecha_nac") != null) {
                        m.setFechaNac(rs.getDate("fecha_nac").toLocalDate());
                    }

                    m.setClienteId(rs.getInt("cliente_id"));
                    return m;
                }
            }
        } catch (SQLException e) {System.out.println("Error al buscar mascota: " + e.getMessage());
        }

        return null;
    }
    
    public List<Mascota> buscar(String texto) {
    List<Mascota> lista = new ArrayList<>();

    String sql = "SELECT id, nombre, especie, raza, fecha_nac, cliente_id "
               + "FROM mascota WHERE nombre LIKE ?";

    try (Connection cn = Conexion.obtener();
         PreparedStatement ps = cn.prepareStatement(sql)) {

        ps.setString(1, "%" + texto + "%");

        try (ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Mascota m = new Mascota();

                m.setId(rs.getInt("id"));
                m.setNombre(rs.getString("nombre"));
                m.setEspecie(rs.getString("especie"));
                m.setRaza(rs.getString("raza"));

                if (rs.getDate("fecha_nac") != null) {
                    m.setFechaNac(rs.getDate("fecha_nac").toLocalDate());
                }

                m.setClienteId(rs.getInt("cliente_id"));

                lista.add(m);
            }
        }

    } catch (SQLException e) {
        System.out.println("Error al buscar mascotas: " + e.getMessage());
    }

    return lista;
}

    public boolean insertar(Mascota m) {
        String sql = "INSERT INTO mascota (nombre, especie, raza, fecha_nac, cliente_id) VALUES (?, ?, ?, ?, ?)";

        try (Connection cn = Conexion.obtener();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, m.getNombre());
            ps.setString(2, m.getEspecie());
            ps.setString(3, m.getRaza());

            if (m.getFechaNac() != null) {
                ps.setDate(4, java.sql.Date.valueOf(m.getFechaNac()));
            } else {
                ps.setNull(4, java.sql.Types.DATE);
            }

            ps.setInt(5, m.getClienteId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {System.out.println("Error al insertar mascota: " + e.getMessage());
            return false;
        }
    }

    public boolean actualizar(Mascota m) {
        String sql = "UPDATE mascota SET nombre = ?, especie = ?, raza = ?, fecha_nac = ?, cliente_id = ? WHERE id = ?";

        try (Connection cn = Conexion.obtener();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, m.getNombre());
            ps.setString(2, m.getEspecie());
            ps.setString(3, m.getRaza());

            if (m.getFechaNac() != null) {
                ps.setDate(4, java.sql.Date.valueOf(m.getFechaNac()));
            } else {
                ps.setNull(4, java.sql.Types.DATE);
            }

            ps.setInt(5, m.getClienteId());
            ps.setInt(6, m.getId());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {System.out.println("Error al actualizar mascota: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM mascota WHERE id = ?";

        try (Connection cn = Conexion.obtener();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {System.out.println("Error al eliminar mascota: " + e.getMessage());
            return false;
        }
    }
}
