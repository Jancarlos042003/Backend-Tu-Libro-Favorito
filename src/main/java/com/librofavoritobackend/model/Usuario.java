
package com.librofavoritobackend.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Set;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String nombre;
    
    @Column(nullable = false)
    private String apellido;
    
    @Column(nullable = false)
    private String direccion;
    
    @Column(nullable = false)
    private String telefono;
    
    @Column(nullable = false)
    private String email;
    
    @Column(nullable = false)
    private String contrasenia;
    
    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;
    
    @ManyToOne
    @JoinColumn(name = "id_rol", nullable = false)
    private Rol rol;
    
    
    @Column(name = "fecha_registro")
    private LocalDate fechaRegistro;
    
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Set<Resenia> resenia;
    
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Set<Pedido> pedidos;
}
