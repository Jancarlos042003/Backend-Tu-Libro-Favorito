
package com.librofavoritobackend.model;

import java.util.Set;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "categoria")
public class Categoria {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true)
    private String nombre;
    
    @ManyToMany(mappedBy = "categorias")
    private Set<Libro> libros;
    
    @OneToMany(mappedBy = "categoria")
    private Set<Subcategoria> subcategorias;
}