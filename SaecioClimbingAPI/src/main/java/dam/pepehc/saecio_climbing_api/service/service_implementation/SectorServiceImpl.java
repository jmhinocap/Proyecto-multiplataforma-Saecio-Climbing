package dam.pepehc.SaecioClimbingAPI.service.service_implementation;

import dam.pepehc.SaecioClimbingAPI.assembler.SectorAssembler;
import dam.pepehc.SaecioClimbingAPI.dto.SectorDto;
import dam.pepehc.SaecioClimbingAPI.entity.Sector;
import dam.pepehc.SaecioClimbingAPI.repository.SectorRepository;
import dam.pepehc.SaecioClimbingAPI.resource.SectorResource;
import dam.pepehc.SaecioClimbingAPI.service.service_interface.SectorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SectorServiceImpl implements SectorService {
    
    @Autowired
    private SectorAssembler sectorAssembler;
    
    @Autowired
    private SectorRepository sectorRepository;
    
    @Override
    public SectorResource nuevoSector(SectorDto sectorDto) {
        log.info("[SectorService]-[nuevoSector]-[sectorDto: {}]-[Start]", sectorDto);
        Sector sector = sectorAssembler.sectorDtoASector(sectorDto);
        sectorRepository.save(sector);
        log.info("[SectorService]-[nuevoSector]-[sectorResource: {}]-[End]",
                sectorAssembler.sectorASectorResource(sector));
        
        return sectorAssembler.sectorASectorResource(sector);
    }

    @Override
    public SectorResource leerSector(Long idSector) {
        log.info("[SectorService]-[leerSector]-[idSector: {}]-[Start]", idSector);
        Sector sector = sectorRepository.findById(idSector)
                .orElseThrow(() -> new RuntimeException());
        log.info("[SectorService]-[leerSector]-[sectorResource: {}]-[End]",
                sectorAssembler.sectorASectorResource(sector));
        
        return sectorAssembler.sectorASectorResource(sector);
    }

    @Override
    public SectorResource modificarSector(SectorDto sectorDto, Long idSector) {
        log.info("[SectorService]-[modificarSector]-[sectorDto: {}, idSector: {}]-[Start]", sectorDto, idSector);
        Sector sector = sectorRepository.findById(idSector)
                .orElseThrow(() -> new RuntimeException());
        Sector sectorModificado = sectorAssembler.sectorModificadoASector(sectorDto, sector);
        log.info("[SectorService]-[modificarSector]-[sectorResource: {}]-[End]", 
                sectorAssembler.sectorASectorResource(sectorModificado));
        
        return sectorAssembler.sectorASectorResource(sectorModificado);
    }

    @Override
    public String eliminarSector(Long idSector) {
        log.info("[SectorService]-[eliminarSector]-[]");
        
        return "";
    }
}
