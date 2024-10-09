
package com.librofavoritobackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.librofavoritobackend.model.Proveedor;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {
}