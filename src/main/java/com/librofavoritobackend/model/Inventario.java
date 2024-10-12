
package com.librofavoritobackend.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import lombok.Data;

@Data
@Entity
@Table(name = "inventario")
public class Inventario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToOne
    @JoinColumn(name = "id_libro", nullable = false)
    private Libro libro;
    
    @Column(nullable = false)
    private int cantidad;
    
    @Column(nullable = false)
    private LocalDate fecha_actualizacion;
}
