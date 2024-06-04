package dam.pepehc.saecio_climbing_api.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * El tipo Nuevo usuario dto.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NuevoUsuarioDto {
    
    @JsonIgnore
    private Long idUsuario;
    
    @NotNull(message = "Datos de usuario no insertados")
    private Long idDatosPersona;

    @NotBlank(message = "Correo electrónico vacío")
    private String correoElectronico;
    
    @NotBlank(message = "Nombre de usuario vacío")
    private String nombreUsuario;

    @NotBlank(message = "Contraseña vacía")
    private String contrasena;
}
