
package com.librofavoritobackend.service;

import com.librofavoritobackend.model.Autor;
import com.librofavoritobackend.repository.AutoRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AutorServiceImpl implements AutorService{
    
   private final AutoRepository autorRepository;

    public AutorServiceImpl(AutoRepository autorRepository) {
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
