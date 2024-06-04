package dam.pepehc.saecio_climbing_api.command.sierra_command;

import dam.pepehc.saecio_climbing_api.resource.SierraResource;
import dam.pepehc.saecio_climbing_api.service.service_interface.SierraService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * El tipo Leer todas las sierras command.
 */
@Slf4j
@Component
@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
@RequiredArgsConstructor
public class LeerTodasLasSierrasCommand {
    
    @Autowired
    private SierraService sierraService;
    
    private boolean canExecute() {
        return true;
    }
    
    private List<SierraResource> doExecute() {
        log.info("[LeerTodasLasSierrasCommand]-[doExecute]-[Start]");
        return sierraService.leerTodasLasSierras();
    }

    /**
     * Execute list.
     *
     * @return el list
     */
    public List<SierraResource> execute() {
        if (canExecute())
            return doExecute();
        else
            throw new RuntimeException();
    }
}
