package dam.pepehc.saecio_climbing_api.command.aperturista_command;

import dam.pepehc.saecio_climbing_api.service.service_interface.AperturistaService;
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
public class BorrarAperturistaCommand {
    
    @Autowired
    private AperturistaService aperturistaService;
    
    private final Long idAperturista;
    
    private boolean canExecute() {
        return Objects.nonNull(idAperturista);
    }
    
    private String doExecute() {
        log.info("[BorrarAperturistaCommand]-[doExecute]-[idAperturista: {}]-[Start]", idAperturista);
        return aperturistaService.borrarAperturista(idAperturista);
    }
    
    public String execute() {
        if (canExecute())
            return doExecute();
        else
            throw new RuntimeException();
    }
}
