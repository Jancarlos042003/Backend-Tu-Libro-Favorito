
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
    
    @Column(nullable = false, length = 500)
    private String descripcion;
    
    @Column(nullable = false, length = 1000)
    private String resumen;
    
    @Column(name = "vista_previa", nullable = false, length = 5000)
    @Lob //para manejar campos de textos largos
    private String vistaPrevia;
    
    @Column(name = "img_portada", nullable = false)
    private String imgPortada;
    
    @Column(name = "img_subportada", nullable = false)
    private String imgSubportada;
    
    @ManyToMany
    @JoinTable(
        name = "libros_categorias",
        joinColumns = @JoinColumn(name = "id_libro"),
        inverseJoinColumns = @JoinColumn(name = "id_categoria")
    )
    private Set<Categoria> categorias;
    
    @ManyToOne
    @JoinColumn(name = "id_autor")
    private Autor autor;
    
    @ManyToOne
    @JoinColumn(name = "id_editorial", nullable = false)
    private Editorial editorial;
    
    @OneToMany(mappedBy = "libro")
    private Set<Resenia> resenias;

    @OneToOne(mappedBy = "libro")
    private Inventario inventario; 
}