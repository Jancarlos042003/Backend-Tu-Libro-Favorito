
package com.librofavoritobackend.model;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "autor")
public class Autor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String nombreCompleto;
}
