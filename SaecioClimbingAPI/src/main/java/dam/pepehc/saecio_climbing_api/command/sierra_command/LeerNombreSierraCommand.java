package dam.pepehc.saecio_climbing_api.command.sierra_command;

import dam.pepehc.saecio_climbing_api.service.service_interface.SierraService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * El tipo Leer nombre sierra command.
 */
@Slf4j
@Component
@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
@RequiredArgsConstructor
public class LeerNombreSierraCommand {
    
    @Autowired
    private SierraService sierraService;
    
    private final Long idSierra;
    
    private boolean canExecute() {
        return Objects.nonNull(idSierra);
    }
    
    private String doExecute() {
        log.info("[LeerNombreSierraCommand]-[doExecute]-[idSierra: {}]-[Start]", idSierra);
        return sierraService.leerNombreSierra(idSierra);
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
