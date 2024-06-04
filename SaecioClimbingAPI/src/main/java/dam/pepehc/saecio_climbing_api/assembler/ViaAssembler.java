package dam.pepehc.saecio_climbing_api.assembler;

import dam.pepehc.saecio_climbing_api.dto.NuevaViaDto;
import dam.pepehc.saecio_climbing_api.dto.ViaDto;
import dam.pepehc.saecio_climbing_api.entity.Via;
import dam.pepehc.saecio_climbing_api.enums.TipoDeEscalada;
import dam.pepehc.saecio_climbing_api.resource.ViaResource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * El tipo Via assembler.
 */
@Component
public class ViaAssembler {
    
    private final static String IMAGEN_VIA_GENERICA = ""; // TODO crear imagen genérica de vía

    /**
     * Via dto a via via.
     *
     * @param viaDto 
     * @return 
     */
    public Via viaDtoAVia(final ViaDto viaDto) {
        return Via.builder()
                .idVia(viaDto.getIdVia() == null ? 0L : viaDto.getIdVia())
                .idSector(viaDto.getIdSector() == null ? 0L : viaDto.getIdSector())
                .numeroDeCroquis(viaDto.getNumeroDeCroquis() == null ? "0" : viaDto.getNumeroDeCroquis())
                .nombre(viaDto.getNombre() == null ? StringUtils.EMPTY : viaDto.getNombre())
                .grado(viaDto.getGrado() == null ? StringUtils.EMPTY : viaDto.getGrado())
                .metros(viaDto.getMetros() == null ? StringUtils.EMPTY : viaDto.getMetros())
                .numeroChapas(viaDto.getNumeroChapas() == null ? StringUtils.EMPTY : viaDto.getNumeroChapas())
                .fechaApertura(viaDto.getFechaApertura() == null ? StringUtils.EMPTY : viaDto.getFechaApertura())
                .fechaUltimaRevision(viaDto.getFechaUltimaRevision() == null ? StringUtils.EMPTY :
                        viaDto.getFechaUltimaRevision())
                .descripcion(viaDto.getDescripcion() == null ? StringUtils.EMPTY : viaDto.getDescripcion())
                .foto(viaDto.getFoto() == null ? IMAGEN_VIA_GENERICA : viaDto.getFoto())
                .tipoDeEscalada(viaDto.getTipoDeEscalada().toString() == null ? TipoDeEscalada.DEPORTIVA.toString()
                        : viaDto.getTipoDeEscalada().toString())
                .aperturistas(new ArrayList<>())
                .ascensiones(new ArrayList<>())
                .build();
    }

    /**
     * Nueva via dto a via via.
     *
     * @param nuevaViaDto 
     * @return 
     */
    public Via nuevaViaDtoAVia(final NuevaViaDto nuevaViaDto) {
        return Via.builder()
                .idVia(nuevaViaDto.getIdVia() == null ? 0L : nuevaViaDto.getIdVia())
                .idSector(nuevaViaDto.getIdSector() == null ? 0L : nuevaViaDto.getIdSector())
                .numeroDeCroquis(nuevaViaDto.getNumeroDeCroquis() == null ? "0" : nuevaViaDto.getNumeroDeCroquis())
                .nombre(nuevaViaDto.getNombre() == null ? StringUtils.EMPTY : nuevaViaDto.getNombre())
                .grado(nuevaViaDto.getGrado() == null ? StringUtils.EMPTY : nuevaViaDto.getGrado())
                .metros(nuevaViaDto.getMetros() == null ? StringUtils.EMPTY : nuevaViaDto.getMetros())
                .numeroChapas(nuevaViaDto.getNumeroChapas() == null ? StringUtils.EMPTY : nuevaViaDto.getNumeroChapas())
                .fechaApertura(nuevaViaDto.getFechaApertura() == null ? StringUtils.EMPTY 
                        : nuevaViaDto.getFechaApertura())
                .fechaUltimaRevision(nuevaViaDto.getFechaUltimaRevision() == null ? StringUtils.EMPTY :
                        nuevaViaDto.getFechaUltimaRevision())
                .descripcion(nuevaViaDto.getDescripcion() == null ? StringUtils.EMPTY : nuevaViaDto.getDescripcion())
                .foto(nuevaViaDto.getFoto() == null ? IMAGEN_VIA_GENERICA : nuevaViaDto.getFoto())
                .tipoDeEscalada(nuevaViaDto.getTipoDeEscalada().toString() == null ? TipoDeEscalada.DEPORTIVA.toString() 
                        : nuevaViaDto.getTipoDeEscalada().toString())
                .aperturistas(new ArrayList<>())
                .ascensiones(new ArrayList<>())
                .build();
    }

