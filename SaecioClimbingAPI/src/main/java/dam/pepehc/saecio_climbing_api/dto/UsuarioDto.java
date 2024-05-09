package dam.pepehc.saecio_climbing_api.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dam.pepehc.saecio_climbing_api.entity.Ascension;
import dam.pepehc.saecio_climbing_api.entity.DatosPersona;
import dam.pepehc.saecio_climbing_api.entity.Rol;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDto {
    
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
    
    @NotNull(message = "Asccensiones nulas")
    private List<Ascension> ascensiones;
    
    @NotNull(message = "Roles no insertados")
    private List<Rol> roles;
}
