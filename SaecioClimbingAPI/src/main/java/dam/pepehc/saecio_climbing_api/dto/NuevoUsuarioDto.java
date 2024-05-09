package dam.pepehc.SaecioClimbingAPI.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dam.pepehc.SaecioClimbingAPI.entity.DatosPersona;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NuevoUsuarioDto {
    
    @JsonIgnore
    private Long idUsuario;

    @NotNull(message = "Datos de usuario nulos")
    private DatosPersona datosPersona;

    @NotBlank(message = "Correo electrónico vacío")
    private String correoElectronico;

    @NotBlank(message = "Contraseña vacía")
    private String contrasena;
}
