package dam.pepehc.saecio_climbing_api.resource;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dam.pepehc.saecio_climbing_api.entity.Ascension;
import dam.pepehc.saecio_climbing_api.entity.Rol;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * El tipo Usuario resource.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioResource {
    private Long idUsuario;
    private Long idDatosPersona;
    private String correoElectronico;
    private String nombreUsuario;
    private String contrasena;
    private List<Ascension> ascensiones;
    private List<Rol> roles;
}
