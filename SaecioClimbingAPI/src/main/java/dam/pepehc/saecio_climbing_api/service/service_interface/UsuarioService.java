package dam.pepehc.saecio_climbing_api.service.service_interface;

import dam.pepehc.saecio_climbing_api.dto.NuevoUsuarioDto;
import dam.pepehc.saecio_climbing_api.dto.UsuarioDto;
import dam.pepehc.saecio_climbing_api.resource.UsuarioResource;

public interface UsuarioService {
    public UsuarioResource nuevoUsuario(final NuevoUsuarioDto nuevoUsuarioDto);
    public UsuarioResource leerUsuario(final Long idUsuario);
    public UsuarioResource modificarUsuario(final UsuarioDto usuarioDto, final Long idUsuario);
    public String borrarUsuario(final Long idUsuario);
}
