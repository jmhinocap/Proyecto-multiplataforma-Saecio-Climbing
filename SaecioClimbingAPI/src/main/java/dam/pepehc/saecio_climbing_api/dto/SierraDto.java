package dam.pepehc.SaecioClimbingAPI.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dam.pepehc.SaecioClimbingAPI.entity.Zona;
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
public class SierraDto {
    
    @JsonIgnore
    private Long idSierra;
    
    @NotBlank(message = "Nombre en blanco")
    private String nombre;
    
    @NotNull(message = "Foto nula")
    private File foto;
    
    @NotNull(message = "Zonas nulas")
    private List<Zona> zonas;
}
