
package com.librofavoritobackend.service;

import com.librofavoritobackend.model.Editorial;
import com.librofavoritobackend.repository.EditorialRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditorialServiceImpl implements EditorialService {
    
    @Autowired
    EditorialRepository editorialRepository;
    
    @Override
    public Editorial saveEditorial(Editorial editorial){
        return editorialRepository.save(editorial);
    }
    
    @Override
    public List<Editorial> getEditoriales(){
        return editorialRepository.findAll();
    }
}
