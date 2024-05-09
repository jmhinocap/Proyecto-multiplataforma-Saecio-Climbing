package dam.pepehc.SaecioClimbingAPI.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dam.pepehc.SaecioClimbingAPI.entity.Usuario;
import dam.pepehc.SaecioClimbingAPI.entity.Via;
import dam.pepehc.SaecioClimbingAPI.entity.clave_compuesta.AscensionClave;
import dam.pepehc.SaecioClimbingAPI.enums.TipoDeAscension;
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
    
    @NotBlank(message = "Fecha de ascensión vacía")
    private String fechaAscension;
    
    @NotNull(message = "Tipo de ascensión nulo")
    private TipoDeAscension tipoDeAscension;
}
