package pe.com.tiendaPerfumes.DTO;

import lombok.Data;

@Data
public class CarritoItemDTO {
    private Long id;
    private String nombrePerfume;
    private int cantidad;
    private double precioUnitario;
}
