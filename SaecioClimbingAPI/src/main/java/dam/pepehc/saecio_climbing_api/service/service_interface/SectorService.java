package dam.pepehc.saecio_climbing_api.service.service_interface;

import dam.pepehc.saecio_climbing_api.dto.NuevaViaDto;
import dam.pepehc.saecio_climbing_api.dto.NuevoSectorDto;
import dam.pepehc.saecio_climbing_api.dto.SectorDto;
import dam.pepehc.saecio_climbing_api.entity.Via;
import dam.pepehc.saecio_climbing_api.resource.SectorResource;

import java.util.List;

public interface SectorService {
    public SectorResource nuevoSector(final NuevoSectorDto nuevoSectorDto);
    public SectorResource leerSector(final Long idSector);
    public SectorResource modificarSector(final SectorDto sectorDto, final Long idSector);
    public String borrarSector(final Long idSector);
    public void anadirNuevaVia(final Via via);
    public List<SectorResource> leerSectoresPorIdZona(final Long idZona);
}
