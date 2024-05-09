package dam.pepehc.SaecioClimbingAPI.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dam.pepehc.SaecioClimbingAPI.entity.Sector;
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
public class ZonaDto {
    
    @JsonIgnore
    private Long idZona;
    
    @NotBlank(message = "Nombre en blanco")
    private String nombre;
    
    @NotBlank(message = "Coordenadas en blanco")
    private String coordenadas;
    
    @NotNull(message = "Foto nula")
    private File foto;
    
    @NotNull(message = "Sectores nulos")
    private List<Sector> sectores;
}