    /**
     * Via a via resource via resource.
     *
     * @param via 
     * @return 
     */
    public ViaResource viaAViaResource(final Via via) {
        return ViaResource.builder()
                .idVia(via.getIdVia() == null ? 0L : via.getIdVia())
                .idSector(via.getIdSector() == null ? 0L : via.getIdSector())
                .numeroDeCroquis(via.getNumeroDeCroquis() == null ? StringUtils.EMPTY : via.getNumeroDeCroquis())
                .nombre(via.getNombre() == null ? StringUtils.EMPTY : via.getNombre())
                .grado(via.getGrado() == null ? StringUtils.EMPTY : via.getGrado())
                .metros(via.getMetros() == null ? StringUtils.EMPTY : via.getMetros())
                .numeroChapas(via.getNumeroChapas() == null ? StringUtils.EMPTY : via.getNumeroChapas())
                .fechaApertura(via.getFechaApertura() == null ? StringUtils.EMPTY : via.getFechaApertura())
                .fechaUltimaRevision(via.getFechaUltimaRevision() == null ? StringUtils.EMPTY 
                        : via.getFechaUltimaRevision())
                .descripcion(via.getDescripcion() == null ? StringUtils.EMPTY : via.getDescripcion())
                .foto(via.getFoto() == null ? IMAGEN_VIA_GENERICA : via.getFoto())
                .tipoDeEscalada(via.getTipoDeEscalada() == null ? StringUtils.EMPTY : via.getTipoDeEscalada())
                .ascensiones(via.getAscensiones() == null ? new ArrayList<>() : via.getAscensiones())
                .aperturistas(via.getAperturistas() == null ? new ArrayList<>() : via.getAperturistas())
                .build();
    }

    /**
     * Via modificada a via via.
     *
     * @param viaDto 
     * @param via    
     * @return 
     */
    public Via viaModificadaAVia(final ViaDto viaDto, final Via via) {
        return Via.builder()
                .idVia(via.getIdVia())
                .idSector(viaDto.getIdSector() == null ? via.getIdSector() : viaDto.getIdSector())
                .numeroDeCroquis(viaDto.getNumeroDeCroquis() == null ? via.getNumeroDeCroquis() 
                        : viaDto.getNumeroDeCroquis())
                .nombre(viaDto.getNombre() == null ? via.getNombre() : viaDto.getNombre())
                .grado(viaDto.getGrado() == null ? via.getGrado() : viaDto.getGrado())
                .metros(viaDto.getMetros() == null ? via.getMetros() : viaDto.getMetros())
                .numeroChapas(viaDto.getNumeroChapas() == null ? via.getNumeroChapas() : viaDto.getNumeroChapas())
                .fechaApertura(viaDto.getFechaApertura() == null ? via.getFechaApertura() : viaDto.getFechaApertura())
                .fechaUltimaRevision(viaDto.getFechaUltimaRevision() == null ? via.getFechaUltimaRevision()
                        : viaDto.getFechaUltimaRevision())
                .descripcion(viaDto.getDescripcion() == null ? via.getDescripcion() : viaDto.getDescripcion())
                .foto(viaDto.getFoto() == null ? via.getFoto() : viaDto.getFoto())
                .tipoDeEscalada(via.getTipoDeEscalada() == null ? via.getTipoDeEscalada() 
                        : viaDto.getTipoDeEscalada().toString())
                .ascensiones(via.getAscensiones())
                .aperturistas(via.getAperturistas())
                .build();
    }
}
