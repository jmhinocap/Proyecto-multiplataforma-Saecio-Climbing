package dam.pepehc.saecio_climbing_api.command.sector_command;

import dam.pepehc.saecio_climbing_api.resource.SectorResource;
import dam.pepehc.saecio_climbing_api.service.service_interface.SectorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Slf4j
@Component
@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
@RequiredArgsConstructor
public class LeerSectoresPorIdZonaCommand {
    
    @Autowired
    private SectorService sectorService;
    
    private final Long idZona;
    
    private boolean canExecute() {
        return Objects.nonNull(idZona);
    }
    
    private List<SectorResource> doExecute() {
        log.info("[LeerSectoresPorIdZonaCommand]-[doExecute]-[idZona: {}]-[Start]", idZona);
        return sectorService.leerSectoresPorIdZona(idZona);
    }
    
    public List<SectorResource> execute() {
        if (canExecute())
            return doExecute();
        else
            throw new RuntimeException();
    }
}
