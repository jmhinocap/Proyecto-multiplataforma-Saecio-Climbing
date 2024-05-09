package dam.pepehc.saecio_climbing_api.command.sector_command;

import dam.pepehc.saecio_climbing_api.dto.NuevoSectorDto;
import dam.pepehc.saecio_climbing_api.resource.SectorResource;
import dam.pepehc.saecio_climbing_api.service.service_interface.SectorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Slf4j
@Component
@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
@RequiredArgsConstructor
public class NuevoSectorCommand {
    
    @Autowired
    private SectorService sectorService;
    
    private final NuevoSectorDto nuevoSectorDto;
    
    private boolean canExecute() {
        return Objects.nonNull(nuevoSectorDto);
    }
    
    private SectorResource doExecute() {
        log.info("[NuevoSectorCommand]-[doExecute]-[sectorDto: {}]-[Start]", nuevoSectorDto);
        return sectorService.nuevoSector(nuevoSectorDto);
    }
    
    public SectorResource execute() {
        if (canExecute())
            return doExecute();
        else
            throw new RuntimeException();
    }
}
