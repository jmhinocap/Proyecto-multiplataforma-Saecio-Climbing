package dam.pepehc.saecio_climbing_api.command.usuario_command;

import dam.pepehc.saecio_climbing_api.service.service_interface.SierraService;
import dam.pepehc.saecio_climbing_api.service.service_interface.UsuarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * El tipo Borrar usuario command.
 */
@Slf4j
@Component
@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
@RequiredArgsConstructor
public class BorrarUsuarioCommand {
    
    @Autowired
    private UsuarioService usuarioService;
    
    private final Long idUsuario;
    
    private boolean canExecute() {
        return Objects.nonNull(idUsuario);
    }
    
    private String doExecute() {
        log.info("[BorrarUsuarioCommand]-[doExecute]-[idUsuario: {}]-[Start]", idUsuario);
        return usuarioService.borrarUsuario(idUsuario);
    }

    /**
     * Execute string.
     *
     * @return el string
     */
    public String execute() {
        if (canExecute())
            return doExecute();
        else
            throw new RuntimeException();
    }
}
