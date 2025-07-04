package pe.com.tiendaPerfumes.DTO;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrdenDTO {
    private Long id;
    private LocalDateTime fecha;
    private double total;
    private String estado;
    private List<OrdenItemDTO> ordenItems;
}
