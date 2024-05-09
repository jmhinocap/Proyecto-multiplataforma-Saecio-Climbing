package dam.pepehc.saecio_climbing_api.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dam.pepehc.saecio_climbing_api.entity.Aperturista;
import dam.pepehc.saecio_climbing_api.entity.Ascension;
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
    
    @NotNull(message = "ID sector no introducido")
    private Long idSector;
    
    @NotBlank(message = "Nombre en blanco")
    private String nombre;
    
    @NotBlank(message = "Grados en blanco")
    private String grado;
    
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

    @NotNull(message = "Aperturistas no insertados")
    private List<Aperturista> aperturistas;
    
    @NotNull(message = "Ascensiones no insertadas")
    private List<Ascension> ascensiones;
}
