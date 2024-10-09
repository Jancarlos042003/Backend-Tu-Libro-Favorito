
package com.librofavoritobackend.model;

import jakarta.persistence.*;
import java.util.Set;
import lombok.Data;

@Data
@Entity
@Table(name = "proveedor")
public class Proveedor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, length = 120)
    private String nombre;
    
    @Column(nullable = false, length = 120)
    private String email;
    
    @Column(length = 20)
    private String telefono;
    
    @Column(length = 150)
    private String direccion;
    
    @OneToMany(mappedBy = "proveedor")
    private Set<Compra> compras;
}
