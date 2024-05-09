package dam.pepehc.saecio_climbing_api.service.service_interface;

import dam.pepehc.saecio_climbing_api.dto.IniciarSesionDto;
import dam.pepehc.saecio_climbing_api.dto.RegistrarseDto;
import dam.pepehc.saecio_climbing_api.enums.MensajeControlUsuarios;
import org.springframework.http.ResponseEntity;

public interface AuthService {
    public String autentificarUsuario(final IniciarSesionDto iniciarSesionDto);
    public MensajeControlUsuarios registrarUsuario(final RegistrarseDto registrarseDto);
}
