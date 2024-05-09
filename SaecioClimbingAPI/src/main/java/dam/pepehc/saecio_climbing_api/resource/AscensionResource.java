package dam.pepehc.SaecioClimbingAPI.resource;

import dam.pepehc.SaecioClimbingAPI.entity.Usuario;
import dam.pepehc.SaecioClimbingAPI.entity.Via;
import dam.pepehc.SaecioClimbingAPI.entity.clave_compuesta.AscensionClave;
import dam.pepehc.SaecioClimbingAPI.enums.TipoDeAscension;
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
