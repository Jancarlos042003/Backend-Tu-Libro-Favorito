
package com.librofavoritobackend.service;

import com.librofavoritobackend.model.Libro;
import com.librofavoritobackend.repository.LibroRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.librofavoritobackend.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LibroServiceImpl implements LibroService {
    
    @Autowired
    private LibroRepository libroRepository;
    
    @Override
    public List<Libro> findAll() {
        return libroRepository.findAll();
    }
    
    @Override
    public Libro findById(Long id) {
        return libroRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Libro no encontrado id: " + id));
    }
    
    @Override
    public Libro save(Libro libro) {
        return libroRepository.save(libro);
    }
    
    @Override
    public void deleteById(Long id) {
        if (!libroRepository.existsById(id)) {
            throw new ResourceNotFoundException("Libro no encontrado con id: " + id);
        }
        libroRepository.deleteById(id);
    }
}
