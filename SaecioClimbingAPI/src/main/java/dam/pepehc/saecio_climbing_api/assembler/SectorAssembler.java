package dam.pepehc.SaecioClimbingAPI.assembler;

import dam.pepehc.SaecioClimbingAPI.dto.SectorDto;
import dam.pepehc.SaecioClimbingAPI.entity.Sector;
import dam.pepehc.SaecioClimbingAPI.resource.SectorResource;
import org.springframework.stereotype.Component;

@Component
public class SectorAssembler {
    
    public Sector sectorDtoASector(final SectorDto sectorDto) {
        return Sector.builder().build();
    }
    
    public SectorResource sectorASectorResource(final Sector sector) {
        return SectorResource.builder().build();
    }
    
    public Sector sectorModificadoASector(final SectorDto sectorDto, final Sector sector) {
        return Sector.builder().build();
    }
}
