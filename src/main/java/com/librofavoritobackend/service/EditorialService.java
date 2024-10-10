
package com.librofavoritobackend.service;

import com.librofavoritobackend.model.Editorial;
import java.util.List;

public interface EditorialService {
    
    Editorial saveEditorial(Editorial editorial);
    
    List<Editorial> getEditoriales();
}
