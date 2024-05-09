package dam.pepehc.saecio_climbing_api.controller;

import dam.pepehc.saecio_climbing_api.command.sector_command.*;
import dam.pepehc.saecio_climbing_api.dto.NuevoSectorDto;
import dam.pepehc.saecio_climbing_api.dto.SectorDto;
import dam.pepehc.saecio_climbing_api.resource.SectorResource;
import dam.pepehc.saecio_climbing_api.resource.ViaResource;
import dam.pepehc.saecio_climbing_api.resource.ZonaResource;
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
@RequestMapping("/api/sector")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SectorController {
    
    @Autowired
    private BeanFactory beanFactory;
    
    @PostMapping("/nuevo-sector")
    public ResponseEntity<SectorResource> nuevoSector(@Valid @RequestBody final NuevoSectorDto nuevoSectorDto) {
        log.info("[SectorController]-[nuevoSector]-[nuevoSectorDto: {}]-[Start]", nuevoSectorDto);
        NuevoSectorCommand nuevoSectorCommand = beanFactory.getBean(NuevoSectorCommand.class, nuevoSectorDto);
        SectorResource sectorResource = nuevoSectorCommand.execute();
        log.info("[SectorController]-[nuevoSector]-[sectorResource: {}]-[End]", sectorResource);
        
        return ResponseEntity.ok(sectorResource);
    }
    
    @GetMapping("/leer-sector/{idSector}")
    public ResponseEntity<SectorResource> leerSector(@PathVariable("idSector") final Long idSector) {
        log.info("[SectorController]-[leerSector]-[idSector: {}]-[Start]", idSector);
        LeerSectorCommand leerSectorCommand = beanFactory.getBean(LeerSectorCommand.class, idSector);
        SectorResource sectorResource = leerSectorCommand.execute();
        log.info("[SectorController]-[leerSector]-[sectorResource: {}]-[End]", sectorResource);
        
        return ResponseEntity.ok(sectorResource);
    }
    
    @PutMapping("/modificar-sector/{idSector}")
    public ResponseEntity<SectorResource> modificarSector(@Valid @RequestBody final SectorDto sectorDto,
                                                           @PathVariable("idSector") final Long idSector) {
        log.info("[SectorController]-[modificarSector]-[sectorDto: {}, idSector: {}]-[Start]", sectorDto, idSector);
        ModificarSectorCommand modificarSectorCommand = beanFactory.getBean(ModificarSectorCommand.class, sectorDto,
                idSector);
        SectorResource sectorResource = modificarSectorCommand.execute();
        log.info("[SectorController]-[modificarSector]-[sectorResource: {}]-[End]", sectorResource);
        
        return ResponseEntity.ok(sectorResource);
    }
    
    @DeleteMapping("/borrar-sector/{idSector}")
    public ResponseEntity<String> borrarSector(@PathVariable("idSector") final Long idSector) {
        log.info("[SectorController]-[borrarSector]-[idSector: {}]-[Start]", idSector);
        BorrarSectorCommand borrarSectorCommand = beanFactory.getBean(BorrarSectorCommand.class, idSector);
        String mensaje = borrarSectorCommand.execute();
        log.info("[SectorController]-[borrarSector]-[mensaje: {}]-[End]", mensaje);
        
        return ResponseEntity.ok(mensaje);
    }
    
    @GetMapping("/leer-sectores-por-id-zona/{idZona}")
    public ResponseEntity<List<SectorResource>> leerSectoresPorIdZona(@PathVariable("idZona") final Long idZona) {
        log.info("[SectorController]-[leerSectoresPorIdZona]-[idZona: {}]-[Start]", idZona);
        LeerSectoresPorIdZonaCommand leerSectoresPorIdZonaCommand = 
                beanFactory.getBean(LeerSectoresPorIdZonaCommand.class, idZona);
        List<SectorResource> sectoresResource = leerSectoresPorIdZonaCommand.execute();
        log.info("[ViaController]-[leerSectoresPorIdZona]-[sectoresResource: {}]-[End]", sectoresResource);
        
        return ResponseEntity.ok(sectoresResource);
    }
}
