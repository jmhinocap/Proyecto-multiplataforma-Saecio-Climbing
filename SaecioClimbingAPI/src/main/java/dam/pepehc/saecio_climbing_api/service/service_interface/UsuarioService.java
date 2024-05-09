package dam.pepehc.SaecioClimbingAPI.service.service_interface;

import dam.pepehc.SaecioClimbingAPI.dto.NuevoUsuarioDto;
import dam.pepehc.SaecioClimbingAPI.dto.UsuarioDto;
import dam.pepehc.SaecioClimbingAPI.resource.UsuarioResource;

public interface UsuarioService {
    public UsuarioResource nuevoUsuario(final NuevoUsuarioDto nuevoUsuarioDto);
    public UsuarioResource leerUsuario(final Long idUsuario);
    public UsuarioResource modificarUsuario(final UsuarioDto usuarioDto, final Long idUsuario);
    public String eliminarUsuario(final Long idUsuario);
}
