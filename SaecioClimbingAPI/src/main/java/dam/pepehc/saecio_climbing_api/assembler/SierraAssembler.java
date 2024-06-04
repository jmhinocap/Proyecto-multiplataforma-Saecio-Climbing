package dam.pepehc.saecio_climbing_api.assembler;

import dam.pepehc.saecio_climbing_api.dto.NuevaSierraDto;
import dam.pepehc.saecio_climbing_api.dto.SierraDto;
import dam.pepehc.saecio_climbing_api.entity.Sierra;
import dam.pepehc.saecio_climbing_api.resource.SierraResource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * El tipo Sierra assembler.
 */
@Component
public class SierraAssembler {

    private final static String IMAGEN_SIERRA_GENERICA = ""; // TODO crear imagen genérica de sierra

    /**
     * Sierra dto a sierra sierra.
     *
     * @param nuevaSierraDto 
     * @return 
     */
    public Sierra sierraDtoASierra(final NuevaSierraDto nuevaSierraDto) {
        return Sierra.builder()
                .idSierra(nuevaSierraDto.getIdSierra() == null ? 0L : nuevaSierraDto.getIdSierra())
                .nombre(nuevaSierraDto.getNombre() == null ? StringUtils.EMPTY : nuevaSierraDto.getNombre())
                .coordenadas(nuevaSierraDto.getCoordenadas() == null ? StringUtils.EMPTY
                        : nuevaSierraDto.getCoordenadas())
                .foto(nuevaSierraDto.getFoto() == null ? IMAGEN_SIERRA_GENERICA : nuevaSierraDto.getFoto())
                .zonas(new ArrayList<>())
                .build();
    }

    /**
     * Sierra a sierra resource sierra resource.
     *
     * @param sierra 
     * @return 
     */
    public SierraResource sierraASierraResource(final Sierra sierra) {
        return SierraResource.builder()
                .idSierra(sierra.getIdSierra() == null ? 0L : sierra.getIdSierra())
                .nombre(sierra.getNombre() == null ? StringUtils.EMPTY : sierra.getNombre())
                .coordenadas(sierra.getCoordenadas() == null ? StringUtils.EMPTY : sierra.getCoordenadas())
                .foto(sierra.getFoto() == null ? IMAGEN_SIERRA_GENERICA : sierra.getFoto())
                .zonas(sierra.getZonas() == null ? new ArrayList<>() : sierra.getZonas())
                .build();
    }

    /**
     * Sierra modificada a sierra sierra.
     *
     * @param sierraDto 
     * @param sierra    
     * @return sierra
     */
    public Sierra sierraModificadaASierra(final SierraDto sierraDto, final Sierra sierra) {
        return Sierra.builder()
                .idSierra(sierra.getIdSierra())
                .nombre(sierraDto.getNombre() == null ? sierra.getNombre() : sierraDto.getNombre())
                .foto(sierraDto.getFoto() == null ? sierra.getFoto() : sierraDto.getFoto())
                .zonas(sierra.getZonas())
                .build();
    }
}
