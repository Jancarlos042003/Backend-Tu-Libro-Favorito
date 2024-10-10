
package com.librofavoritobackend.service;

import com.librofavoritobackend.model.Categoria;
import java.util.List;

public interface CategoriaService {
    
    List<Categoria> getCategorias();
    
    Categoria getCategoria(Long id);
    
    Categoria saveCategoria(Categoria categoria);
}
