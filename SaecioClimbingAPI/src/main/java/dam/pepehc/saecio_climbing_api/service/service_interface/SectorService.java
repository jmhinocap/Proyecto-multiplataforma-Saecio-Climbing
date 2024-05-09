package dam.pepehc.SaecioClimbingAPI.service.service_interface;

import dam.pepehc.SaecioClimbingAPI.dto.SectorDto;
import dam.pepehc.SaecioClimbingAPI.resource.SectorResource;

public interface SectorService {
    public SectorResource nuevoSector(final SectorDto sectorDto);
    public SectorResource leerSector(final Long idSector);
    public SectorResource modificarSector(final SectorDto sectorDto, final Long idSector);
    public String eliminarSector(final Long idSector);
}
