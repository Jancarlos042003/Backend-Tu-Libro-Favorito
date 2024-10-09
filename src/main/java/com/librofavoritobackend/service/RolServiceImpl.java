
package com.librofavoritobackend.service;

import com.librofavoritobackend.model.Rol;
import com.librofavoritobackend.repository.RolRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolServiceImpl implements RolService {
    @Autowired
    private RolRepository rolRepository;
    
    @Override
    public Rol saveRol(Rol rol){
        return rolRepository.save(rol);
    }
    
    @Override
    public List<Rol> getRoles(){
        return rolRepository.findAll();
    }
}
