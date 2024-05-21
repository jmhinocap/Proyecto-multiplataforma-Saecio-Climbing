package dam.pepehc.saecio_climbing_api.controller;

import dam.pepehc.saecio_climbing_api.command.zona_command.*;
import dam.pepehc.saecio_climbing_api.dto.NuevaZonaDto;
import dam.pepehc.saecio_climbing_api.dto.ZonaDto;
import dam.pepehc.saecio_climbing_api.resource.ZonaResource;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Validated
@RestController
@RequestMapping("/api/zona")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ZonaController {
    
    @Autowired
    private BeanFactory beanFactory;
    
    @PostMapping("/nueva-zona")
    public ResponseEntity<ZonaResource> nuevaZona(@Valid @RequestBody final NuevaZonaDto nuevaZonaDto) {
        log.info("[ZonaController]-[nuevaZona]-[nuevaZonaDto: {}]-[Start]", nuevaZonaDto);
        NuevaZonaCommand nuevaZonaCommand = beanFactory.getBean(NuevaZonaCommand.class, nuevaZonaDto); // Añadir LocalDateTime.now()
        ZonaResource zonaResource = nuevaZonaCommand.execute();
        log.info("[ZonaController]-[nuevaZona]-[zonaResource: {}]-[End]", zonaResource);
        
        return ResponseEntity.ok(zonaResource);
    }
    
    @GetMapping("/leer-zona/{idZona}")
    public ResponseEntity<ZonaResource> leerZona(@PathVariable("idZona") final Long idZona) {
        log.info("[ZonaController]-[leerZona]-[idZona: {}]-[Start]", idZona);
        LeerZonaCommand leerZonaCommand = beanFactory.getBean(LeerZonaCommand.class, idZona);
        ZonaResource zonaResource = leerZonaCommand.execute();
        log.info("[ZonaController]-[leerZona]-[zonaResource: {}]-[End]", zonaResource);
        
        return ResponseEntity.ok(zonaResource);
    }
    
    @PutMapping("/modificar-zona/{idZona}")
    public ResponseEntity<ZonaResource> modificarZona(@Valid @RequestBody final ZonaDto zonaDto, 
                                                      @PathVariable("idZona") final Long idZona) {
        log.info("[ZonaController]-[modificarZona]-[zonaDto: {}, idZona: {}]-[Start]", zonaDto, idZona);
        ModificarZonaCommand modificarZonaCommand = beanFactory.getBean(ModificarZonaCommand.class, zonaDto, idZona);
        ZonaResource zonaResource = modificarZonaCommand.execute();
        log.info("[ZonaController]-[modificarZona]-[zonaResource: {}]-[End]", zonaResource);
        
        return ResponseEntity.ok(zonaResource);
    }
    
    @DeleteMapping("/borrar-zona/{idZona}")
    public ResponseEntity<String> borrarZona(@PathVariable("idZona") final Long idZona) {
        log.info("[ZonaController]-[borrarZona]-[idZona: {}]-[Start]", idZona);
        BorrarZonaCommand borrarZonaCommand = beanFactory.getBean(BorrarZonaCommand.class, idZona);
        String mensaje = borrarZonaCommand.execute();
        log.info("[ZonaController]-[borrarZona]-[mensaje: {}]-[End]", mensaje);
        
        return ResponseEntity.ok(mensaje);
    }
    
    @GetMapping("/leer-zonas-por-id-sierra/{idSierra}")
    public ResponseEntity<List<ZonaResource>> leerZonasPorIdSierra(@PathVariable("idSierra") final Long idSierra) {
        log.info("[ZonaController]-[leerZonasPorIdSierra]-[idSierra: {}]-[Start]", idSierra);
        LeerZonasPorIdSierraCommand leerZonasPorIdSierraCommand = 
                beanFactory.getBean(LeerZonasPorIdSierraCommand.class, idSierra);
        List<ZonaResource> zonasResource = leerZonasPorIdSierraCommand.execute();
        log.info("[ZonaController]-[leerZonasPorIdSierra]-[zonasResource: {}]-[End]", zonasResource);
        
        return ResponseEntity.ok(zonasResource);
    }
    
    @GetMapping("/leer-nombre-zona/{idZona}")
    public ResponseEntity<String> leerNombreZona(@PathVariable("idZona") final Long idZona) {
        log.info("[ZonaController]-[leerNombreZona]-[idZona: {}]-[Start]", idZona);
        LeerNombreZonaCommand leerNombreZonaCommand = beanFactory.getBean(LeerNombreZonaCommand.class, idZona);
        String nombreZona = leerNombreZonaCommand.execute();
        log.info("[ZonaController]-[leerNombreZona]-[nombreZona: {}]-[End]", nombreZona);
        
        return ResponseEntity.ok(nombreZona);
    }
}
