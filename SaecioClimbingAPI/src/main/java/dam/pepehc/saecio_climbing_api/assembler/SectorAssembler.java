package dam.pepehc.saecio_climbing_api.assembler;

import dam.pepehc.saecio_climbing_api.dto.NuevoSectorDto;
import dam.pepehc.saecio_climbing_api.dto.SectorDto;
import dam.pepehc.saecio_climbing_api.entity.Sector;
import dam.pepehc.saecio_climbing_api.enums.TipoDeEscalada;
import dam.pepehc.saecio_climbing_api.resource.SectorResource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * El tipo Sector assembler.
 */
@Component
public class SectorAssembler {
    
    private final static String CROQUIS_VACIO = ""; // TODO crear pdf de croquis vacío
    private final static String IMAGEN_SECTOR_GENERICA = ""; // TODO crear imagen genérica de sector

    /**
     * Sector dto a sector sector.
     *
     * @param nuevoSectorDto 
     * @return 
     */
    public Sector sectorDtoASector(final NuevoSectorDto nuevoSectorDto) {
        List<String> tiposDeEscalada = new ArrayList<>();
        
        if (!(nuevoSectorDto.getTiposDeEscalada().isEmpty())) {
            for (TipoDeEscalada t : nuevoSectorDto.getTiposDeEscalada()) {
                tiposDeEscalada.add(t.toString());
            }
        }
        
        return Sector.builder()
                .idSector(nuevoSectorDto.getIdSector() == null ? 0L : nuevoSectorDto.getIdSector())
                .idZona(nuevoSectorDto.getIdZona() == null ? 0L : nuevoSectorDto.getIdZona())
                .nombre(nuevoSectorDto.getNombre() == null ? StringUtils.EMPTY : nuevoSectorDto.getNombre())
                .coordenadas(nuevoSectorDto.getCoordenadas() == null ? StringUtils.EMPTY
                        : nuevoSectorDto.getCoordenadas())
                .croquis(nuevoSectorDto.getCroquis() == null ? StringUtils.EMPTY : nuevoSectorDto.getCroquis())
                .foto(nuevoSectorDto.getFoto() == null ? IMAGEN_SECTOR_GENERICA : nuevoSectorDto.getFoto())
                .tiposDeEscalada(nuevoSectorDto.getTiposDeEscalada() == null ? new ArrayList<>() : tiposDeEscalada)
                .vias(new ArrayList<>())
                .build();
    }

    /**
     * Sector a sector resource sector resource.
     *
     * @param sector 
     * @return 
     */
    public SectorResource sectorASectorResource(final Sector sector) {
        return SectorResource.builder()
                .idSector(sector.getIdSector() == null ? 0L : sector.getIdSector())
                .idZona(sector.getIdZona() == null ? 0L : sector.getIdZona())
                .nombre(sector.getNombre() == null ? StringUtils.EMPTY : sector.getNombre())
                .coordenadas(sector.getCoordenadas() == null ? StringUtils.EMPTY : sector.getCoordenadas())
                .croquis(sector.getCroquis() == null ? StringUtils.EMPTY : sector.getCroquis())
                .foto(sector.getFoto() == null ? IMAGEN_SECTOR_GENERICA : sector.getFoto())
                .tiposDeEscalada(sector.getTiposDeEscalada() == null ? new ArrayList<>() : sector.getTiposDeEscalada())
                .vias(sector.getVias() == null ? new ArrayList<>() : sector.getVias())
                .build();
    }

    /**
     * Sector modificado a sector sector.
     *
     * @param sectorDto 
     * @param sector    
     * @return 
     */
    public Sector sectorModificadoASector(final SectorDto sectorDto, final Sector sector) {
        List<String> tiposDeEscalada = new ArrayList<>();
        
        if (!(sectorDto.getTiposDeEscalada().isEmpty())) {
            for (TipoDeEscalada t : sectorDto.getTiposDeEscalada()) {
                tiposDeEscalada.add(t.toString());
            }
        }
        
        return Sector.builder()
                .idSector(sector.getIdSector())
                .idZona(sectorDto.getIdZona() == null ? sector.getIdZona() : sectorDto.getIdZona())
                .nombre(sectorDto.getNombre() == null ? sector.getNombre() : sectorDto.getNombre())
                .coordenadas(sectorDto.getCoordenadas() == null ? sector.getCoordenadas() : sectorDto.getCoordenadas())
                .croquis(sectorDto.getCroquis() == null ? sector.getCroquis() : sectorDto.getCroquis())
                .foto(sectorDto.getFoto() == null ? sector.getFoto() : sectorDto.getFoto())
                .tiposDeEscalada(sectorDto.getTiposDeEscalada() == null ? sector.getTiposDeEscalada() : tiposDeEscalada)
                .vias(sector.getVias())
                .build();
    }
}
