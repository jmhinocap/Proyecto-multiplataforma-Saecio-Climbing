package dam.pepehc.saecio_climbing_api.service.service_implementation;

import dam.pepehc.saecio_climbing_api.assembler.UsuarioAssembler;
import dam.pepehc.saecio_climbing_api.dto.NuevoUsuarioDto;
import dam.pepehc.saecio_climbing_api.dto.UsuarioDto;
import dam.pepehc.saecio_climbing_api.entity.TokenVerificacion;
import dam.pepehc.saecio_climbing_api.entity.Usuario;
import dam.pepehc.saecio_climbing_api.repository.TokenRepository;
import dam.pepehc.saecio_climbing_api.repository.UsuarioRepository;
import dam.pepehc.saecio_climbing_api.resource.UsuarioResource;
import dam.pepehc.saecio_climbing_api.service.service_interface.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * El tipo Usuario service.
 */
@Slf4j
@Service
public class UsuarioServiceImpl implements UsuarioService {
    
    @Autowired
    private UsuarioAssembler usuarioAssembler;
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private TokenRepository tokenRepository;
    
    @Override
    public UsuarioResource nuevoUsuario(final NuevoUsuarioDto nuevoUsuarioDto) {
        log.info("[UsuarioService]-[nuevoUsuario]-[nuevoUsuarioDto: {}]-[Start]", nuevoUsuarioDto);
        
        if (Boolean.TRUE.equals(usuarioRepository.existsByCorreoElectronico(nuevoUsuarioDto.getCorreoElectronico()))) {
            throw new RuntimeException("El correo o el usuario ya existe");
        } else {
            Usuario usuario = usuarioAssembler.nuevoUsuarioDtoAUsuario(nuevoUsuarioDto);
            usuarioRepository.save(usuario);
            log.info("[UsuarioService]-[nuevoUsuario]-[usuarioResource: {}]-[End]",
                    usuarioAssembler.usuarioAUsuarioResource(usuario));

            return usuarioAssembler.usuarioAUsuarioResource(usuario);
        }
    }
    
    @Override
    public void guardarUsuarioRegistrado(final Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public UsuarioResource leerUsuario(final Long idUsuario) {
        log.info("[UsuarioService]-[leerUsuario]-[idUsuario: {}]-[Start]", idUsuario);
        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException());
        log.info("[UsuarioService]-[leerUsuario]-[usuarioResource: {}]-[End]", usuarioAssembler.usuarioAUsuarioResource(usuario));
        
        return usuarioAssembler.usuarioAUsuarioResource(usuario);
    }

    @Override
    public UsuarioResource modificarUsuario(final UsuarioDto usuarioDto, final Long idUsuario) {
        log.info("[UsuarioService]-[modificarUsuario]-[usuarioDto: {}, idUsuario: {}]-[Start]", usuarioDto, idUsuario);
        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException());
        Usuario usuarioModificado = usuarioAssembler.usuarioModificadoAUsuario(usuarioDto, usuario);
        log.info("[UsuarioService]-[modificarUsuario]-[usuarioResource: {}]-[End]", 
                usuarioAssembler.usuarioAUsuarioResource(usuarioModificado));
        
        return usuarioAssembler.usuarioAUsuarioResource(usuarioModificado);
    }

    @Override
    public String borrarUsuario(final Long idUsuario) {
        log.info("[UsuarioService]-[eliminarUsuario]-[idUsuario: {}]-[Start]", idUsuario);
        usuarioRepository.deleteById(idUsuario);
        String mensaje = "Usuario " + idUsuario + " eliminado correctamente de la base de datos";
        log.info("[UsuarioService]-[eliminarUsuario]-[mensaje: {}]-[End]", mensaje);
        
        return mensaje;
    }
    
    @Override
    public TokenVerificacion conseguirTokenVerificacion(final String tokenVerificacion) {
        return tokenRepository.findByToken(tokenVerificacion);
    }
    
    @Override
    public void crearTokenVerificacion(final Usuario usuario, final String token) {
        TokenVerificacion tokenVerificacion = TokenVerificacion.builder().token(token).usuario(usuario).build();
        tokenRepository.save(tokenVerificacion);
    }
}
