package dam.pepehc.saecio_climbing_api.controller;

import dam.pepehc.saecio_climbing_api.command.sierra_command.BorrarSierraCommand;
import dam.pepehc.saecio_climbing_api.command.sierra_command.LeerSierraCommand;
import dam.pepehc.saecio_climbing_api.command.sierra_command.ModificarSierraCommand;
import dam.pepehc.saecio_climbing_api.command.sierra_command.NuevaSierraCommand;
import dam.pepehc.saecio_climbing_api.dto.NuevaSierraDto;
import dam.pepehc.saecio_climbing_api.dto.SierraDto;
import dam.pepehc.saecio_climbing_api.resource.SierraResource;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Validated
@RestController
@RequestMapping("/api/sierra")
public class SierraController {
    
    @Autowired
    private BeanFactory beanFactory;
    
    @PostMapping("/nueva-sierra")
    public ResponseEntity<SierraResource> nuevaSierra(@Valid @RequestBody final NuevaSierraDto nuevaSierraDto) {
        log.info("[SierraController]-[nuevaSierra]-[nuevaSierraDto: {}]-[Start]", nuevaSierraDto);
        NuevaSierraCommand nuevaSierraCommand = beanFactory.getBean(NuevaSierraCommand.class, nuevaSierraDto);
        SierraResource sierraResource = nuevaSierraCommand.execute();
        log.info("[SierraController]-[nuevaSierra]-[sierraResource: {}]-[End]", sierraResource);
        
        return ResponseEntity.ok(sierraResource);
    }
    
    @GetMapping("/leer-sierra/{idSierra}")
    public ResponseEntity<SierraResource> leerSierra(@PathVariable("idSierra") final Long idSierra) {
        log.info("[SierraController]-[leerSierra]-[idSierra: {}]-[Start]", idSierra);
        LeerSierraCommand leerSierraCommand = beanFactory.getBean(LeerSierraCommand.class, idSierra);
        SierraResource sierraResource = leerSierraCommand.execute();
        log.info("[SierraController]-[leerSierra]-[sierraResource: {}]-[End]", sierraResource);
        
        return ResponseEntity.ok(sierraResource);
    }
    
    @PutMapping("/modificar-sierra/{idSierra}")
    public ResponseEntity<SierraResource> modificarSierra(@Valid @RequestBody final SierraDto sierraDto,
                                                           @PathVariable("idSierra") final Long idSierra) {
        log.info("[SierraController]-[modificarSierra]-[sierraDto: {}, idSierra: {}]-[Start]", sierraDto, idSierra);
        ModificarSierraCommand modificarSierraCommand = beanFactory.getBean(ModificarSierraCommand.class, sierraDto,
                idSierra);
        SierraResource sierraResource = modificarSierraCommand.execute();
        log.info("[SierraController]-[modificarSierra]-[sierraResource: {}]-[End]", sierraResource);
        
        return ResponseEntity.ok(sierraResource);
    }
    
    @DeleteMapping("/borrar-sierra/{idSierra}")
    public ResponseEntity<String> borrarSierra(@PathVariable("idSierra") final Long idSierra) {
        log.info("[SierraController]-[borrarSierra]-[idSierra: {}]-[Start]", idSierra);
        BorrarSierraCommand borrarSierraCommand = beanFactory.getBean(BorrarSierraCommand.class, idSierra);
        String mensaje = borrarSierraCommand.execute();
        log.info("[SierraController]-[borrarSierra]-[mensaje: {}]-[End]", mensaje);
        
        return ResponseEntity.ok(mensaje);
    }
}
