package dam.pepehc.saecio_climbing_api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IniciarSesionDto {
    private String usuarioOCorreo;
    private String contrasena;
}
