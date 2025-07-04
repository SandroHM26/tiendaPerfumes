package pe.com.tiendaPerfumes.DTO;

import lombok.Data;

@Data
public class OrdenItemDTO {
    private String nombrePerfume;
    private int cantidad;
    private double precioUnitario;
}
