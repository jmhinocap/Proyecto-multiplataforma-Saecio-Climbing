package dam.pepehc.saecio_climbing_api.command.via_command;

import dam.pepehc.saecio_climbing_api.resource.ViaResource;
import dam.pepehc.saecio_climbing_api.service.service_interface.ViaService;
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
public class LeerUltimas5ViasCommand {
    
    @Autowired
    private ViaService viaService;
    
    private boolean canExecute() {
        return true;
    }
    
    private List<ViaResource> doExecute() {
        log.info("[LeerUltimas5ViasCommand]-[doExecute]-[Start]");
        return viaService.leerUltimas5Vias();
    }
    
    public List<ViaResource> execute() {
        if (canExecute())
            return doExecute();
        else
            throw new RuntimeException();
    }
}
