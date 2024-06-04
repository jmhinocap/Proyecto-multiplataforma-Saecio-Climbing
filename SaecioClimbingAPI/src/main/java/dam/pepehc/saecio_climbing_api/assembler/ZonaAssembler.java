package dam.pepehc.saecio_climbing_api.assembler;

import dam.pepehc.saecio_climbing_api.dto.NuevaZonaDto;
import dam.pepehc.saecio_climbing_api.dto.ZonaDto;
import dam.pepehc.saecio_climbing_api.entity.Zona;
import dam.pepehc.saecio_climbing_api.enums.TipoDeEscalada;
import dam.pepehc.saecio_climbing_api.resource.ZonaResource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * El tipo Zona assembler.
 */
@Component
public class ZonaAssembler {

    private final static String IMAGEN_ZONA_GENERICA = ""; // TODO crear imagen genérica de zona

    /**
     * Zona dto a zona zona.
     *
     * @param nuevaZonaDto 
     * @return 
     */
    public Zona zonaDtoAZona(final NuevaZonaDto nuevaZonaDto) {
        List<String> tiposDeEscalada = new ArrayList<>();
        
        if (!(nuevaZonaDto.getTiposDeEscalada().isEmpty())) {
            for (TipoDeEscalada t : nuevaZonaDto.getTiposDeEscalada()) {
                tiposDeEscalada.add(t.toString());
            }
        }
        
        return Zona.builder()
                .idZona(nuevaZonaDto.getIdZona() == null ? 0L : nuevaZonaDto.getIdZona())
                .idSierra(nuevaZonaDto.getIdSierra() == null ? 0L : nuevaZonaDto.getIdSierra())
                .nombre(nuevaZonaDto.getNombre() == null ? StringUtils.EMPTY : nuevaZonaDto.getNombre())
                .coordenadas(nuevaZonaDto.getCoordenadas() == null ? StringUtils.EMPTY : nuevaZonaDto.getCoordenadas())
                .foto(nuevaZonaDto.getFoto() == null ? IMAGEN_ZONA_GENERICA : nuevaZonaDto.getFoto())
                .tiposDeEscalada(nuevaZonaDto.getTiposDeEscalada() == null ? new ArrayList<>() : tiposDeEscalada)
                .sectores(new ArrayList<>())
                .build();
    }

    /**
     * Zona a zona resource zona resource.
     *
     * @param zona 
     * @return 
     */
    public ZonaResource zonaAZonaResource(final Zona zona) {
        return ZonaResource.builder()
                .idZona(zona.getIdZona() == null ? 0L : zona.getIdZona())
                .idSierra(zona.getIdSierra() == null ? 0L : zona.getIdSierra())
                .nombre(zona.getNombre() == null ? StringUtils.EMPTY : zona.getNombre())
                .coordenadas(zona.getCoordenadas() == null ? StringUtils.EMPTY : zona.getCoordenadas())
                .foto(zona.getFoto() == null ? IMAGEN_ZONA_GENERICA : zona.getFoto())
                .tiposDeEscalada(zona.getTiposDeEscalada() == null ? new ArrayList<>() : zona.getTiposDeEscalada())
                .sectores(zona.getSectores() == null ? new ArrayList<>() : zona.getSectores())
                .build();
    }

    /**
     * Zona modificada a zona zona.
     *
     * @param zonaDto 
     * @param zona    
     * @return 
     */
    public Zona zonaModificadaAZona(final ZonaDto zonaDto, final Zona zona) {
        List<String> tiposDeEscalada = new ArrayList<>();
        
        if (!(zonaDto.getTiposDeEscalada().isEmpty())) {
            for (TipoDeEscalada t : zonaDto.getTiposDeEscalada()) {
                tiposDeEscalada.add(t.toString());
            }
        }
        
        return Zona.builder()
                .idZona(zona.getIdZona())
                .idSierra(zonaDto.getIdSierra() == null ? zona.getIdSierra() : zonaDto.getIdSierra())
                .nombre(zonaDto.getNombre() == null ? zona.getNombre() : zonaDto.getNombre())
                .coordenadas(zonaDto.getCoordenadas() == null ? zona.getCoordenadas() : zonaDto.getCoordenadas())
                .foto(zonaDto.getFoto() == null ? zona.getFoto() : zonaDto.getFoto())
                .tiposDeEscalada(zonaDto.getTiposDeEscalada() == null ? zona.getTiposDeEscalada() 
                        : tiposDeEscalada)
                .sectores(zona.getSectores())
                .build();
    }
}
