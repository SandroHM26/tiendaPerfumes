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

    private int cantidad;
    private double precioUnitario;
}

