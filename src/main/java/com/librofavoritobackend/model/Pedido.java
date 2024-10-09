
package com.librofavoritobackend.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;
import lombok.Data;

@Data
@Entity
@Table(name = "pedido")
public class Pedido {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;
    
    @Column(nullable = false)
    private BigDecimal total;
    
    @Column(name = "fecha_pedido", nullable = false)
    private LocalDate fechaPedido;
    
    @OneToOne(mappedBy = "pedido")
    private Boleta boleta;
    
    @OneToOne(mappedBy = "pedido")
    private Pago pago;
    
    @OneToMany(mappedBy = "pedido")
    private Set<DetallePedido> detallePedidos;
}
