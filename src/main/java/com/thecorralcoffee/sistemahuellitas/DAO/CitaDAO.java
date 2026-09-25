/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thecorralcoffee.sistemahuellitas.DAO;

import com.thecorralcoffee.sistemahuellitas.model.Cita;
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
public class CitaDAO {
    public List<Cita> listar() {List<Cita> lista = new ArrayList<>();
        String sql = "SELECT id, fecha, hora, motivo, diagnostico, mascota_id, vet_id FROM cita";
        try (Connection cn = Conexion.obtener();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Cita c = new Cita();
                c.setId(rs.getInt("id"));
                c.setFecha(rs.getDate("fecha").toLocalDate());
                c.setHora(rs.getTime("hora").toLocalTime());
                c.setMotivo(rs.getString("motivo"));
                c.setDiagnostico(rs.getString("diagnostico"));
                c.setMascotaId(rs.getInt("mascota_id"));
                c.setVetId(rs.getInt("vet_id"));
                lista.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar citas: " + e.getMessage());
        }
        return lista;
    }

    public Cita buscarPorId(int id) {
        String sql = "SELECT id, fecha, hora, motivo, diagnostico, mascota_id, vet_id FROM cita WHERE id = ?";

        try (Connection cn = Conexion.obtener();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Cita c = new Cita();
                    c.setId(rs.getInt("id"));
                    c.setFecha(rs.getDate("fecha").toLocalDate());
                    c.setHora(rs.getTime("hora").toLocalTime());
                    c.setMotivo(rs.getString("motivo"));
                    c.setDiagnostico(rs.getString("diagnostico"));
                    c.setMascotaId(rs.getInt("mascota_id"));
                    c.setVetId(rs.getInt("vet_id"));
                    return c;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar cita: " + e.getMessage());
        }

        return null;
    }

    public boolean insertar(Cita c) {
        String sql = "INSERT INTO cita (fecha, hora, motivo, diagnostico, mascota_id, vet_id) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection cn = Conexion.obtener();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setDate(1, java.sql.Date.valueOf(c.getFecha()));
            ps.setTime(2, java.sql.Time.valueOf(c.getHora()));
            ps.setString(3, c.getMotivo());
            ps.setString(4, c.getDiagnostico());
            ps.setInt(5, c.getMascotaId());
            ps.setInt(6, c.getVetId());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al insertar cita: " + e.getMessage());
            return false;
        }
    }

    public boolean actualizar(Cita c) {
        String sql = "UPDATE cita SET fecha = ?, hora = ?, motivo = ?, diagnostico = ?, mascota_id = ?, vet_id = ? WHERE id = ?";

        try (Connection cn = Conexion.obtener();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setDate(1, java.sql.Date.valueOf(c.getFecha()));
            ps.setTime(2, java.sql.Time.valueOf(c.getHora()));
            ps.setString(3, c.getMotivo());
            ps.setString(4, c.getDiagnostico());
            ps.setInt(5, c.getMascotaId());
            ps.setInt(6, c.getVetId());
            ps.setInt(7, c.getId());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar cita: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM cita WHERE id = ?";

        try (Connection cn = Conexion.obtener();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar cita: " + e.getMessage());
            return false;
        }
    }
}
