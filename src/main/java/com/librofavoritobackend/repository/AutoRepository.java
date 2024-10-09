
package com.librofavoritobackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.librofavoritobackend.model.Autor;
import org.springframework.stereotype.Repository;

@Repository
public interface AutoRepository extends JpaRepository<Autor, Long> {
}

