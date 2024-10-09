
package com.librofavoritobackend.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "detalle_libro")
public class DetalleLibro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_libro")
    private Libro libro;
    
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
}
