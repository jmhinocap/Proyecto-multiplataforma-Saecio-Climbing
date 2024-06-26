package dam.pepehc.saecio_climbing_api.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dam.pepehc.saecio_climbing_api.entity.Zona;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * El tipo Sierra dto.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SierraDto {
    
    @JsonIgnore
    private Long idSierra;
    
    @NotBlank(message = "Nombre en blanco")
    private String nombre;
    
    @NotNull(message = "Coordenadas no introducidas")
    private String coordenadas;
    
    @NotNull(message = "Foto nula")
    private String foto;
    
    @JsonIgnore
    private List<Zona> zonas;
}
