
package com.librofavoritobackend.controller;

import com.librofavoritobackend.model.Categoria;
import com.librofavoritobackend.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {
    
    @Autowired
    CategoriaService categoriaService;
    
    @GetMapping("{id}")
    public ResponseEntity<?> getCategoria(@PathVariable Long id){
        return new ResponseEntity<>(categoriaService.getCategoria(id), HttpStatus.OK);
    }
    
    @GetMapping
    public ResponseEntity<?> getCategorias(){
        return new ResponseEntity<>(categoriaService.getCategorias(), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<?> saveCategoria(@RequestBody Categoria categoria){
        return new ResponseEntity<>(categoriaService.saveCategoria(categoria), HttpStatus.CREATED);
    }
}
