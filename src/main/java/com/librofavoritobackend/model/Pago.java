
package com.librofavoritobackend.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Data;

@Data
@Entity
@Table(name = "pago")
public class Pago {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToOne
    @JoinColumn(name = "id_pedido", nullable = false)
    private Pedido pedido;
    
    @ManyToOne
    @JoinColumn(name = "id_metodo_pago", nullable = false) 
    private MetodoPago metodoPago;
    
    @Column(nullable = false)
    private BigDecimal monto;
    
    @Enumerated(EnumType.STRING)  // Almacena el valor del ENUM como texto en la BD
    private EstadoPago estadoPago;
    
    @Column(nullable = false)
    private LocalDate fechaPago;
    
    
    public enum EstadoPago {
        PENDIENTE,
        COMPLETADO,
        FALLIDO
    }
}
