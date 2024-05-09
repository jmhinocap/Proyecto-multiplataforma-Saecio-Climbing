package dam.pepehc.SaecioClimbingAPI.service.service_implementation;

import dam.pepehc.SaecioClimbingAPI.dto.NuevoUsuarioDto;
import dam.pepehc.SaecioClimbingAPI.dto.UsuarioDto;
import dam.pepehc.SaecioClimbingAPI.resource.UsuarioResource;
import dam.pepehc.SaecioClimbingAPI.service.service_interface.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Override
    public UsuarioResource nuevoUsuario(NuevoUsuarioDto nuevoUsuarioDto) {
        return null;
    }

    @Override
    public UsuarioResource leerUsuario(Long idUsuario) {
        return null;
    }

    @Override
    public UsuarioResource modificarUsuario(UsuarioDto usuarioDto, Long idUsuario) {
        return null;
    }

    @Override
    public String eliminarUsuario(Long idUsuario) {
        return "";
    }
}
