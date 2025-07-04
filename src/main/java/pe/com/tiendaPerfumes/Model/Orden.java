package pe.com.tiendaPerfumes.Model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "orden")
@Data
public class Orden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_orden")
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_carrito")
    @JsonManagedReference
    private Carrito carrito;

    private LocalDateTime fecha;
    private double total;
    private String estado;

    @OneToMany(mappedBy = "orden", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<OrdenItem> ordenItems;
}

