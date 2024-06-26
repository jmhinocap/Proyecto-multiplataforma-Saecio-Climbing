package dam.pepehc.saecio_climbing_api.command.ascension_command;

import dam.pepehc.saecio_climbing_api.dto.AscensionDto;
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
 * El tipo Nueva ascension command.
 */
@Slf4j
@Component
@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
@RequiredArgsConstructor
public class NuevaAscensionCommand {
    
    @Autowired
    private AscensionService ascensionService;
    
    private final AscensionDto ascensionDto;
    
    private boolean canExecute() {
        return Objects.nonNull(ascensionDto);
    }
    
    private AscensionResource doExecute() {
        log.info("[NuevaAscensionCommand]-[doExecute]-[ascensionDto: {}]-[Start]", ascensionDto);
        return ascensionService.nuevaAscension(ascensionDto);
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
