package dam.pepehc.SaecioClimbingAPI.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dam.pepehc.SaecioClimbingAPI.entity.Apertura;
import dam.pepehc.SaecioClimbingAPI.entity.DatosPersona;
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
    
    @NotNull(message = "Datos del aperturista nulos")
    private DatosPersona datosPersona;
    
    @NotNull(message = "Aperturas no insertadas")
    private List<Apertura> aperturas;
}
