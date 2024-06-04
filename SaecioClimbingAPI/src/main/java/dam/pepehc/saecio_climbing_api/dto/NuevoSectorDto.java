package dam.pepehc.saecio_climbing_api.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dam.pepehc.saecio_climbing_api.enums.TipoDeEscalada;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * El tipo Nuevo sector dto.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NuevoSectorDto {

    @JsonIgnore
    private Long idSector;
    
    @NotNull(message = "ID zona no introducido")
    private Long idZona;

    @NotBlank(message = "Nombre vacío")
    private String nombre;

    @NotNull(message = "Coordenadas no introducidas")
    private String coordenadas;

    @NotBlank(message = "Croquis en blanco")
    private String croquis;
    
    @NotBlank(message = "Croquis en blanco")
    private String foto;
    
    @NotNull(message = "Tipos de escalada en blanco")
    private List<TipoDeEscalada> tiposDeEscalada;
}
