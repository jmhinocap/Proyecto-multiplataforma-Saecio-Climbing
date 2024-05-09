package dam.pepehc.SaecioClimbingAPI.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dam.pepehc.SaecioClimbingAPI.entity.Via;
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
public class SectorDto {

    @JsonIgnore
    private Long idSector;

    @NotBlank(message = "Nombre vacío")
    private String nombre;
    
    @NotBlank(message = "Coordenadas vacías")
    private String coordenadas;
    
    @NotNull(message = "Croquis nulo")
    private File croquis;
    
    @NotNull(message = "Foto nula")
    private File foto;
    
    @NotNull(message = "Vías nulas")
    private List<Via> vias;
}