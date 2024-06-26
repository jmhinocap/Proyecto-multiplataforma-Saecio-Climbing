package dam.pepehc.saecio_climbing_api.command.sierra_command;

import dam.pepehc.saecio_climbing_api.dto.SierraDto;
import dam.pepehc.saecio_climbing_api.resource.SierraResource;
import dam.pepehc.saecio_climbing_api.service.service_interface.SierraService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * El tipo Modificar sierra command.
 */
@Slf4j
@Component
@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
@RequiredArgsConstructor
public class ModificarSierraCommand {
    
    @Autowired
    private SierraService sierraService;
    
    private final SierraDto sierraDto;
    private final Long idSierra;
    
    private boolean canExecute() {
        return Objects.nonNull(sierraDto) && Objects.nonNull(idSierra);
    }
    
    private SierraResource doExecute() {
        log.info("[ModificarSierraCommand]-[doExecute]-[sierraDto: {}, idSierra: {}]-[Start]", sierraDto, idSierra);
        return sierraService.modificarSierra(sierraDto, idSierra);
    }

    /**
     * Execute sierra resource.
     *
     * @return el sierra resource
     */
    public SierraResource execute() {
        if (canExecute())
            return doExecute();
        else
            throw new RuntimeException();
    }
}
