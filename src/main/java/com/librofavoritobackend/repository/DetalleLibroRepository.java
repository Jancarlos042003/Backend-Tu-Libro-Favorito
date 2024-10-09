
package com.librofavoritobackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.librofavoritobackend.model.DetalleLibro;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleLibroRepository extends JpaRepository<DetalleLibro, Long> {
}
