package dam.pepehc.SaecioClimbingAPI.assembler;

import dam.pepehc.SaecioClimbingAPI.dto.UsuarioDto;
import dam.pepehc.SaecioClimbingAPI.entity.Usuario;
import dam.pepehc.SaecioClimbingAPI.resource.UsuarioResource;
import org.springframework.stereotype.Component;

@Component
public class UsuarioAssembler {
    
    public Usuario usuarioDtoAUsuario(final UsuarioDto usuarioDto) {
        return Usuario.builder().build();
    }
    
    public UsuarioResource usuarioAUsuarioResource(final Usuario usuario) {
        return UsuarioResource.builder().build();
    }
    
    public Usuario usuarioModificadoAUsuario() {
        return Usuario.builder().build();
    }
}
