
package com.librofavoritobackend.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import lombok.Data;

@Data
@Entity
@Table(name = "resenia")
public class Resenia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;
    
    @ManyToOne
    @JoinColumn(name = "id_libro", nullable = false)
    private Libro libro;
    
    @Column(nullable = false, length = 500)
    private String comentario;
    
    @Column(nullable = false)        
    private int calificacion;
    
    @Column(name = "fecha_resenia")
    private LocalDate fechaResenia;
}
