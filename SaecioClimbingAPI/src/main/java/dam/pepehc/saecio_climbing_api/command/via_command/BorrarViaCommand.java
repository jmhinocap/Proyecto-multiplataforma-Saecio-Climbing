package dam.pepehc.saecio_climbing_api.command.via_command;

import dam.pepehc.saecio_climbing_api.resource.ViaResource;
import dam.pepehc.saecio_climbing_api.service.service_interface.ViaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * El tipo Borrar via command.
 */
@Slf4j
@Component
@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
@RequiredArgsConstructor
public class BorrarViaCommand {
    
    @Autowired
    private ViaService viaService;
    
    private final Long idVia;
    
    private boolean canExecute() {
        return Objects.nonNull(idVia);
    }
    
    private String doExecute() {
        log.info("[BorrarViaCommand]-[doExecute]-[idVia: {}]-[Start]", idVia);
        return viaService.borrarVia(idVia);
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
