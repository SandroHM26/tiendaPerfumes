package pe.com.tiendaPerfumes.DTO;

import lombok.Data;

@Data
public class ClienteDTO {
    private Long id;
    private String nombre;
    private String apellidos;
    private String correo;
    private String contraseña;
    private String direccion;
}
