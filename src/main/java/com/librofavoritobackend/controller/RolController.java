
package com.librofavoritobackend.controller;

import com.librofavoritobackend.model.Rol;
import com.librofavoritobackend.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rol")
public class RolController {
    
    @Autowired
    private RolService rolService;
    
    @GetMapping
    public ResponseEntity<?> getRoles(){
        return new ResponseEntity<>(rolService.getRoles(), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<?> saveRol(@RequestBody Rol rol){
        return new ResponseEntity<>(rolService.saveRol(rol), HttpStatus.OK );
    }
}
