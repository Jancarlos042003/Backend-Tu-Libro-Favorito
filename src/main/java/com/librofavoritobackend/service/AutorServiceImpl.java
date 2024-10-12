
package com.librofavoritobackend.service;

import com.librofavoritobackend.model.Autor;
import java.util.List;
import org.springframework.stereotype.Service;
import com.librofavoritobackend.repository.AutorRepository;

@Service
public class AutorServiceImpl implements AutorService{
    
   private final AutorRepository autorRepository;

    public AutorServiceImpl(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }   
    
    // CREAR UN AUTOR
    @Override
    public Autor saveAutor(Autor autor){
        return autorRepository.save(autor);
    }
    
    @Override
    public void deleteAutor(Long id){
         autorRepository.deleteById(id);
    }
    
    public List<Autor> getAllAutores(){
        return autorRepository.findAll();
    }
}
