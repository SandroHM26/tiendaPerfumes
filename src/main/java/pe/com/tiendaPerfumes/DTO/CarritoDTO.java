package pe.com.tiendaPerfumes.DTO;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class CarritoDTO {
    private Long id;
    private LocalDateTime fecha;
    private ClienteDTO cliente;
    private List<CarritoItemDTO> carritoItems;
}

