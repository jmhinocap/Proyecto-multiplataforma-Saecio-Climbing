package dam.pepehc.SaecioClimbingAPI.resource;

import dam.pepehc.SaecioClimbingAPI.entity.DatosPersona;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AperturistaResource {
    private Long idAperturista;
    private DatosPersona datosPersona;
    private Long idPersona;
    private String nombre;
    private String apellidos;
    private File foto;
}
