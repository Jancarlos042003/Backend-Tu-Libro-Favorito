
package com.librofavoritobackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.librofavoritobackend.model.Boleta;
import org.springframework.stereotype.Repository;


@Repository
public interface BoletaRepository extends JpaRepository<Boleta, Long> {
}