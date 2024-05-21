package dam.pepehc.saecio_climbing_api.resource;

import dam.pepehc.saecio_climbing_api.entity.Via;
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
    private Long idZona;
    private String nombre;
    private String coordenadas;
    private File croquis;
    private String foto;
    private List<Via> vias;
}
