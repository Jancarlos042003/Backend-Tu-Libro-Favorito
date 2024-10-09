
package com.librofavoritobackend.controller;

import com.librofavoritobackend.model.Autor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.librofavoritobackend.service.AutorService;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/autor")
public class AutorController {
    
    @Autowired
    private AutorService autorService;
    
    @GetMapping
    public ResponseEntity<?> getAutores(){
        return new ResponseEntity<>(autorService.getAllAutores(), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<?> saveAutor(@RequestBody Autor autor){
        return new ResponseEntity<>(autorService.saveAutor(autor) ,HttpStatus.CREATED);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAutor(@PathVariable Long id){
        autorService.deleteAutor(id);
        return new ResponseEntity<>( HttpStatus.OK);
    }
}
