package dam.pepehc.saecio_climbing_api.service.service_implementation;

import dam.pepehc.saecio_climbing_api.assembler.DatosPersonaAssembler;
import dam.pepehc.saecio_climbing_api.assembler.UsuarioAssembler;
import dam.pepehc.saecio_climbing_api.dto.IniciarSesionDto;
import dam.pepehc.saecio_climbing_api.dto.RegistrarseDto;
import dam.pepehc.saecio_climbing_api.entity.DatosPersona;
import dam.pepehc.saecio_climbing_api.entity.Rol;
import dam.pepehc.saecio_climbing_api.entity.Usuario;
import dam.pepehc.saecio_climbing_api.enums.MensajeControlUsuarios;
import dam.pepehc.saecio_climbing_api.repository.RolRepository;
import dam.pepehc.saecio_climbing_api.repository.UsuarioRepository;
import dam.pepehc.saecio_climbing_api.service.service_interface.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static dam.pepehc.saecio_climbing_api.enums.MensajeControlUsuarios.*;
import static dam.pepehc.saecio_climbing_api.enums.Roles.ROL_USUARIO;

/**
 * El tipo Auth service.
 */
@Slf4j
@Service
public class AuthServiceImpl implements AuthService {
    
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private RolRepository rolRepository;
    
    @Autowired
    private DatosPersonaAssembler datosPersonaAssembler;
    
    @Autowired
    private UsuarioAssembler usuarioAssembler;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String autentificarUsuario(final IniciarSesionDto iniciarSesionDto) {
        log.info("[AuthService]-[autentificarUsuario]-[iniciarSesionDto: {}]-[Start]", iniciarSesionDto);
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(iniciarSesionDto.getUsuarioOCorreo(),
                        iniciarSesionDto.getContrasena()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String mensaje = "El usuario inició sesión correctamente";
        log.info("[AuthService]-[autentificarUsuario]-[mensaje: {}]-[End]", mensaje);
        
        return mensaje;
    }

    @Override
    public MensajeControlUsuarios registrarUsuario(final RegistrarseDto registrarseDto) {
        log.info("[AuthService]-[registrarUsuario]-[registrarseDto: {}]-[Start]", registrarseDto);
        if (Boolean.TRUE.equals(usuarioRepository.existsByNombreUsuario(registrarseDto.getUsuario()))) {
            log.info("[AuthService]-[registrarUsuario]-[mensaje: {}]-[End]", USUARIO_EN_USO.mensaje);
            return USUARIO_EN_USO;
        }
        
        if (Boolean.TRUE.equals(usuarioRepository.existsByCorreoElectronico(registrarseDto.getCorreoElectronico()))) {
            log.info("[AuthService]-[registrarUsuario]-[mensaje: {}]-[End]", CORREO_EN_USO.mensaje);
            return CORREO_EN_USO;
        }
        
        DatosPersona datosPersona = datosPersonaAssembler.registrarseDtoADatosPersona(registrarseDto);
        Rol rol = rolRepository.findByNombre(ROL_USUARIO).get();
        Usuario usuario = usuarioAssembler.registrarseDtoAUsuario(registrarseDto, datosPersona.getIdDatosPersona(),
                rol);
        usuarioRepository.save(usuario);
        log.info("[AuthService]-[registrarUsuario]-[mensaje: {}]-[End]", USUARIO_REGISTRADO.mensaje);
        
        return USUARIO_REGISTRADO;
    }
}
