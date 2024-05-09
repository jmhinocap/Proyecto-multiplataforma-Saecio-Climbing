package dam.pepehc.saecio_climbing_api.command.ascension_command;

import dam.pepehc.saecio_climbing_api.resource.AscensionResource;
import dam.pepehc.saecio_climbing_api.service.service_interface.AscensionService;
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
public class BorrarAscensionCommand {
    
    @Autowired
    private AscensionService ascensionService;
    
    private final Long idAscension;
    
    private boolean canExecute() {
        return Objects.nonNull(idAscension);
    }
    
    private String doExecute() {
        log.info("[BorrarAscensionCommand]-[doExecute]-[idAscension: {}]-[Start]", idAscension);
        return ascensionService.borrarAscension(idAscension);
    }
    
    public String execute() {
        if (canExecute())
            return doExecute();
        else
            throw new RuntimeException();
    }
}
