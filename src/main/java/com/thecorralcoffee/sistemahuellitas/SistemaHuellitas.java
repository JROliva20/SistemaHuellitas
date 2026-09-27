/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.thecorralcoffee.sistemahuellitas;

import com.thecorralcoffee.sistemahuellitas.util.Conexion;
import com.thecorralcoffee.sistemahuellitas.vista.FrmLogin;

/**
 *
 * @author oliva
 */
public class SistemaHuellitas {
    public static void main(String[] args) {
     if (Conexion.probar()) {
            System.out.println("Conexión exitosa a Aiven MySQL");
            
            java.awt.EventQueue.invokeLater(() -> {
                new FrmLogin().setVisible(true);
            });

        } else {
            System.out.println("ERROR!! No se pudo conectar a Aiven MySQL");
     }
    }
}
