
package com.librofavoritobackend.controller;

import com.librofavoritobackend.model.Inventario;
import com.librofavoritobackend.service.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/inventario")
public class InventarioController {
    
    @Autowired
    InventarioService inventarioService;
    
    @PostMapping
    public ResponseEntity<?> addInventario(@RequestBody Inventario inventario) {
        return new ResponseEntity<>(inventario, HttpStatus.CREATED);
    }

    @PutMapping("/{id_inventario}/actualizar-stock")
    public ResponseEntity<?> updateStock(@PathVariable Long id_inventario, @RequestParam int cantidadCambiar) {
        Inventario inventarioActualizado = inventarioService.updateStock(id_inventario, cantidadCambiar);
        return new ResponseEntity<>(inventarioActualizado, HttpStatus.OK);
    }

    @PutMapping("/{id_inventario}/actualizar-stock-venta")
    public ResponseEntity<?> updateStockPorVenta(@PathVariable Long id_inventario, @RequestParam int cantidadVendida) {
        Inventario inventarioActualizado = inventarioService.updateStockPorVenta(id_inventario, cantidadVendida);
        return new ResponseEntity<>(inventarioActualizado, HttpStatus.OK);
    }
}
