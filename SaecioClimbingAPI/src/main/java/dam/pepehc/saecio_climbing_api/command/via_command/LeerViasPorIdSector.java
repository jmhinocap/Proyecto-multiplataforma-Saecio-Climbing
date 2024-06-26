package dam.pepehc.saecio_climbing_api.command.via_command;

import dam.pepehc.saecio_climbing_api.resource.ViaResource;
import dam.pepehc.saecio_climbing_api.service.service_interface.ViaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

/**
 * El tipo Leer vias por id sector.
 */
@Slf4j
@Component
@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
@RequiredArgsConstructor
public class LeerViasPorIdSector {
    
    @Autowired
    private ViaService viaService;
    
    private final Long idSector;
    
    private boolean canExecute() {
        return Objects.nonNull(idSector);
    }
    
    private List<ViaResource> doExecute() {
        log.info("[LeerViasPorIdSector]-[doExecute]-[idSector: {}]-[Start]", idSector);
        return viaService.leerViasPorIdSector(idSector);
    }

    /**
     * Execute list.
     *
     * @return el list
     */
    public List<ViaResource> execute() {
        if (canExecute())
            return doExecute();
        else
            throw new RuntimeException();
    }
}
