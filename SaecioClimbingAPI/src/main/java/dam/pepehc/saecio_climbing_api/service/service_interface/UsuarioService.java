package dam.pepehc.saecio_climbing_api.service.service_interface;

import dam.pepehc.saecio_climbing_api.dto.NuevoUsuarioDto;
import dam.pepehc.saecio_climbing_api.dto.UsuarioDto;
import dam.pepehc.saecio_climbing_api.entity.TokenVerificacion;
import dam.pepehc.saecio_climbing_api.entity.Usuario;
import dam.pepehc.saecio_climbing_api.resource.UsuarioResource;

/**
 * La interfaz Usuario service.
 */
public interface UsuarioService {
    /**
     * Nuevo usuario usuario resource.
     *
     * @param nuevoUsuarioDto el nuevo usuario dto
     * @return el usuario resource
     */
    public UsuarioResource nuevoUsuario(final NuevoUsuarioDto nuevoUsuarioDto);

    /**
     * Guardar usuario registrado.
     *
     * @param usuario el usuario
     */
    public void guardarUsuarioRegistrado(final Usuario usuario);

    /**
     * Leer usuario usuario resource.
     *
     * @param idUsuario el id usuario
     * @return el usuario resource
     */
    public UsuarioResource leerUsuario(final Long idUsuario);

    /**
     * Leer usuario por nombre o correo usuario resource.
     * 
     * @param usuarioOCorreo el usuario o correo
     * @return el usuario resource
     */
    public UsuarioResource leerUsuarioPorNombreOCorreo(final String usuarioOCorreo);

    /**
     * Modificar usuario usuario resource.
     *
     * @param usuarioDto el usuario dto
     * @param idUsuario  el id usuario
     * @return el usuario resource
     */
    public UsuarioResource modificarUsuario(final UsuarioDto usuarioDto, final Long idUsuario);

    /**
     * Borrar usuario string.
     *
     * @param idUsuario el id usuario
     * @return el string
     */
    public String borrarUsuario(final Long idUsuario);

    /**
     * Crear token verificacion.
     *
     * @param usuario el usuario
     * @param token   el token
     */
    public void crearTokenVerificacion(final Usuario usuario, final String token);

    /**
     * Conseguir token verificacion token verificacion.
     *
     * @param tokenVerificacion el token verificacion
     * @return el token verificacion
     */
    public TokenVerificacion conseguirTokenVerificacion(final String tokenVerificacion);
}
