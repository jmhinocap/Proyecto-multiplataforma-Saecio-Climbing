package dam.pepehc.saecio_climbing_api.command.zona_command;

import dam.pepehc.saecio_climbing_api.resource.ZonaResource;
import dam.pepehc.saecio_climbing_api.service.service_interface.ZonaService;
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
public class LeerZonasPorIdSierraCommand {
    
    @Autowired
    private ZonaService zonaService;
    
    private final Long idSierra;
    
    private boolean canExecute() {
        return Objects.nonNull(idSierra);
    }
    
    private List<ZonaResource> doExecute() {
        log.info("[LeerZonasPorIdSierraCommand]-[doExecute]-[idSierra: {}]-[Start]", idSierra);
        return zonaService.leerZonasPorIdSierra(idSierra);
    }
    
    public List<ZonaResource> execute() {
        if (canExecute())
            return doExecute();
        else
            throw new RuntimeException();
    }
}
