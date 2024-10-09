
package com.librofavoritobackend.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Set;
import lombok.Data;

@Data
@Entity
@Table(name = "inventario")
public class Inventario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToMany(mappedBy = "inventario")
    private Set<Libro> libro;
    
    @Column(nullable = false)
    private int cantidad;
    
    @Column(nullable = false)
    private LocalDate fecha_actualizacion;
}
