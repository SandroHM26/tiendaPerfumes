package pe.com.tiendaPerfumes.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "carrito_item")
@Data
public class CarritoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_item")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_carrito")
    @JsonBackReference
    private Carrito carrito;

    @ManyToOne
    @JoinColumn(name = "id_perfume")
    private Perfume perfume;

    private int cantidad;
    private double precioUnitario;
}
