
package com.librofavoritobackend.service;

import com.librofavoritobackend.model.Rol;
import java.util.List;

public interface RolService {
    
     Rol saveRol(Rol rol);
     
     List<Rol> getRoles();
}
