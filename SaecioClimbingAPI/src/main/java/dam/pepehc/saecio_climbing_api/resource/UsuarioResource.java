package dam.pepehc.SaecioClimbingAPI.resource;

import dam.pepehc.SaecioClimbingAPI.entity.Ascension;
import dam.pepehc.SaecioClimbingAPI.entity.DatosPersona;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioResource {
    private Long idUsuario;
    private DatosPersona datosPersona;
    private String correoElectronico;
    private String contrasena;
    private List<Ascension> ascensiones;
}
