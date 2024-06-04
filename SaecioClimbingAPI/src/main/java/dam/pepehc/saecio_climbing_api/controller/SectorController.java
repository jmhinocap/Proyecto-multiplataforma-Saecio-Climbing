package dam.pepehc.saecio_climbing_api.controller;

import dam.pepehc.saecio_climbing_api.command.sector_command.*;
import dam.pepehc.saecio_climbing_api.command.zona_command.LeerIdZonaPorIdSectorCommand;
import dam.pepehc.saecio_climbing_api.dto.NuevoSectorDto;
import dam.pepehc.saecio_climbing_api.dto.SectorDto;
import dam.pepehc.saecio_climbing_api.resource.SectorResource;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * El tipo Sector controller.
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/api/sector")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SectorController {
    
    @Autowired
    private BeanFactory beanFactory;

    /**
     * Nuevo sector.
     *
     * @param nuevoSectorDto el sector que se añade a la base de datos
     * @return respuesta positiva de la cabecera HTTP
     */
    @PostMapping("/nuevo-sector")
    public ResponseEntity<SectorResource> nuevoSector(@Valid @RequestBody final NuevoSectorDto nuevoSectorDto) {
        log.info("[SectorController]-[nuevoSector]-[nuevoSectorDto: {}]-[Start]", nuevoSectorDto);
        NuevoSectorCommand nuevoSectorCommand = beanFactory.getBean(NuevoSectorCommand.class, nuevoSectorDto);
        SectorResource sectorResource = nuevoSectorCommand.execute();
        log.info("[SectorController]-[nuevoSector]-[sectorResource: {}]-[End]", sectorResource);
        
        return ResponseEntity.ok(sectorResource);
    }

    /**
     * Leer sector.
     *
     * @param idSector el id sector
     * @return respuesta positiva de la cabecera HTTP
     */
    @GetMapping("/leer-sector/{idSector}")
    public ResponseEntity<SectorResource> leerSector(@PathVariable("idSector") final Long idSector) {
        log.info("[SectorController]-[leerSector]-[idSector: {}]-[Start]", idSector);
        LeerSectorCommand leerSectorCommand = beanFactory.getBean(LeerSectorCommand.class, idSector);
        SectorResource sectorResource = leerSectorCommand.execute();
        log.info("[SectorController]-[leerSector]-[sectorResource: {}]-[End]", sectorResource);
        
        return ResponseEntity.ok(sectorResource);
    }

    /**
     * Modificar sector.
     *
     * @param sectorDto el sector modificado
     * @param idSector  el id sector
     * @return respuesta positiva de la cabecera HTTP
     */
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

    /**
     * Borrar sector.
     *
     * @param idSector el id sector
     * @return respuesta positiva de la cabecera HTTP
     */
    @DeleteMapping("/borrar-sector/{idSector}")
    public ResponseEntity<String> borrarSector(@PathVariable("idSector") final Long idSector) {
        log.info("[SectorController]-[borrarSector]-[idSector: {}]-[Start]", idSector);
        BorrarSectorCommand borrarSectorCommand = beanFactory.getBean(BorrarSectorCommand.class, idSector);
        String mensaje = borrarSectorCommand.execute();
        log.info("[SectorController]-[borrarSector]-[mensaje: {}]-[End]", mensaje);
        
        return ResponseEntity.ok(mensaje);
    }

    /**
     * Leer sectores por id zona.
     *
     * @param idZona el id zona
     * @return respuesta positiva de la cabecera HTTP
     */
    @GetMapping("/leer-sectores-por-id-zona/{idZona}")
    public ResponseEntity<List<SectorResource>> leerSectoresPorIdZona(@PathVariable("idZona") final Long idZona) {
        log.info("[SectorController]-[leerSectoresPorIdZona]-[idZona: {}]-[Start]", idZona);
        LeerSectoresPorIdZonaCommand leerSectoresPorIdZonaCommand = 
                beanFactory.getBean(LeerSectoresPorIdZonaCommand.class, idZona);
        List<SectorResource> sectoresResource = leerSectoresPorIdZonaCommand.execute();
        log.info("[ViaController]-[leerSectoresPorIdZona]-[sectoresResource: {}]-[End]", sectoresResource);
        
        return ResponseEntity.ok(sectoresResource);
    }

    /**
     * Leer id zona por id sector.
     *
     * @param idSector el id sector
     * @return respuesta positiva de la cabecera HTTP
     */
    @GetMapping("/leer-id-zona-por-id-sector/{idSector}")
    public ResponseEntity<Long> leerIdZonaPorIdSector(@PathVariable("idSector") final Long idSector) {
        log.info("[SectorController]-[leerIdZonaPorIdSector]-[idSector: {}]-[Start]", idSector);
        LeerIdZonaPorIdSectorCommand leerIdZonaPorIdSectorCommand = 
                beanFactory.getBean(LeerIdZonaPorIdSectorCommand.class, idSector);
        Long idZona = leerIdZonaPorIdSectorCommand.execute();
        log.info("[SectorController]-[leerIdZonaPorIdSector]-[idZona: {}]-[End]", idZona);
        
        return ResponseEntity.ok(idZona);
    }
}
