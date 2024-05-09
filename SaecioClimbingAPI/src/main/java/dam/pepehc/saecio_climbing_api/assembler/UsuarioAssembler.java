package dam.pepehc.saecio_climbing_api.assembler;

import dam.pepehc.saecio_climbing_api.dto.NuevoUsuarioDto;
import dam.pepehc.saecio_climbing_api.dto.RegistrarseDto;
import dam.pepehc.saecio_climbing_api.dto.UsuarioDto;
import dam.pepehc.saecio_climbing_api.entity.Rol;
import dam.pepehc.saecio_climbing_api.entity.Usuario;
import dam.pepehc.saecio_climbing_api.resource.UsuarioResource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class UsuarioAssembler {
    
    public Usuario registrarseDtoAUsuario(final RegistrarseDto registrarseDto, final Long idDatosPersona,
                                          final Rol rol) {
        ArrayList<Rol> roles = new ArrayList<>();
        roles.add(rol);
        return Usuario.builder()
                .idUsuario(idDatosPersona)
                .idDatosPersona(0L)
                .correoElectronico(registrarseDto.getCorreoElectronico() == null ? "" 
                        : registrarseDto.getCorreoElectronico())
                .nombreUsuario(registrarseDto.getUsuario() == null ? "" : registrarseDto.getUsuario())
                .contrasena(registrarseDto.getContrasena() == null ? "" : registrarseDto.getContrasena())
                .ascensiones(new ArrayList<>())
                .roles(roles)
                .build();
    }
    
    public Usuario nuevoUsuarioDtoAUsuario(final NuevoUsuarioDto nuevoUsuarioDto) {
        return Usuario.builder()
                .idUsuario(nuevoUsuarioDto.getIdUsuario() == null ? 0L : nuevoUsuarioDto.getIdUsuario())
                .idDatosPersona(nuevoUsuarioDto.getIdDatosPersona() == null ? 0L : nuevoUsuarioDto.getIdDatosPersona())
                .correoElectronico(nuevoUsuarioDto.getCorreoElectronico() == null ? ""
                        : nuevoUsuarioDto.getCorreoElectronico())
                .nombreUsuario(nuevoUsuarioDto.getNombreUsuario() == null ? "" : nuevoUsuarioDto.getNombreUsuario())
                .contrasena(nuevoUsuarioDto.getContrasena() == null ? "" : nuevoUsuarioDto.getContrasena())
                .ascensiones(new ArrayList<>())
                .roles(new ArrayList<>())
                .build();
    }
    
    public UsuarioResource usuarioAUsuarioResource(final Usuario usuario) {
        return UsuarioResource.builder()
                .idUsuario(usuario.getIdUsuario() == null ? 0L : usuario.getIdUsuario())
                .idDatosPersona(usuario.getIdDatosPersona() == null ? 0L : usuario.getIdDatosPersona())
                .correoElectronico(usuario.getCorreoElectronico() == null ? "" : usuario.getCorreoElectronico())
                .nombreUsuario(usuario.getNombreUsuario() == null ? "" : usuario.getNombreUsuario())
                .contrasena(usuario.getContrasena() == null ? "" : usuario.getContrasena())
                .ascensiones(usuario.getAscensiones() == null ? new ArrayList<>() : usuario.getAscensiones())
                .roles(usuario.getRoles() == null ? new ArrayList<>() : usuario.getRoles())
                .build();
    }
    
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
                .ascensiones(usuarioDto.getAscensiones() == null ? usuario.getAscensiones() 
                        : usuarioDto.getAscensiones())
                .roles(usuarioDto.getRoles() == null ? usuario.getRoles() : usuarioDto.getRoles())
                .build();
    }
}
