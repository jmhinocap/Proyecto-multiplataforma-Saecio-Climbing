package dam.pepehc.saecio_climbing_api.command.auth_command;

import dam.pepehc.saecio_climbing_api.dto.IniciarSesionDto;
import dam.pepehc.saecio_climbing_api.service.service_interface.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * El tipo Autentificar usuario command.
 */
@Slf4j
@Component
@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
@RequiredArgsConstructor
public class AutentificarUsuarioCommand {
    
    @Autowired
    private AuthService authService;
    
    private final IniciarSesionDto iniciarSesionDto;
    
    private boolean canExecute() {
        return Objects.nonNull(iniciarSesionDto);
    }
    
    private String doExecute() {
        log.info("[AutentificarUsuarioCommand]-[doExecute]-[iniciarSesionDto: {}]-[Start]", iniciarSesionDto);
        return authService.autentificarUsuario(iniciarSesionDto);
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
