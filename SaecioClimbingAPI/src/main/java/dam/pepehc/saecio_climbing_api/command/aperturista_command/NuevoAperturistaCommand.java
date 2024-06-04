package dam.pepehc.saecio_climbing_api.command.aperturista_command;

import dam.pepehc.saecio_climbing_api.dto.NuevoAperturistaDto;
import dam.pepehc.saecio_climbing_api.resource.AperturistaResource;
import dam.pepehc.saecio_climbing_api.service.service_interface.AperturistaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * El tipo Nuevo aperturista command.
 */
@Slf4j
@Component
@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
@RequiredArgsConstructor
public class NuevoAperturistaCommand {
    
    @Autowired
    private AperturistaService aperturistaService;
    
    private final NuevoAperturistaDto nuevoAperturistaDto;

    private boolean canExecute() {
        return Objects.nonNull(nuevoAperturistaDto);
    }
    private AperturistaResource doExecute() {
        log.info("[NuevoAperturistaCommand]-[doExecute]-[nuevoAperturistaDtoL: {}]-[Start]", nuevoAperturistaDto);
        return aperturistaService.nuevoAperturista(nuevoAperturistaDto);
    }

    /**
     * Execute aperturista resource.
     *
     * @return aperturista resource
     */
    public AperturistaResource execute() {
        if (canExecute())
            return doExecute();
        else
            throw new RuntimeException();
    }
}
