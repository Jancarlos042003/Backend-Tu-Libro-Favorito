
package com.librofavoritobackend.controller;

import com.librofavoritobackend.model.Editorial;
import com.librofavoritobackend.service.EditorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/editorial")
public class EditorialController {
    
    @Autowired
    EditorialService editorialService;
    
    @GetMapping
    public ResponseEntity<?> getEditoriales(){
        return new ResponseEntity<>(editorialService.getEditoriales(), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<?> saveEditorial(@RequestBody Editorial editorial){
        return new ResponseEntity<>(editorialService.saveEditorial(editorial), HttpStatus.CREATED);
    }
}
