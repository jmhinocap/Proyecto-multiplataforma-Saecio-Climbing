package dam.pepehc.saecio_climbing_api.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * El tipo Aperturista dto.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AperturistaDto {
    
    @JsonIgnore
    private Long idAperturista;
    
    @NotNull(message = "Datos de aperturista no insertados")
    private Long idDatosPersona;
    
    @JsonIgnore
    private List<ViaDto> vias;
}
