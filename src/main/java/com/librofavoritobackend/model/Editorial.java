
package com.librofavoritobackend.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "editorial")
public class Editorial {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String nombre;
}
