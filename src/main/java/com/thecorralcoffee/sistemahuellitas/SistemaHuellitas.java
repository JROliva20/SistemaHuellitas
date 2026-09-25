/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.thecorralcoffee.sistemahuellitas;

import com.thecorralcoffee.sistemahuellitas.util.Conexion;

/**
 *
 * @author oliva
 */
public class SistemaHuellitas {

    public static void main(String[] args) {
        if (Conexion.probar()) {
            System.out.println("✅ Conexión exitosa a Aiven MySQL");
        } else {
            System.out.println("❌ No se pudo conectar a Aiven MySQL");
        }

    }
}
