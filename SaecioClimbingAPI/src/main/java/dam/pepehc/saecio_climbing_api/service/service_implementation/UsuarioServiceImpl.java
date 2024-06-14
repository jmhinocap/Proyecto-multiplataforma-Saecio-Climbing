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

import java.util.Date;
import java.util.Optional;

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
            guardarUsuarioRegistrado(usuario);
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
    public UsuarioResource leerUsuarioPorNombreOCorreo(final String usuarioOCorreo) {
        log.info("[UsuarioService]-[leerUsuarioPorNombreOCorreo]-[usuarioOCorreo: {}]-[Start]", usuarioOCorreo);
        Usuario usuario = usuarioRepository.findByNombreUsuarioOrCorreoElectronico(usuarioOCorreo, usuarioOCorreo)
                .orElseThrow(RuntimeException::new);
        log.info("[UsuarioService]-[leerUsuarioPorNombreOCorreo]-[usuarioResource: {}]-[End]",
                usuarioAssembler.usuarioAUsuarioResource(usuario));
        
        return usuarioAssembler.usuarioAUsuarioResource(usuario);
    }

    @Override
    public UsuarioResource modificarUsuario(final UsuarioDto usuarioDto, final Long idUsuario) {
        log.info("[UsuarioService]-[modificarUsuario]-[usuarioDto: {}, idUsuario: {}]-[Start]", usuarioDto, idUsuario);
        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException());
        Usuario usuarioModificado = usuarioAssembler.usuarioModificadoAUsuario(usuarioDto, usuario);
        usuarioRepository.save(usuarioModificado);
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
        log.info("[UsuarioService]-[conseguirTokenVerificacion]-[tokenVerificacion: {}]-[Start]", tokenVerificacion);
        return tokenRepository.findByToken(tokenVerificacion);
    }
    
    @Override
    public void crearTokenVerificacion(final Usuario usuario, final String token) {
        log.info("[UsuarioService]-[crearTokenVerificacion]-[usuario: {}, token: {}]-[Start]", usuario, token);
        Optional<Usuario> registrado = usuarioRepository.findByNombreUsuarioOrCorreoElectronico(usuario.getNombreUsuario(),
                usuario.getCorreoElectronico());
        TokenVerificacion tokenVerificacion = TokenVerificacion.builder()
                .token(token)
                .usuario(registrado.get())
                .build();
        tokenVerificacion.setCaducidad();
        tokenRepository.save(tokenVerificacion);
        log.info("[UsuarioService]-[crearTokenVerificacion]-[tokenVerificacion: {}]-[End]", tokenVerificacion);
    }
}
