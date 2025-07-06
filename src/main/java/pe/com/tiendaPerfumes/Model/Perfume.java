package pe.com.tiendaPerfumes.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

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

    @OneToMany(mappedBy = "perfume", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Decant> decants;
}
