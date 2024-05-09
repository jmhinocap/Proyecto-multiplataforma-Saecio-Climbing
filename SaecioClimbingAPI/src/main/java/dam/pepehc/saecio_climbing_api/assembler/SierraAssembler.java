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

    private final static String IMAGEN_SIERRA_GENERICA = ""; // TODO crear imagen genérica de vía
    
    public Sierra sierraDtoASierra(final NuevaSierraDto nuevaSierraDto) {
        return Sierra.builder()
                .idSierra(nuevaSierraDto.getIdSierra() == null ? 0L : nuevaSierraDto.getIdSierra())
                .nombre(nuevaSierraDto.getNombre() == null ? "" : nuevaSierraDto.getNombre())
                .foto(nuevaSierraDto.getFoto() == null ? new File(IMAGEN_SIERRA_GENERICA) : nuevaSierraDto.getFoto())
                .zonas(new ArrayList<>())
                .build();
    }
    
    public SierraResource sierraASierraResource(final Sierra sierra) {
        return SierraResource.builder()
                .idSierra(sierra.getIdSierra() == null ? 0L : sierra.getIdSierra())
                .nombre(sierra.getNombre() == null ? "" : sierra.getNombre())
                .foto(sierra.getFoto() == null ? new File(IMAGEN_SIERRA_GENERICA) : sierra.getFoto())
                .zonas(sierra.getZonas() == null ? new ArrayList<>() : sierra.getZonas())
                .build();
    }
    
    public Sierra sierraModificadaASierra(final SierraDto sierraDto, final Sierra sierra) {
        return Sierra.builder()
                .idSierra(sierra.getIdSierra())
                .nombre(sierraDto.getNombre() == null ? sierra.getNombre() : sierraDto.getNombre())
                .foto(sierraDto.getFoto() == null ? sierra.getFoto() : sierraDto.getFoto())
                .zonas(sierraDto.getZonas() == null ? sierra.getZonas() : sierraDto.getZonas())
                .build();
    }
}
