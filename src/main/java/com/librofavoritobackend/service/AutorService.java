
package com.librofavoritobackend.service;

import com.librofavoritobackend.model.Autor;
import java.util.List;

public interface AutorService {
    
    Autor saveAutor(Autor autor);
    
    void deleteAutor(Long id);
    
    List<Autor> getAllAutores();
}
