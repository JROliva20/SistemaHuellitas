/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thecorralcoffee.sistemahuellitas.DAO;

import com.thecorralcoffee.sistemahuellitas.model.Producto;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 *
 * @author oliva
 */
public class ProductoDAOTest {
    private final ProductoDAO dao = new ProductoDAO();

    @Test
    void testCRUDProducto() {

        Producto producto = new Producto(
                "TEST-001",
                "Producto JUnit",
                "Prueba",
                new BigDecimal("25.50"),
                5,
                LocalDate.now().plusMonths(6)
        );

        //insertar
        boolean insertado = dao.insertar(producto);
        assertTrue(insertado, "El producto debería insertarse correctamente");
        
          // OBTENER ID DEL PRODUCTO INSERTADO
        List<Producto> productos = dao.listar();
        Producto encontrado = productos.stream()
                .filter(p -> "TEST-001".equals(p.getCodigo()))
                .findFirst()
                .orElse(null);

        assertNotNull(encontrado, "El producto debería existir después de insertarlo");

        int id = encontrado.getId();

        //buscar
        Producto buscado = dao.buscarPorId(id);

        assertNotNull(buscado, "El producto debería encontrarse por ID");
        assertEquals("TEST-001", buscado.getCodigo());
        assertEquals("Producto JUnit", buscado.getNombre());

        //atualizar
        buscado.setNombre("Producto JUnit Actualizado");
        buscado.setPrecio(new BigDecimal("30.00"));

        boolean actualizado = dao.actualizar(buscado);

        assertTrue(actualizado, "El producto debería actualizarse correctamente");

        Producto actualizadoBD = dao.buscarPorId(id);

        assertNotNull(actualizadoBD);
        assertEquals("Producto JUnit Actualizado", actualizadoBD.getNombre());
        assertEquals(new BigDecimal("30.00"), actualizadoBD.getPrecio());

        //eliminar
        boolean eliminado = dao.eliminar(id);
        assertTrue(eliminado, "El producto debería eliminarse correctamente");
        Producto eliminadoBD = dao.buscarPorId(id);
        assertNull(eliminadoBD, "El producto ya no debería existir");
    }
}
