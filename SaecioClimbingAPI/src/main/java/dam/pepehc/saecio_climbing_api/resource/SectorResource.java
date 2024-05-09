package dam.pepehc.SaecioClimbingAPI.resource;

import dam.pepehc.SaecioClimbingAPI.entity.Via;
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
public class SectorResource {
    private Long idSector;
    private String nombre;
    private String coordenadas;
    private File croquis;
    private File foto;
    private List<Via> vias;
}
