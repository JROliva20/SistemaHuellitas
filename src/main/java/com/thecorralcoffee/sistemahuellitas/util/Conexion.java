/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thecorralcoffee.sistemahuellitas.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author oliva
 */
public class Conexion {
    private static final String HOST = "mysql-480f83a-olivajunnior336-dc7a.k.aivencloud.com";
    private static final String PUERTO = "15109";
    private static final String BD = "defaultdb";
    private static final String USER = "avnadmin";
    private static final String PASSWORD = "AVNS_G1-9PfSRnB4smfO5Ez3";
    
    private static final String URL = "jdbc:mysql://" + HOST + ":" + PUERTO +"/" + BD + "?ssl-mode=REQUIRED";
    
    public static Connection obtener() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    
    public static boolean probar(){
        try(Connection conexion = obtener()){
            return conexion != null && !conexion.isClosed();  
        } catch (SQLException e){ System.out.println("ERROR DE CONEXIÓN: " + e.getMessage());
        return false;
        }
    }        
}
