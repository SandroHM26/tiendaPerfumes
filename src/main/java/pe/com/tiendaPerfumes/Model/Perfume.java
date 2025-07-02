package pe.com.tiendaPerfumes.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "perfume")
@Data
public class Perfume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_perfume")
    private Long id;

    private String nombre;
    private String marca;
    private String descripcion;
    private double precio;
    private int stock;
}

