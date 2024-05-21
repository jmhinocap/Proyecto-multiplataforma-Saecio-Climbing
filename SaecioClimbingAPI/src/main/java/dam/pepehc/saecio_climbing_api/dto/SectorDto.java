package dam.pepehc.saecio_climbing_api.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dam.pepehc.saecio_climbing_api.entity.Via;
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
    
    @NotNull(message = "ID zona no introducido")
    private Long idZona;

    @NotBlank(message = "Nombre vacío")
    private String nombre;
    
    @NotNull(message = "Coordenadas no introducidas")
    private String coordenadas;
    
    @NotNull(message = "Croquis nulo")
    private File croquis;
    
    @NotNull(message = "Foto nula")
    private String foto;
    
    @NotNull(message = "Vías nulas")
    private List<Via> vias;
}