package dam.pepehc.saecio_climbing_api.service.service_interface;

import dam.pepehc.saecio_climbing_api.dto.IniciarSesionDto;
import dam.pepehc.saecio_climbing_api.dto.RegistrarseDto;
import dam.pepehc.saecio_climbing_api.enums.MensajeControlUsuarios;

/**
 * La interfaz Auth service.
 */
public interface AuthService {
    /**
     * Autentificar usuario string.
     *
     * @param iniciarSesionDto el iniciar sesion dto
     * @return el string
     */
    public String autentificarUsuario(final IniciarSesionDto iniciarSesionDto);

    /**
     * Registrar usuario mensaje control usuarios.
     *
     * @param registrarseDto el registrarse dto
     * @return el mensaje control usuarios
     */
    public MensajeControlUsuarios registrarUsuario(final RegistrarseDto registrarseDto);
}
