package dam.pepehc.saecio_climbing_api.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dam.pepehc.saecio_climbing_api.entity.Usuario;
import dam.pepehc.saecio_climbing_api.entity.Via;
import dam.pepehc.saecio_climbing_api.entity.clave_compuesta.AscensionClave;
import dam.pepehc.saecio_climbing_api.enums.TipoDeAscension;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AscensionDto {
    
    @JsonIgnore
    private AscensionClave idAscension;
    
    @NotNull(message = "Usuario nulo")
    private Usuario usuario;
    
    @NotNull(message = "Via nulo")
    private Via via;
    
    @NotNull(message = "Fecha de ascensión vacía")
    private String fechaAscension;
    
    @NotNull(message = "Tipo de ascensión nulo")
    private TipoDeAscension tipoDeAscension;
}
