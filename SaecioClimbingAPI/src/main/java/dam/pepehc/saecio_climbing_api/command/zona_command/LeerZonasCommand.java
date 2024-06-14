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

@Slf4j
@Component
@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
@RequiredArgsConstructor
public class LeerZonasCommand {
    
    @Autowired
    private ZonaService zonaService;
    
    private boolean canExecute() {
        return true;
    }
    
    private List<ZonaResource> doExecute() {
        log.info("[LeerZonas]-[doExecute]-[Start]");
        return zonaService.leerZonas();
    }
    
    public List<ZonaResource> execute() {
        if (canExecute())
            return doExecute();
        else
            throw new RuntimeException();
    }
}
