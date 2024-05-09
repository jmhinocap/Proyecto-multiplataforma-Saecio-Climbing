package dam.pepehc.saecio_climbing_api.command.sector_command;

import dam.pepehc.saecio_climbing_api.dto.SectorDto;
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
public class ModificarSectorCommand {
    
    @Autowired
    private SectorService sectorService;
    
    private final SectorDto sectorDto;
    private final Long idSector;
    
    private boolean canExecute() {
        return Objects.nonNull(sectorDto) && Objects.nonNull(idSector);
    }
    
    private SectorResource doExecute() {
        log.info("[ModificarSectorCommand]-[doExecute]-[sectorDto: {}, idSector: {}]-[Start]", sectorDto, idSector);
        return sectorService.modificarSector(sectorDto, idSector);
    }
    
    public SectorResource execute() {
        if (canExecute())
            return doExecute();
        else
            throw new RuntimeException();
    }
}
