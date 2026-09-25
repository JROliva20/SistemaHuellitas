/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thecorralcoffee.sistemahuellitas.DAO;

import com.thecorralcoffee.sistemahuellitas.model.Movimientos;
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
public class MovimientoDAO {
    public List<Movimientos> listar() {List<Movimientos> lista = new ArrayList<>();
        String sql = "SELECT id, tipo, cantidad, fecha, producto_id, usuario_id FROM movimiento";

        try (Connection cn = Conexion.obtener();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Movimientos m = new Movimientos();
                m.setId(rs.getInt("id"));
                m.setTipo(rs.getString("tipo"));
                m.setCantidad(rs.getInt("cantidad"));

                if (rs.getTimestamp("fecha") != null) {
                    m.setFecha(rs.getTimestamp("fecha").toLocalDateTime());
                }

                m.setProductoId(rs.getInt("producto_id"));
                m.setUsuarioId(rs.getInt("usuario_id"));
                lista.add(m);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar movimientos: " + e.getMessage());
        }

        return lista;
    }

    public Movimientos buscarPorId(int id) {
        String sql = "SELECT id, tipo, cantidad, fecha, producto_id, usuario_id FROM movimiento WHERE id = ?";

        try (Connection cn = Conexion.obtener();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Movimientos m = new Movimientos();
                    m.setId(rs.getInt("id"));
                    m.setTipo(rs.getString("tipo"));
                    m.setCantidad(rs.getInt("cantidad"));

                    if (rs.getTimestamp("fecha") != null) {
                        m.setFecha(rs.getTimestamp("fecha").toLocalDateTime());
                    }

                    m.setProductoId(rs.getInt("producto_id"));
                    m.setUsuarioId(rs.getInt("usuario_id"));
                    return m;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar movimiento: " + e.getMessage());
        }

        return null;
    }

    public boolean insertar(Movimientos m) {
        String sql = "INSERT INTO movimiento (tipo, cantidad, producto_id, usuario_id) VALUES (?, ?, ?, ?)";

        try (Connection cn = Conexion.obtener();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, m.getTipo());
            ps.setInt(2, m.getCantidad());
            ps.setInt(3, m.getProductoId());
            ps.setInt(4, m.getUsuarioId());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al insertar movimiento: " + e.getMessage());
            return false;
        }
    }

    public boolean actualizar(Movimientos m) {
        String sql = "UPDATE movimiento SET tipo = ?, cantidad = ?, producto_id = ?, usuario_id = ? WHERE id = ?";

        try (Connection cn = Conexion.obtener();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, m.getTipo());
            ps.setInt(2, m.getCantidad());
            ps.setInt(3, m.getProductoId());
            ps.setInt(4, m.getUsuarioId());
            ps.setInt(5, m.getId());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar movimiento: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM movimiento WHERE id = ?";

        try (Connection cn = Conexion.obtener();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar movimiento: " + e.getMessage());
            return false;
        }
    }
}
