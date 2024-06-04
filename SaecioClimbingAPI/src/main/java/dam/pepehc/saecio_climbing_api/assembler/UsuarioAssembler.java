package dam.pepehc.saecio_climbing_api.assembler;

import dam.pepehc.saecio_climbing_api.dto.NuevoUsuarioDto;
import dam.pepehc.saecio_climbing_api.dto.RegistrarseDto;
import dam.pepehc.saecio_climbing_api.dto.UsuarioDto;
import dam.pepehc.saecio_climbing_api.entity.Rol;
import dam.pepehc.saecio_climbing_api.entity.Usuario;
import dam.pepehc.saecio_climbing_api.resource.UsuarioResource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * El tipo Usuario assembler.
 */
@Component
public class UsuarioAssembler {

    /**
     * Registrarse dto a usuario usuario.
     *
     * @param registrarseDto 
     * @param idDatosPersona 
     * @param rol            
     * @return 
     */
    public Usuario registrarseDtoAUsuario(final RegistrarseDto registrarseDto, final Long idDatosPersona,
                                          final Rol rol) {
        ArrayList<Rol> roles = new ArrayList<>();
        roles.add(rol);
        return Usuario.builder()
                .idUsuario(idDatosPersona)
                .idDatosPersona(0L)
                .correoElectronico(registrarseDto.getCorreoElectronico() == null ? StringUtils.EMPTY
                        : registrarseDto.getCorreoElectronico())
                .nombreUsuario(registrarseDto.getUsuario() == null ? StringUtils.EMPTY : registrarseDto.getUsuario())
                .contrasena(registrarseDto.getContrasena() == null ? StringUtils.EMPTY : registrarseDto.getContrasena())
                .ascensiones(new ArrayList<>())
                .roles(roles)
                .build();
    }

    /**
     * Registrarse dto a nuevo usuario dto nuevo usuario dto.
     *
     * @param registrarseDto 
     * @param idDatosPersona 
     * @return 
     */
    public NuevoUsuarioDto registrarseDtoANuevoUsuarioDto(final RegistrarseDto registrarseDto,
                                                          final Long idDatosPersona) {
        return NuevoUsuarioDto.builder()
                .idUsuario(idDatosPersona)
                .idDatosPersona(0L)
                .correoElectronico(registrarseDto.getCorreoElectronico() == null ? StringUtils.EMPTY
                        : registrarseDto.getCorreoElectronico())
                .nombreUsuario(registrarseDto.getUsuario() == null ? StringUtils.EMPTY : registrarseDto.getUsuario())
                .contrasena(registrarseDto.getContrasena() == null ? StringUtils.EMPTY : registrarseDto.getContrasena())
                .build();
    }

    /**
     * Nuevo usuario dto a usuario usuario.
     *
     * @param nuevoUsuarioDto 
     * @return 
     */
    public Usuario nuevoUsuarioDtoAUsuario(final NuevoUsuarioDto nuevoUsuarioDto) {
        return Usuario.builder()
                .idUsuario(nuevoUsuarioDto.getIdUsuario() == null ? 0L : nuevoUsuarioDto.getIdUsuario())
                .idDatosPersona(nuevoUsuarioDto.getIdDatosPersona() == null ? 0L : nuevoUsuarioDto.getIdDatosPersona())
                .correoElectronico(nuevoUsuarioDto.getCorreoElectronico() == null ? StringUtils.EMPTY
                        : nuevoUsuarioDto.getCorreoElectronico())
                .nombreUsuario(nuevoUsuarioDto.getNombreUsuario() == null ? StringUtils.EMPTY : nuevoUsuarioDto.getNombreUsuario())
                .contrasena(nuevoUsuarioDto.getContrasena() == null ? StringUtils.EMPTY
                        : nuevoUsuarioDto.getContrasena())
                .ascensiones(new ArrayList<>())
                .roles(new ArrayList<>())
                .build();
    }

    /**
     * Usuario a usuario resource usuario resource.
     *
     * @param usuario 
     * @return 
     */
    public UsuarioResource usuarioAUsuarioResource(final Usuario usuario) {
        return UsuarioResource.builder()
                .idUsuario(usuario.getIdUsuario() == null ? 0L : usuario.getIdUsuario())
                .idDatosPersona(usuario.getIdDatosPersona() == null ? 0L : usuario.getIdDatosPersona())
                .correoElectronico(usuario.getCorreoElectronico() == null ? StringUtils.EMPTY : usuario.getCorreoElectronico())
                .nombreUsuario(usuario.getNombreUsuario() == null ? StringUtils.EMPTY : usuario.getNombreUsuario())
                .contrasena(usuario.getContrasena() == null ? StringUtils.EMPTY : usuario.getContrasena())
                .ascensiones(usuario.getAscensiones() == null ? new ArrayList<>() : usuario.getAscensiones())
                .roles(usuario.getRoles() == null ? new ArrayList<>() : usuario.getRoles())
                .build();
    }

    /**
     * Usuario resource a usuario usuario.
     *
     * @param usuarioResource 
     * @return 
     */
    public Usuario usuarioResourceAUsuario(final UsuarioResource usuarioResource) {
        return Usuario.builder()
                .idUsuario(usuarioResource.getIdUsuario() == null ? 0L : usuarioResource.getIdUsuario())
                .idDatosPersona(usuarioResource.getIdDatosPersona() == null ? 0L : usuarioResource.getIdDatosPersona())
                .correoElectronico(usuarioResource.getCorreoElectronico() == null ? StringUtils.EMPTY 
                        : usuarioResource.getCorreoElectronico())
                .nombreUsuario(usuarioResource.getNombreUsuario() == null ? StringUtils.EMPTY 
                        : usuarioResource.getNombreUsuario())
                .contrasena(usuarioResource.getContrasena() == null ? StringUtils.EMPTY 
                        : usuarioResource.getContrasena())
                .ascensiones(usuarioResource.getContrasena() == null ? new ArrayList<>() 
                        : usuarioResource.getAscensiones())
                .roles(usuarioResource.getRoles() == null ? new ArrayList<>() : usuarioResource.getRoles())
                .build();
    }

    /**
     * Usuario modificado a usuario usuario.
     *
     * @param usuarioDto 
     * @param usuario    
     * @return 
     */
    public Usuario usuarioModificadoAUsuario(final UsuarioDto usuarioDto, final Usuario usuario) {
        return Usuario.builder()
                .idUsuario(usuario.getIdUsuario())
                .idDatosPersona(usuarioDto.getIdDatosPersona() == null ? usuario.getIdDatosPersona() 
                        : usuarioDto.getIdDatosPersona())
                .correoElectronico(usuarioDto.getCorreoElectronico() == null ? usuario.getCorreoElectronico() :
                        usuarioDto.getCorreoElectronico())
                .nombreUsuario(usuarioDto.getNombreUsuario() == null ? usuario.getNombreUsuario() 
                        : usuarioDto.getNombreUsuario())
                .contrasena(usuarioDto.getContrasena() == null ? usuario.getContrasena() : usuarioDto.getContrasena())
                .ascensiones(usuario.getAscensiones())
                .roles(usuarioDto.getRoles() == null ? usuario.getRoles() : usuarioDto.getRoles())
                .build();
    }
}
