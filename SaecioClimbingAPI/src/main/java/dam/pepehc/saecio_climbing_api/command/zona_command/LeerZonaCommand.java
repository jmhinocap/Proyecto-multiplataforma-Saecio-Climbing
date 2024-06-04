package dam.pepehc.saecio_climbing_api.command.zona_command;

import dam.pepehc.saecio_climbing_api.resource.ZonaResource;
import dam.pepehc.saecio_climbing_api.service.service_interface.ZonaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * El tipo Leer zona command.
 */
@Slf4j
@Component
@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
@RequiredArgsConstructor
public class LeerZonaCommand {
    
    @Autowired
    private ZonaService zonaService;
    
    private final Long idZona;
    
    private boolean canExecute() {
        return Objects.nonNull(idZona);
    }
    
    private ZonaResource doExecute() {
        log.info("[LeerZonaCommand]-[doExecute]-[idZona: {}]-[Start]", idZona);
        return zonaService.leerZona(idZona);
    }

    /**
     * Execute zona resource.
     *
     * @return el zona resource
     */
    public ZonaResource execute() {
        if (canExecute())
            return doExecute();
        else
            throw new RuntimeException();
    }
}
