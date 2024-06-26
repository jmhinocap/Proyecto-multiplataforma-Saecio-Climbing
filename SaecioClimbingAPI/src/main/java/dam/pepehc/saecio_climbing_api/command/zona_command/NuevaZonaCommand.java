package dam.pepehc.saecio_climbing_api.command.zona_command;

import dam.pepehc.saecio_climbing_api.dto.NuevaZonaDto;
import dam.pepehc.saecio_climbing_api.resource.ZonaResource;
import dam.pepehc.saecio_climbing_api.service.service_interface.ZonaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Objects;

/**
 * El tipo Nueva zona command.
 */
@Slf4j
@Component
@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
@RequiredArgsConstructor
public class NuevaZonaCommand {
    
    @Autowired
    private ZonaService zonaService;
    
    private final NuevaZonaDto nuevaZonaDto;
    
    private boolean canExecute() {
        return Objects.nonNull(nuevaZonaDto);
    }
    
    private ZonaResource doExecute() {
        log.info("[NuevaZonaCommand]-[doExecute]-[nuevaZonaDto: {}]-[Start]", nuevaZonaDto);
//        nuevaZonaDto.setNow(now);
        return zonaService.nuevaZona(nuevaZonaDto);
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
