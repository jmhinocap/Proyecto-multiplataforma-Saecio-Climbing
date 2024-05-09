package dam.pepehc.saecio_climbing_api.controller;

import dam.pepehc.saecio_climbing_api.command.ascension_command.BorrarAscensionCommand;
import dam.pepehc.saecio_climbing_api.command.ascension_command.LeerAscensionCommand;
import dam.pepehc.saecio_climbing_api.command.ascension_command.ModificarAscensionCommand;
import dam.pepehc.saecio_climbing_api.command.ascension_command.NuevaAscensionCommand;
import dam.pepehc.saecio_climbing_api.dto.AscensionDto;
import dam.pepehc.saecio_climbing_api.resource.AscensionResource;
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
@RequestMapping("/api/ascension")
public class AscensionController {
    
    @Autowired
    private BeanFactory beanFactory;
    
    @PostMapping("/nueva-ascension")
    public ResponseEntity<AscensionResource> nuevaAscension(@Valid @RequestBody final AscensionDto ascensionDto) {
        log.info("[AscensionController]-[nuevaAscension]-[ascensionDto: {}]-[Start]", ascensionDto);
        NuevaAscensionCommand nuevaAscensionCommand = beanFactory.getBean(NuevaAscensionCommand.class, ascensionDto);
        AscensionResource ascensionResource = nuevaAscensionCommand.execute();
        log.info("[AscensionController]-[nuevaAscension]-[ascensionResource: {}]-[End]", ascensionResource);
        
        return ResponseEntity.ok(ascensionResource);
    }
    
    @GetMapping("/leer-ascension/{idAscension}")
    public ResponseEntity<AscensionResource> leerAscension(@PathVariable("idAscension") final Long idAscension) {
        log.info("[AscensionController]-[leerAscension]-[idAscension: {}]-[Start]", idAscension);
        LeerAscensionCommand leerAscensionCommand = beanFactory.getBean(LeerAscensionCommand.class, idAscension);
        AscensionResource ascensionResource = leerAscensionCommand.execute();
        log.info("[AscensionController]-[leerAscension]-[ascensionResource: {}]-[End]", ascensionResource);
        
        return ResponseEntity.ok(ascensionResource);
    }
    
    @PutMapping("/modificar-ascension/{idAscension}")
    public ResponseEntity<AscensionResource> modificarAscension(@Valid @RequestBody final AscensionDto ascensionDto,
                                                                 @PathVariable("idAscension") final Long idAscension) {
        log.info("[AscensionController]-[modificarAscension]-[ascensionDto: {}, idAscension: {}]-[Start]", 
                ascensionDto, idAscension);
        ModificarAscensionCommand modificarAscensionCommand = beanFactory.getBean(ModificarAscensionCommand.class,
                ascensionDto, idAscension);
        AscensionResource ascensionResource = modificarAscensionCommand.execute();
        log.info("[AscensionController]-[modificarAscension]-[ascensionResource: {}]-[End]", ascensionResource);
        
        return ResponseEntity.ok(ascensionResource);
    }
    
    @DeleteMapping("/borrar-ascension/{idAscension}")
    public ResponseEntity<String> borrarAscension(@PathVariable("idAscension") final Long idAscension) {
        log.info("[AscensionController]-[borrarAscension]-[idAscension: {}]-[Start]", idAscension);
        BorrarAscensionCommand borrarAscensionCommand = beanFactory.getBean(BorrarAscensionCommand.class, idAscension);
        String mensaje = borrarAscensionCommand.execute();
        log.info("[AscensionController]-[borrarAscension]-[mensaje: {}]-[End]", mensaje);
        
        return ResponseEntity.ok(mensaje);
    }
}
