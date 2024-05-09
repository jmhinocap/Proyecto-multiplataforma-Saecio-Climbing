package dam.pepehc.saecio_climbing_api.resource;

import dam.pepehc.saecio_climbing_api.entity.Usuario;
import dam.pepehc.saecio_climbing_api.entity.Via;
import dam.pepehc.saecio_climbing_api.entity.clave_compuesta.AscensionClave;
import dam.pepehc.saecio_climbing_api.enums.TipoDeAscension;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AscensionResource {
    private AscensionClave idAscension;
    private Usuario usuario;
    private Via via;
    private String fechaAscension;
    private TipoDeAscension tipoDeAscension;
}
