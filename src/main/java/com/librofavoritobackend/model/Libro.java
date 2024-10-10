
package com.librofavoritobackend.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "libro")
public class Libro {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true)
    private Long isbn;
    
    @Column(nullable = false)
    private String titulo;
    
    @Column(name = "fecha_publicacion")
    private LocalDate fechaPublicacion;
    
    @Column(nullable = false)
    private BigDecimal precio;
    
    @Column(nullable = false)
    private BigDecimal descuento;
    
    @ManyToMany
    @JoinTable(
        name = "libros_categorias",
        joinColumns = @JoinColumn(name = "id_libro"),
        inverseJoinColumns = @JoinColumn(name = "id_categoria")
    )
    private Set<Categoria> categorias;
    
    @ManyToMany
    @JoinTable(
        name = "libros_autores",
        joinColumns = @JoinColumn(name = "id_libro"),
        inverseJoinColumns = @JoinColumn(name = "id_autor")
    )
    private Set<Autor> autores;
    
    @ManyToOne
    @JoinColumn(name = "id_editorial", nullable = false)
    private Editorial editorial;
    
    @OneToOne(mappedBy = "libro")   
    private DetalleLibro detalleLibro;
    
    @OneToMany(mappedBy = "libro")
    private Set<Resenia> resenias;
    
    @OneToMany(mappedBy = "libro")
    private Set<DetallePedido> detallePedidos;
    
    @OneToMany(mappedBy = "libro")
    private Set<DetalleCompra> detalleCompras;

    @ManyToOne
    @JoinColumn(name = "id_inventario", nullable = false)
    private Inventario inventario; 
}
