
package com.librofavoritobackend.service;

import com.librofavoritobackend.model.Usuario;
import com.librofavoritobackend.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    
    @Override
    public List<Usuario> getAllUsuarios(){
        return usuarioRepository.findAll();
    }
    
    @Override
    public Usuario getUsuario(Long id){
        return usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("El usuario no existe"));
    }
    
    
    @Override
    public Usuario saveUsuario(Usuario usuario) {
        // Seteamos la fecha actual 
        usuario.setFechaRegistro(LocalDate.now());

        // No es necesario guardar las credenciales por separado debido a CascadeType.ALL
        return usuarioRepository.save(usuario);
    }
    
    @Override
    public Usuario updateUsuario(Usuario usuario){
        if (usuarioRepository.existsById(usuario.getId())) { // Verificar si el usuario existe
            return usuarioRepository.save(usuario); // Guardar la actualización
        } else {
            throw new RuntimeException("El usuario no existe");
        }
    }
    
    @Override
    public void deleteUsuario(Long id) {
        if (usuarioRepository.existsById(id)) {
            try {
                usuarioRepository.deleteById(id);
            } catch (Exception e) {
                throw new RuntimeException("Error eliminando el usuario con ID " + id, e);
            }
        } else {
            throw new RuntimeException("El usuario con ID " + id + " no existe");
        }
    }
}
