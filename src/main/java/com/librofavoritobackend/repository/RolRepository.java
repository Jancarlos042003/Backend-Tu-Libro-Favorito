
package com.librofavoritobackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.librofavoritobackend.model.Rol;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {
}