package dam.pepehc.saecio_climbing_api.service.service_implementation;

import dam.pepehc.saecio_climbing_api.assembler.SectorAssembler;
import dam.pepehc.saecio_climbing_api.dto.NuevoSectorDto;
import dam.pepehc.saecio_climbing_api.dto.SectorDto;
import dam.pepehc.saecio_climbing_api.entity.Sector;
import dam.pepehc.saecio_climbing_api.entity.Via;
import dam.pepehc.saecio_climbing_api.repository.SectorRepository;
import dam.pepehc.saecio_climbing_api.resource.SectorResource;
import dam.pepehc.saecio_climbing_api.service.service_interface.SectorService;
import dam.pepehc.saecio_climbing_api.service.service_interface.ZonaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * El tipo Sector service.
 */
@Slf4j
@Service
public class SectorServiceImpl implements SectorService {
    
    @Autowired
    private ZonaService zonaService;
    
    @Autowired
    private SectorAssembler sectorAssembler;
    
    @Autowired
    private SectorRepository sectorRepository;
    
    @Override
    public SectorResource nuevoSector(final NuevoSectorDto nuevoSectorDto) {
        log.info("[SectorService]-[nuevoSector]-[nuevoSectorDto: {}]-[Start]", nuevoSectorDto);
        Sector sector = sectorAssembler.sectorDtoASector(nuevoSectorDto);
        zonaService.anadirNuevoSector(sector);
        log.info("[SectorService]-[nuevoSector]-[sectorResource: {}]-[End]",
                sectorAssembler.sectorASectorResource(sector));
        
        return sectorAssembler.sectorASectorResource(sector);
    }

    @Override
    public SectorResource leerSector(final Long idSector) {
        log.info("[SectorService]-[leerSector]-[idSector: {}]-[Start]", idSector);
        Sector sector = sectorRepository.findById(idSector)
                .orElseThrow(() -> new RuntimeException());
        log.info("[SectorService]-[leerSector]-[sectorResource: {}]-[End]",
                sectorAssembler.sectorASectorResource(sector));
        
        return sectorAssembler.sectorASectorResource(sector);
    }

    @Override
    public SectorResource modificarSector(final SectorDto sectorDto, final Long idSector) {
        log.info("[SectorService]-[modificarSector]-[sectorDto: {}, idSector: {}]-[Start]", sectorDto, idSector);
        Sector sector = sectorRepository.findById(idSector)
                .orElseThrow(() -> new RuntimeException());
        Sector sectorModificado = sectorAssembler.sectorModificadoASector(sectorDto, sector);
        log.info("[SectorService]-[modificarSector]-[sectorResource: {}]-[End]", 
                sectorAssembler.sectorASectorResource(sectorModificado));
        
        return sectorAssembler.sectorASectorResource(sectorModificado);
    }

    @Override
    public String borrarSector(final Long idSector) {
        log.info("[SectorService]-[eliminarSector]-[idSector: {}]-[Start]", idSector);
        Sector sector = sectorRepository.findById(idSector).orElseThrow(RuntimeException::new);
        String mensaje = zonaService.eliminarSector(sector);
        log.info("[SectorService]-[eliminarSector]-[mensaje: {}]-[End]", mensaje);
        
        return mensaje;
    }

    @Override
    public void anadirNuevaVia(final Via via) {
        log.info("[SectorService]-[anadirNuevaVia]-[via: {}]-[Start]", via);
        Sector sector = sectorRepository.findById(via.getIdSector()).orElseThrow(RuntimeException::new);
        sector.getVias().add(via);
        sectorRepository.save(sector);
        log.info("[SectorService]-[anadirNuevaVia]-[End]");
    }
    
    @Override
    public String eliminarVia(final Via via) {
        log.info("[SectorService]-[borrarVia]-[via: {}]-[Start]", via);
        Sector sector = sectorRepository.findById(via.getIdSector()).orElseThrow(RuntimeException::new);
        sector.getVias().remove(via);
        sectorRepository.save(sector);
        String mensaje = "Via " + via.getIdVia() + " eliminada correctamente";
        log.info("[SectorService]-[borrarVia]-[mensaje: {}]-[End]", mensaje);
        
        return mensaje;
    }
    
    @Override
    public List<SectorResource> leerSectoresPorIdZona(final Long idZona) {
        log.info("[SectorService]-[encontrarZonasPorIdZona]-[idZona: {}]-[Start]", idZona);
        List<Sector> sectores = sectorRepository.encontrarSectoresPorIdZona(idZona);
        List<SectorResource> sectoresResource = new ArrayList<>();
        
        for (Sector s : sectores) {
            sectoresResource.add(sectorAssembler.sectorASectorResource(s));
        }
        
        log.info("[SectorService]-[encontrarZonasPorIdZona]-[sectoresResource: {}]-[End]", sectoresResource);
        
        return sectoresResource;
    }
    
    @Override
    public Long leerIdZonaPorIdSector(final Long idSector) {
        log.info("[SectorService]-[leerIdZonaPorIdSector]-[idSector: {}]-[Start]", idSector);
        Long idZona = sectorRepository.encontrarIdZonaPorIdSector(idSector);
        log.info("[SectorService]-[leerIdZonaPorIdSector]-[idZona: {}]-[End]", idZona);
        
        return idZona;
    }
}
