
package com.librofavoritobackend.model;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "subcategoria")
public class Subcategoria {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "id_categoria", nullable = false)
    private Categoria categoria;
    
    @Column(nullable = false)
    private String nombre; 
}