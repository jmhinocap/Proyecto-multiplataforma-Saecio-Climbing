package dam.pepehc.saecio_climbing_api.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dam.pepehc.saecio_climbing_api.entity.DatosPersona;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NuevoAperturistaDto {
    
    @JsonIgnore
    private Long idAperturista;

    @NotNull(message = "Datos de aperturista no insertados")
    private DatosPersona datosPersona;
}
