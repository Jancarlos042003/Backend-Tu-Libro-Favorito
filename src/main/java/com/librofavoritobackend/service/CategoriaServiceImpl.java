
package com.librofavoritobackend.service;

import com.librofavoritobackend.exception.ResourceNotFoundException;
import com.librofavoritobackend.model.Categoria;
import com.librofavoritobackend.repository.CategoriaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImpl implements CategoriaService {
    
    @Autowired
    CategoriaRepository categoriaRepository;
    
    @Override
    public List<Categoria> getCategorias(){
        return categoriaRepository.findAll();
    }
    
    @Override
    public Categoria getCategoria(Long id){
        return categoriaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Categoria no encontrado id: " + id));
    }
    
    @Override
    public Categoria saveCategoria(Categoria categoria){
        return categoriaRepository.save(categoria);
    }
}
