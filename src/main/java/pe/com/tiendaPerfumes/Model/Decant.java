package pe.com.tiendaPerfumes.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "decant")
@Data
public class Decant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_decant")
    private Long id;

    private double volumen_ml;

    private double precio;

    private int stock;

    @ManyToOne
    @JoinColumn(name = "id_perfume")
    private Perfume perfume;
}

