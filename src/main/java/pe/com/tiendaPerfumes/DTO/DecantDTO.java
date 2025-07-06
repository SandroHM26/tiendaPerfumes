package pe.com.tiendaPerfumes.DTO;

import lombok.Data;

@Data
public class DecantDTO {
    private Long id;
    private double volumenMl;
    private double precio;
    private int stock;
    private Long perfumeId;
}
