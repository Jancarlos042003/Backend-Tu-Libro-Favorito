
package com.librofavoritobackend.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Data;

@Data
@Entity
@Table(name = "detalle_compra")
public class DetalleCompra {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "id_compra", nullable = false)
    private Compra compra;
    
    @ManyToOne
    @JoinColumn(name = "id_libro", nullable = false)
    private Libro libro;
    
    @Column(nullable = false)
    private int cantidad;
    
    @Column(name = "precio_unidad", nullable = false)
    private BigDecimal precioUnidad;
    
    @Column(name = "fecha_entrega", nullable = false)
    private LocalDate fechaEntrega;
    
    @Column(name = "estado_compra", nullable = false)
    private EstadoCompra estadoCompra;
    
    
    public enum EstadoCompra{
        PENDIENTE,
        ENTREGADO,
        CANCELADO
    }
}
