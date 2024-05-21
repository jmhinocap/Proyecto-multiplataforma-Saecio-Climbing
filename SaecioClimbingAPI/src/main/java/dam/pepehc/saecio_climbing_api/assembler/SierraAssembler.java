package dam.pepehc.saecio_climbing_api.assembler;

import dam.pepehc.saecio_climbing_api.dto.NuevaSierraDto;
import dam.pepehc.saecio_climbing_api.dto.SierraDto;
import dam.pepehc.saecio_climbing_api.entity.Sierra;
import dam.pepehc.saecio_climbing_api.resource.SierraResource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;

@Component
public class SierraAssembler {

    private final static String IMAGEN_SIERRA_GENERICA = ""; // TODO crear imagen genérica de sierra

    /**
     * 
     * @param nuevaSierraDto Un DTO que contiene toda la información para crear una nueva instancia de la entidad 
     *                       Sierra
     * @return Sierra
     */
    public Sierra sierraDtoASierra(final NuevaSierraDto nuevaSierraDto) {
        return Sierra.builder()
                .idSierra(nuevaSierraDto.getIdSierra() == null ? 0L : nuevaSierraDto.getIdSierra())
                .nombre(nuevaSierraDto.getNombre() == null ? "" : nuevaSierraDto.getNombre())
                .coordenadas(nuevaSierraDto.getCoordenadas() == null ? "" : nuevaSierraDto.getCoordenadas())
                .foto(nuevaSierraDto.getFoto() == null ? IMAGEN_SIERRA_GENERICA : nuevaSierraDto.getFoto())
                .zonas(new ArrayList<>())
                .build();
    }

    /**
     * 
     * @param sierra Un objeto de la entidad Sierra
     * @return SierraResource
     */
    public SierraResource sierraASierraResource(final Sierra sierra) {
        return SierraResource.builder()
                .idSierra(sierra.getIdSierra() == null ? 0L : sierra.getIdSierra())
                .nombre(sierra.getNombre() == null ? "" : sierra.getNombre())
                .coordenadas(sierra.getCoordenadas() == null ? "" : sierra.getCoordenadas())
                .foto(sierra.getFoto() == null ? IMAGEN_SIERRA_GENERICA : sierra.getFoto())
                .zonas(sierra.getZonas() == null ? new ArrayList<>() : sierra.getZonas())
                .build();
    }

    /**
     * 
     * @param sierraDto Un DTO que contiene la información necesaria para crear una instancia de Sierra con información
     *                  modificada
     * @param sierra Una objeto de la entidad Sierra, sirviendo como refuerzo de aquellos atributos que no
     *               han sido modificados de la entrada
     * @return Sierra
     */
    public Sierra sierraModificadaASierra(final SierraDto sierraDto, final Sierra sierra) {
        return Sierra.builder()
                .idSierra(sierra.getIdSierra())
                .nombre(sierraDto.getNombre() == null ? sierra.getNombre() : sierraDto.getNombre())
                .foto(sierraDto.getFoto() == null ? sierra.getFoto() : sierraDto.getFoto())
                .zonas(sierraDto.getZonas() == null ? sierra.getZonas() : sierraDto.getZonas())
                .build();
    }
}
