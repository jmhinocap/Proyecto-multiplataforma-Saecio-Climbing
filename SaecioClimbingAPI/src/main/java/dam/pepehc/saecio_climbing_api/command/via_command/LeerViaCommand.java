package dam.pepehc.saecio_climbing_api.command.via_command;

import dam.pepehc.saecio_climbing_api.resource.ViaResource;
import dam.pepehc.saecio_climbing_api.service.service_interface.UsuarioService;
import dam.pepehc.saecio_climbing_api.service.service_interface.ViaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * El tipo Leer via command.
 */
@Slf4j
@Component
@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
@RequiredArgsConstructor
public class LeerViaCommand {
    
    @Autowired
    private ViaService viaService;
    
    private final Long idVia;
    
    private boolean canExecute() {
        return Objects.nonNull(idVia);
    }
    
    private ViaResource doExecute() {
        log.info("[LeerViaCommand]-[doExecute]-[idVia: {}]-[Start]", idVia);
        return viaService.leerVia(idVia);
    }

    /**
     * Execute via resource.
     *
     * @return el via resource
     */
    public ViaResource execute() {
        if (canExecute())
            return doExecute();
        else
            throw new RuntimeException();
    }
}
