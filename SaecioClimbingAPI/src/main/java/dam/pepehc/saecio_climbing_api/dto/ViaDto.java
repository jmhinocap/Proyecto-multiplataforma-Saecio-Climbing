package dam.pepehc.SaecioClimbingAPI.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dam.pepehc.SaecioClimbingAPI.entity.Apertura;
import dam.pepehc.SaecioClimbingAPI.entity.Ascension;
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
public class ViaDto {
    
    @JsonIgnore
    private Long idVia;
    
    @NotBlank(message = "Nombre en blanco")
    private String nombre;
    
    @NotBlank(message = "Grados en blanco")
    private String grados;
    
    @NotBlank(message = "Metros en blanco")
    private String metros;
    
    @NotBlank(message = "Número de chapas en blanco")
    private String numeroChapas;
    
    @NotBlank(message = "Fecha de apertura en blanco")
    private String fechaApertura;
    
    @NotBlank(message = "Fecha de última revisión en blanco")
    private String fechaUltimaRevision;
    
    @NotBlank(message = "Descripcion en blanco")
    private String descripcion;
    
    @NotNull(message = "Foto nula")
    private File foto;
    
    @NotNull(message = "Ascensiones nulas")
    private List<Ascension> ascensiones;
    
    @NotNull(message = "Aperturas nulas")
    private List<Apertura> aperturas;
}
