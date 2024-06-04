package dam.pepehc.saecio_climbing_api.resource;

import dam.pepehc.saecio_climbing_api.entity.Via;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * El tipo Sector resource.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SectorResource {
    private Long idSector;
    private Long idZona;
    private String nombre;
    private String coordenadas;
    private String croquis;
    private String foto;
    private List<String> tiposDeEscalada;
    private List<Via> vias;
}
