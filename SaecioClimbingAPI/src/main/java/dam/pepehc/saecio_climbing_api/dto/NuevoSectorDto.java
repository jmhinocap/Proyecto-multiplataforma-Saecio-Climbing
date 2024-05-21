package dam.pepehc.saecio_climbing_api.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.util.List;

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

    private File croquis;
    private String foto;
}
