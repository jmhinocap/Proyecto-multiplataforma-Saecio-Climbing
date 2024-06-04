package dam.pepehc.saecio_climbing_api.resource;

import dam.pepehc.saecio_climbing_api.entity.Via;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * El tipo Aperturista resource.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AperturistaResource {
    private Long idAperturista;
    private Long idDatosPersona;
    private List<Via> vias;
}
