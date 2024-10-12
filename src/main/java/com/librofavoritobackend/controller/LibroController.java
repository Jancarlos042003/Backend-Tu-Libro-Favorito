
package com.librofavoritobackend.controller;

import com.librofavoritobackend.model.Libro;
import com.librofavoritobackend.service.LibroService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/libro")
public class LibroController {
    @Autowired
    private LibroService libroService;
    
    @GetMapping
    public ResponseEntity<?> getLibros(){
        return new ResponseEntity<>(libroService.findAll(), HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> findLibro(@PathVariable Long id){
        return new ResponseEntity<>(libroService.findById(id), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<?> saveLibro(@RequestBody Libro libro){
        return new ResponseEntity<>(libroService.save(libro), HttpStatus.CREATED);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteLibro(@PathVariable Long id){
        libroService.deleteById(id);  
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
