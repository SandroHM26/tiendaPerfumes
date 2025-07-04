package pe.com.tiendaPerfumes.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "orden_item")
@Data
public class OrdenItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_item")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_orden")
    @JsonBackReference
    private Orden orden;

    @ManyToOne
    @JoinColumn(name = "id_perfume")
    private Perfume perfume;
    @JoinColumn(name = "cantidad")
    private int cantidad;
    @Column(name = "precio_unitario")
    private double precioUnitario;
}

