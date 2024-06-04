package dam.pepehc.saecio_climbing_api.command.zona_command;

import dam.pepehc.saecio_climbing_api.dto.ZonaDto;
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
 * El tipo Modificar zona command.
 */
@Slf4j
@Component
@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
@RequiredArgsConstructor
public class ModificarZonaCommand {
    
    @Autowired
    private ZonaService zonaService;
    
    private final ZonaDto zonaDto;
    private final Long idZona;
    
    private boolean canExecute() {
        return Objects.nonNull(zonaDto) && Objects.nonNull(idZona);
    }
    
    private ZonaResource doExecute() {
        log.info("[ModificarZonaCommand]-[doExecute]-[zonaDto: {}, idZona: {}]-[Start]", zonaDto, idZona);
        return zonaService.modificarZona(zonaDto, idZona);
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
