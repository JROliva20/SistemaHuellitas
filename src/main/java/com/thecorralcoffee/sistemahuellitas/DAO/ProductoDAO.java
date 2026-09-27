/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thecorralcoffee.sistemahuellitas.DAO;

import com.thecorralcoffee.sistemahuellitas.model.Producto;
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
public class ProductoDAO {
     public List<Producto> listar() {List<Producto> lista = new ArrayList<>();
        String sql = "SELECT id, codigo, nombre, categoria, precio, stock_min, vence FROM producto";
        try (Connection cn = Conexion.obtener();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Producto p = new Producto();
                p.setId(rs.getInt("id"));
                p.setCodigo(rs.getString("codigo"));
                p.setNombre(rs.getString("nombre"));
                p.setCategoria(rs.getString("categoria"));
                p.setPrecio(rs.getBigDecimal("precio"));
                p.setStockMin(rs.getInt("stock_min"));

                if (rs.getDate("vence") != null) {
                    p.setVence(rs.getDate("vence").toLocalDate());
                }

                lista.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar productos: " + e.getMessage());
        }

        return lista;
    }

    public Producto buscarPorId(int id) {
        String sql = "SELECT id, codigo, nombre, categoria, precio, stock_min, vence FROM producto WHERE id = ?";

        try (Connection cn = Conexion.obtener();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Producto p = new Producto();
                    p.setId(rs.getInt("id"));
                    p.setCodigo(rs.getString("codigo"));
                    p.setNombre(rs.getString("nombre"));
                    p.setCategoria(rs.getString("categoria"));
                    p.setPrecio(rs.getBigDecimal("precio"));
                    p.setStockMin(rs.getInt("stock_min"));

                    if (rs.getDate("vence") != null) {
                        p.setVence(rs.getDate("vence").toLocalDate());
                    }

                    return p;
                }
            }
        } catch (SQLException e) {System.out.println("Error al buscar producto: " + e.getMessage());
        }

        return null;
    }
    
    public List<Producto> buscar(String texto) {

    List<Producto> lista = new ArrayList<>();

    String sql = "SELECT id, codigo, nombre, categoria, precio, stock_min, vence "
               + "FROM producto "
               + "WHERE codigo LIKE ? OR nombre LIKE ?";

    try (Connection cn = Conexion.obtener();
         PreparedStatement ps = cn.prepareStatement(sql)) {

        String busqueda = "%" + texto + "%";

        ps.setString(1, busqueda);
        ps.setString(2, busqueda);

        try (ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Producto p = new Producto();

                p.setId(rs.getInt("id"));
                p.setCodigo(rs.getString("codigo"));
                p.setNombre(rs.getString("nombre"));
                p.setCategoria(rs.getString("categoria"));
                p.setPrecio(rs.getBigDecimal("precio"));
                p.setStockMin(rs.getInt("stock_min"));

                if (rs.getDate("vence") != null) {
                    p.setVence(rs.getDate("vence").toLocalDate());
                }

                lista.add(p);
            }
        }

    } catch (SQLException e) {
        System.out.println("Error al buscar productos: " + e.getMessage());
    }

    return lista;
}

    public boolean insertar(Producto p) {
        String sql = "INSERT INTO producto (codigo, nombre, categoria, precio, stock_min, vence) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection cn = Conexion.obtener();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, p.getCodigo());
            ps.setString(2, p.getNombre());
            ps.setString(3, p.getCategoria());
            ps.setBigDecimal(4, p.getPrecio());
            ps.setInt(5, p.getStockMin());

            if (p.getVence() != null) {
                ps.setDate(6, java.sql.Date.valueOf(p.getVence()));
            } else {
                ps.setNull(6, java.sql.Types.DATE);
            }

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {System.out.println("Error al insertar producto: " + e.getMessage());
            return false;
        }
    }

    public boolean actualizar(Producto p) {
        String sql = "UPDATE producto SET codigo = ?, nombre = ?, categoria = ?, precio = ?, stock_min = ?, vence = ? WHERE id = ?";

        try (Connection cn = Conexion.obtener();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, p.getCodigo());
            ps.setString(2, p.getNombre());
            ps.setString(3, p.getCategoria());
            ps.setBigDecimal(4, p.getPrecio());
            ps.setInt(5, p.getStockMin());

            if (p.getVence() != null) {
                ps.setDate(6, java.sql.Date.valueOf(p.getVence()));
            } else {
                ps.setNull(6, java.sql.Types.DATE);
            }

            ps.setInt(7, p.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {System.out.println("Error al actualizar producto: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM producto WHERE id = ?";

        try (Connection cn = Conexion.obtener();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {System.out.println("Error al eliminar producto: " + e.getMessage());
            return false;
        }
    }   
}
