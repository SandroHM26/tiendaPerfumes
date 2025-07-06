package pe.com.tiendaPerfumes.DTO;

import lombok.Data;

import java.util.List;

@Data
public class PerfumeDTO {
    private Long id;
    private String nombre;
    private String marca;
    private String descripcion;
    private double precio;
    private int stock;
    private List<DecantDTO> decants;
}
