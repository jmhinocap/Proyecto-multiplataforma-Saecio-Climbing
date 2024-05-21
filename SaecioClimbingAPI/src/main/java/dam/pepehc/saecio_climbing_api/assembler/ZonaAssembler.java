package dam.pepehc.saecio_climbing_api.assembler;

import dam.pepehc.saecio_climbing_api.dto.NuevaZonaDto;
import dam.pepehc.saecio_climbing_api.dto.ZonaDto;
import dam.pepehc.saecio_climbing_api.entity.Zona;
import dam.pepehc.saecio_climbing_api.resource.ZonaResource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;

@Component
public class ZonaAssembler {

    private final static String IMAGEN_ZONA_GENERICA = ""; // TODO crear imagen genérica de zona

    /**
     * 
     * @param nuevaZonaDto
     * @return
     */
    public Zona zonaDtoAZona(final NuevaZonaDto nuevaZonaDto) {
        return Zona.builder()
                .idZona(nuevaZonaDto.getIdZona() == null ? 0L : nuevaZonaDto.getIdZona())
                .idSierra(nuevaZonaDto.getIdSierra() == null ? 0L : nuevaZonaDto.getIdSierra())
                .nombre(nuevaZonaDto.getNombre() == null ? "" : nuevaZonaDto.getNombre())
                .coordenadas(nuevaZonaDto.getCoordenadas() == null ? "" : nuevaZonaDto.getCoordenadas())
                .foto(nuevaZonaDto.getFoto() == null ? IMAGEN_ZONA_GENERICA : nuevaZonaDto.getFoto())
                .sectores(new ArrayList<>())
                .build();
    }

    /**
     * 
     * @param zona
     * @return
     */
    public ZonaResource zonaAZonaResource(final Zona zona) {
        return ZonaResource.builder()
                .idZona(zona.getIdZona() == null ? 0L : zona.getIdZona())
                .idSierra(zona.getIdSierra() == null ? 0L : zona.getIdSierra())
                .nombre(zona.getNombre() == null ? "" : zona.getNombre())
                .coordenadas(zona.getCoordenadas() == null ? "" : zona.getCoordenadas())
                .foto(zona.getFoto() == null ? IMAGEN_ZONA_GENERICA : zona.getFoto())
                .sectores(zona.getSectores() == null ? new ArrayList<>() : zona.getSectores())
                .build();
    }

    /**
     * 
     * @param zonaDto
     * @param zona
     * @return
     */
    public Zona zonaModificadaAZona(final ZonaDto zonaDto, final Zona zona) {
        return Zona.builder()
                .idZona(zona.getIdZona())
                .idSierra(zonaDto.getIdSierra() == null ? zona.getIdSierra() : zonaDto.getIdSierra())
                .nombre(zonaDto.getNombre() == null ? zona.getNombre() : zonaDto.getNombre())
                .coordenadas(zonaDto.getCoordenadas() == null ? zona.getCoordenadas() : zonaDto.getCoordenadas())
                .foto(zonaDto.getFoto() == null ? zona.getFoto() : zonaDto.getFoto())
                .sectores(zonaDto.getSectores() == null ? zona.getSectores() : zonaDto.getSectores())
                .build();
    }
}
