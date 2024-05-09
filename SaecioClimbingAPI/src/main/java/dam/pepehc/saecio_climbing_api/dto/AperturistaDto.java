package dam.pepehc.saecio_climbing_api.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dam.pepehc.saecio_climbing_api.entity.DatosPersona;
import dam.pepehc.saecio_climbing_api.entity.Via;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AperturistaDto {
    
    @JsonIgnore
    private Long idAperturista;
    
    @NotNull(message = "Datos de aperturista no insertados")
    private Long idDatosPersona;
    
    @NotNull(message = "Vías no insertadas")
    private List<Via> vias;
}
