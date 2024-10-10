
package com.librofavoritobackend.controller;

import com.librofavoritobackend.model.Usuario;
import com.librofavoritobackend.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping
    public ResponseEntity<?> getUsuarios(){
        return new ResponseEntity<>(usuarioService.getAllUsuarios(), HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> getUsuario(@PathVariable Long id){
        return new ResponseEntity<>(usuarioService.getUsuario(id), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<?> saveUsuario(@RequestBody Usuario usuario) {
        try {
            usuario.setAdmin(usuario.isAdmin());
            return ResponseEntity.ok(usuarioService.saveUsuario(usuario));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al guardar el usuario: " + e.getMessage());
        }
    }
    
    @PutMapping
    public ResponseEntity<?> updateUsuario(@RequestBody Usuario usuario){
        return new ResponseEntity<>(usuarioService.updateUsuario(usuario), HttpStatus.OK);
    }
    
    @DeleteMapping
    public ResponseEntity<?> deleteUsuario(@PathVariable Long id){
        usuarioService.deleteUsuario(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
