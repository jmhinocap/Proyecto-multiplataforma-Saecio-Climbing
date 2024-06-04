package dam.pepehc.saecio_climbing_api.resource;

import dam.pepehc.saecio_climbing_api.entity.Sector;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * El tipo Zona resource.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ZonaResource {
    private Long idZona;
    private Long idSierra;
    private String nombre;
    private String coordenadas;
    private String foto;
    private List<String> tiposDeEscalada;
    private List<Sector> sectores;
}
