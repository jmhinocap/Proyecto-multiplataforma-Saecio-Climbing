package dam.pepehc.saecio_climbing_api.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dam.pepehc.saecio_climbing_api.enums.TipoDeEscalada;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * El tipo Nueva via dto.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NuevaViaDto {
    
    @JsonIgnore
    private Long idVia;
    
    @NotNull(message = "ID de sector no insertado")
    private Long idSector;
    
    @NotBlank(message = "Número de croquis en blanco")
    private String numeroDeCroquis;

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

    @NotBlank(message = "Foto en blanco")
    private String foto;
    
    @NotNull(message = "Tipos de escalada no insertados")
    private TipoDeEscalada tipoDeEscalada;
}
