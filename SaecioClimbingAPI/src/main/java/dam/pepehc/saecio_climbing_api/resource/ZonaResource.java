package dam.pepehc.SaecioClimbingAPI.resource;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ZonaResource {
    private Long idZona;
    private String nombre;
    private String coordenadas;
    private File foto;
}
