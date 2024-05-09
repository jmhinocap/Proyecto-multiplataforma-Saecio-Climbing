package dam.pepehc.SaecioClimbingAPI.resource;

import dam.pepehc.SaecioClimbingAPI.entity.Zona;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SierraResource {
    private Long idSierra;
    private String nombre;
    private File foto;
    private List<Zona> zonas;
}
