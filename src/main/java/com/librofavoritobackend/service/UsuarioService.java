
package com.librofavoritobackend.service;

import com.librofavoritobackend.model.Usuario;
import java.util.List;

public interface UsuarioService {
    
    List<Usuario> getAllUsuarios();
    
    Usuario getUsuario(Long id);
    
    Usuario saveUsuario(Usuario usuario);
    
    Usuario updateUsuario(Usuario usuario);
    
    void deleteUsuario(Long id);
}
