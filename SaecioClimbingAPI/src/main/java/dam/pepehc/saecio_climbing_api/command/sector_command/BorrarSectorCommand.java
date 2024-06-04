package dam.pepehc.saecio_climbing_api.command.sector_command;

import dam.pepehc.saecio_climbing_api.resource.SectorResource;
import dam.pepehc.saecio_climbing_api.service.service_interface.SectorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * El tipo Borrar sector command.
 */
@Slf4j
@Component
@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
@RequiredArgsConstructor
public class BorrarSectorCommand {
    
    @Autowired
    private SectorService sectorService;
    
    private final Long idSector;
    
    private boolean canExecute() {
        return Objects.nonNull(idSector);
    }
    
    private String doExecute() {
        log.info("[BorrarSectorCommand]-[doExecute]-[idSector: {}]-[Start]", idSector);
        return sectorService.borrarSector(idSector);
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
