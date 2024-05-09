package dam.pepehc.saecio_climbing_api.assembler;

import dam.pepehc.saecio_climbing_api.dto.NuevoSectorDto;
import dam.pepehc.saecio_climbing_api.dto.SectorDto;
import dam.pepehc.saecio_climbing_api.entity.Sector;
import dam.pepehc.saecio_climbing_api.resource.SectorResource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;

@Component
public class SectorAssembler {
    
    private final static String CROQUIS_VACIO = ""; // TODO crear pdf de croquis vacío
    private final static String IMAGEN_SECTOR_GENERICA = ""; // TODO crear imagen genérica de sector
    
    public Sector sectorDtoASector(final NuevoSectorDto nuevoSectorDto) {
        return Sector.builder()
                .idSector(nuevoSectorDto.getIdSector() == null ? 0L : nuevoSectorDto.getIdSector())
                .idZona(nuevoSectorDto.getIdZona() == null ? 0L : nuevoSectorDto.getIdZona())
                .nombre(nuevoSectorDto.getNombre() == null ? "" : nuevoSectorDto.getNombre())
                .coordenadas(nuevoSectorDto.getCoordenadas() == null ? "" : nuevoSectorDto.getCoordenadas())
                .croquis(nuevoSectorDto.getCroquis() == null ? new File(CROQUIS_VACIO) : nuevoSectorDto.getCroquis())
                .foto(nuevoSectorDto.getFoto() == null ? new File(IMAGEN_SECTOR_GENERICA) : nuevoSectorDto.getFoto())
                .vias(new ArrayList<>())
                .build();
    }
    
    public SectorResource sectorASectorResource(final Sector sector) {
        return SectorResource.builder()
                .idSector(sector.getIdSector() == null ? 0L : sector.getIdSector())
                .idZona(sector.getIdZona() == null ? 0L : sector.getIdZona())
                .nombre(sector.getNombre() == null ? "" : sector.getNombre())
                .coordenadas(sector.getCoordenadas() == null ? "" : sector.getCoordenadas())
                .croquis(sector.getCroquis() == null ? new File(CROQUIS_VACIO) : sector.getCroquis())
                .foto(sector.getFoto() == null ? new File(IMAGEN_SECTOR_GENERICA) : sector.getFoto())
                .vias(sector.getVias() == null ? new ArrayList<>() : sector.getVias())
                .build();
    }
    
    public Sector sectorModificadoASector(final SectorDto sectorDto, final Sector sector) {
        return Sector.builder()
                .idSector(sector.getIdSector())
                .idZona(sectorDto.getIdZona() == null ? sector.getIdZona() : sectorDto.getIdZona())
                .nombre(sectorDto.getNombre() == null ? sector.getNombre() : sectorDto.getNombre())
                .coordenadas(sectorDto.getCoordenadas() == sector.getCoordenadas() ? "" : sectorDto.getCoordenadas())
                .croquis(sectorDto.getCroquis() == null ? sector.getCroquis() : sectorDto.getCroquis())
                .foto(sectorDto.getFoto() == null ? sector.getFoto() : sectorDto.getFoto())
                .vias(sectorDto.getVias() == null ? sector.getVias() : sectorDto.getVias())
                .build();
    }
}
