package dam.pepehc.saecio_climbing_api.command.ascension_command;

import dam.pepehc.saecio_climbing_api.resource.AscensionResource;
import dam.pepehc.saecio_climbing_api.service.service_interface.AscensionService;
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
public class LeerAscensionesPorIdUsuarioCommand {
    
    @Autowired
    private AscensionService ascensionService;
    
    private final Long idUsuario;
    
    private boolean canExecute() {
        return Objects.nonNull(idUsuario);
    }
    
    private List<AscensionResource> doExecute() {
        log.info("[LeerAscensionesPorIdUsuarioCommand]-[doExecute]-[idUsuario: {}]-[Start]", idUsuario);
        return ascensionService.leerAscensionesPorIdUsuario(idUsuario);
    }
    
    public List<AscensionResource> execute() {
        if (canExecute()) 
            return doExecute();
        else
            throw new RuntimeException();
    }
}
