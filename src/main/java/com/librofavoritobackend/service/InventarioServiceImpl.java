
package com.librofavoritobackend.service;

import com.librofavoritobackend.model.Inventario;
import com.librofavoritobackend.model.Libro;
import com.librofavoritobackend.repository.InventarioRepository;
import jakarta.transaction.Transactional;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventarioServiceImpl implements InventarioService {
    @Autowired
    InventarioRepository inventarioRepository;
    
    @Autowired
    LibroService libroService;
    
    
    @Transactional // Significa que si ocurre un error durante la ejecución, todas las modificaciones a la base de datos se deshacen (rollback)
    @Override
    public Inventario addInventario(Inventario inventario) {
        inventario.setFecha_actualizacion(LocalDate.now());
        return inventarioRepository.save(inventario);
    }
    
    @Transactional
    @Override
    public Inventario updateStock(Long id_inventario, int cantidadCambiar) {
        Inventario inventario = inventarioRepository.findById(id_inventario)
            .orElseThrow(() -> new RuntimeException("Inventario no encontrado."));
        
        if (cantidadCambiar <= 0) {
            throw new IllegalArgumentException("El valor a cambiar debe ser mayor a 0");
        }
        
        int nuevaCantidad = inventario.getCantidad() + cantidadCambiar;
        inventario.setCantidad(nuevaCantidad);
        inventario.setFecha_actualizacion(LocalDate.now());
        return inventarioRepository.save(inventario);
    }
    
    @Transactional
    @Override
    public Inventario updateStockPorVenta(Long id_inventario, int cantidadVendida) {
        if (cantidadVendida <= 0) {
            throw new IllegalArgumentException("La cantidad vendida debe ser mayor que 0");
        }

        Inventario inventario = inventarioRepository.findById(id_inventario)
            .orElseThrow(() -> new RuntimeException("Inventario no encontrado"));

        if (inventario.getCantidad() < cantidadVendida) {
            throw new IllegalStateException("No hay suficiente stock para realizar esta venta");
        }

        inventario.setCantidad(inventario.getCantidad() - cantidadVendida);
        return inventarioRepository.save(inventario);
    }
    
    @Override
    public int getLibroStock(Long id_libro) {
        Libro libro = libroService.findById(id_libro);
        
        if(libro == null){
            throw new RuntimeException("Libro no encontrado");
        }
        
        if (libro.getInventario() == null) {
            throw new RuntimeException("Inventario no encontrado para este libro");
        }
        
        return libro.getInventario().getCantidad();
    }
}
