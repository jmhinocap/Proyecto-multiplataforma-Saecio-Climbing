package dam.pepehc.saecio_climbing_api.command.ascension_command;

import dam.pepehc.saecio_climbing_api.resource.AscensionResource;
import dam.pepehc.saecio_climbing_api.service.service_interface.AscensionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * El tipo Leer ascension command.
 */
@Slf4j
@Component
@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
@RequiredArgsConstructor
public class LeerAscensionCommand {
    
    @Autowired
    private AscensionService ascensionService;
    
    private final Long idAscension;
    
    private boolean canExecute() {
        return Objects.nonNull(idAscension);
    }
    
    private AscensionResource doExecute() {
        log.info("[LeerAscensionCommand]-[doExecute]-[idAscension: {}]-[Start]", idAscension);
        return ascensionService.leerAscension(idAscension);
    }

    /**
     * Execute ascension resource.
     *
     * @return el ascension resource
     */
    public AscensionResource execute() {
        if (canExecute())
            return doExecute();
        else
            throw new RuntimeException();
    }
}
