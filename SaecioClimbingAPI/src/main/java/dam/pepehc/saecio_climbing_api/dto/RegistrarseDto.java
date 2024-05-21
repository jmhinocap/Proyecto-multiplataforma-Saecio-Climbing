package dam.pepehc.saecio_climbing_api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegistrarseDto {
    private String nombre;
    private String apellidos;
    private String usuario;
    private String correoElectronico;
    private String contrasena;
    private String foto;
}
