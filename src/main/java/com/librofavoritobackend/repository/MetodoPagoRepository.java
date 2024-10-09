
package com.librofavoritobackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.librofavoritobackend.model.MetodoPago;
import org.springframework.stereotype.Repository;

@Repository
public interface MetodoPagoRepository extends JpaRepository<MetodoPago, Long> {
}