package dam.pepehc.saecio_climbing_api.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NuevaSierraDto {

    @JsonIgnore
    private Long idSierra;

    @NotBlank(message = "Nombre en blanco")
    private String nombre;

    @NotNull(message = "Foto nula")
    private File foto;
}
