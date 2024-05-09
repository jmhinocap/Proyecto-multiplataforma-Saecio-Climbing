package dam.pepehc.saecio_climbing_api.controller;

import dam.pepehc.saecio_climbing_api.command.via_command.*;
import dam.pepehc.saecio_climbing_api.dto.NuevaViaDto;
import dam.pepehc.saecio_climbing_api.dto.ViaDto;
import dam.pepehc.saecio_climbing_api.resource.ViaResource;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Validated
@RestController
@RequestMapping("/api/via")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ViaController {
    
    @Autowired
    private BeanFactory beanFactory;
    
    @PostMapping("/nueva-via")
    public ResponseEntity<ViaResource> nuevaVia(@Valid @RequestBody final NuevaViaDto nuevaViaDto) {
        log.info("[ViaController]-[nuevaVia]-[nuevaViaDto: {}]-[Start]", nuevaViaDto);
        NuevaViaCommand nuevaViaCommand = beanFactory.getBean(NuevaViaCommand.class, nuevaViaDto);
        ViaResource viaResource = nuevaViaCommand.execute();
        log.info("[ViaController]-[nuevaVia]-[viaResource: {}]-[End]", viaResource);
        
        return ResponseEntity.ok(viaResource);
    }
    
    @GetMapping("/leer-via/{idVia}")
    public ResponseEntity<ViaResource> leerVia(@PathVariable("idVia") final Long idVia) {
        log.info("[ViaController]-[leerVia]-[idVia: {}]-[Start]", idVia);
        LeerViaCommand leerViaCommand = beanFactory.getBean(LeerViaCommand.class, idVia);
        ViaResource viaResource = leerViaCommand.execute();
        log.info("[ViaController]-[leerVia]-[viaResource: {}]-[End]", viaResource);
        
        return ResponseEntity.ok(viaResource);
    }
    
    @PutMapping("/modificar-via/{idVia}")
    public ResponseEntity<ViaResource> modificarVia(@Valid @RequestBody final ViaDto viaDto,
                                                     @PathVariable("idVia") final Long idVia) {
        log.info("[ViaController]-[modificarVia]-[viaDto: {}, idVia: {}]-[Start]", viaDto, idVia);
        ModificarViaCommand modificarViaCommand = beanFactory.getBean(ModificarViaCommand.class, viaDto, idVia);
        ViaResource viaResource = modificarViaCommand.execute();
        log.info("[ViaController]-[modificarVia]-[viaResource: {}]-[End]", viaResource);
        
        return ResponseEntity.ok(viaResource);
    }
    
    @DeleteMapping("/borrar-via/{idVia}")
    public ResponseEntity<String> borrarVia(@PathVariable("idVia") final Long idVia) {
        log.info("[ViaController]-[borrarVia]-[idVia: {}]-[Start]", idVia);
        BorrarViaCommand borrarViaCommand = beanFactory.getBean(BorrarViaCommand.class, idVia);
        String mensaje = borrarViaCommand.execute();
        log.info("[ViaController]-[borrarVia]-[mensaje: {}]-[End]", mensaje);
        
        return ResponseEntity.ok(mensaje);
    }
    
    @GetMapping("/leer-ultimas-cinco-vias")
    public ResponseEntity<List<ViaResource>> leerUltimas5Vias() {
        log.info("[ViaController]-[leerUltimas5Vias]-[Start]");
        LeerUltimas5ViasCommand leerUltimas5ViasCommand = beanFactory.getBean(LeerUltimas5ViasCommand.class);
        List<ViaResource> viasResource = leerUltimas5ViasCommand.execute();
        log.info("[ViaController]-[leerUltimas5Vias]-[viasResource: {}]-[End]", viasResource);
        
        return ResponseEntity.ok(viasResource);
    }
    
    @GetMapping("/leer-vias-por-id-sector/{idSector}")
    public ResponseEntity<List<ViaResource>> leerViasPorIdSector(@PathVariable("idSector") final Long idSector) {
        log.info("[ViaController]-[leerViasPorIdSector]-[idSector: {}]-[Start]", idSector);
        LeerViasPorIdSector leerViasPorIdSector = beanFactory.getBean(LeerViasPorIdSector.class, idSector);
        List<ViaResource> viasResource = leerViasPorIdSector.execute();
        log.info("[ViaController]-[leerViasPorIdSector]-[viasResource: {}]-[End]", viasResource);
        
        return ResponseEntity.ok(viasResource);
    }
}
