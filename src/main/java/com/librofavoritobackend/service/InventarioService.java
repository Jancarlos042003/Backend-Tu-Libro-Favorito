
package com.librofavoritobackend.service;

import com.librofavoritobackend.model.Inventario;

public interface InventarioService {
    
    Inventario addInventario(Inventario inventario);
    
    Inventario updateStock(Long id_inventario, int cantidadCambiar);
    
    Inventario updateStockPorVenta(Long id_inventario, int cantidadVendida);
    
    int getLibroStock(Long id_libro);
}
