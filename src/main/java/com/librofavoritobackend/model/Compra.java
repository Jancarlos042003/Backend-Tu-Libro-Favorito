
package com.librofavoritobackend.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;
import lombok.Data;

@Data
@Entity
@Table(name = "compra")
public class Compra {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "id_proveedor", nullable = false)
    private Proveedor proveedor;
    
    @Column(name = "fecha_compra", nullable = false)
    private LocalDate fechaCompra;
    
    @Column(nullable = false)
    private BigDecimal total;
    
    @OneToMany(mappedBy = "compra")
    private Set<DetalleCompra> detallecompras;
}
