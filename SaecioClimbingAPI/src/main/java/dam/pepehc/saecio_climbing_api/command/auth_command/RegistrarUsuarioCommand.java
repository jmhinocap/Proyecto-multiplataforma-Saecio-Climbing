package dam.pepehc.saecio_climbing_api.command.auth_command;

import dam.pepehc.saecio_climbing_api.dto.RegistrarseDto;
import dam.pepehc.saecio_climbing_api.enums.MensajeControlUsuarios;
import dam.pepehc.saecio_climbing_api.service.service_interface.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Slf4j
@Component
@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
@RequiredArgsConstructor
public class RegistrarUsuarioCommand {
    
    @Autowired
    private AuthService authService;
    
    private final RegistrarseDto registrarseDto;
    
    private boolean canExecute() {
        return Objects.nonNull(registrarseDto);
    }
    
    private MensajeControlUsuarios doExecute() {
        log.info("[RegistrarUsuarioCommand]-[doExecute]-[registrarseDto: {}]-[Start]", registrarseDto);
        return authService.registrarUsuario(registrarseDto);
    }
    
    public MensajeControlUsuarios execute() {
        if (canExecute())
            return doExecute();
        else
            throw new RuntimeException();
    }
}
