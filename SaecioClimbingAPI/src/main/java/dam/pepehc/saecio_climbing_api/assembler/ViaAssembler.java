package dam.pepehc.saecio_climbing_api.assembler;

import dam.pepehc.saecio_climbing_api.dto.NuevaViaDto;
import dam.pepehc.saecio_climbing_api.dto.ViaDto;
import dam.pepehc.saecio_climbing_api.entity.Via;
import dam.pepehc.saecio_climbing_api.resource.ViaResource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;

@Component
public class ViaAssembler {

    private final static String IMAGEN_VIA_GENERICA = ""; // TODO crear imagen genérica de vía
    
    public Via nuevaViaDtoAVia(final NuevaViaDto nuevaViaDto) {
        return Via.builder()
                .idVia(nuevaViaDto.getIdVia() == null ? 0L : nuevaViaDto.getIdVia())
                .idSector(nuevaViaDto.getIdSector() == null ? 0L : nuevaViaDto.getIdSector())
                .nombre(nuevaViaDto.getNombre() == null ? "" : nuevaViaDto.getNombre())
                .grado(nuevaViaDto.getGrado() == null ? "" : nuevaViaDto.getGrado())
                .metros(nuevaViaDto.getMetros() == null ? "" : nuevaViaDto.getMetros())
                .numeroChapas(nuevaViaDto.getNumeroChapas() == null ? "" : nuevaViaDto.getNumeroChapas())
                .fechaApertura(nuevaViaDto.getFechaApertura() == null ? "" : nuevaViaDto.getFechaApertura())
                .fechaUltimaRevision(nuevaViaDto.getFechaUltimaRevision() == null ? "" :
                        nuevaViaDto.getFechaUltimaRevision())
                .descripcion(nuevaViaDto.getDescripcion() == null ? "" : nuevaViaDto.getDescripcion())
                .foto(nuevaViaDto.getFoto() == null ? new File(IMAGEN_VIA_GENERICA) : nuevaViaDto.getFoto())
                .aperturistas(new ArrayList<>())
                .ascensiones(new ArrayList<>())
                .build();
    }
    
    public ViaResource viaAViaResource(final Via via) {
        return ViaResource.builder()
                .idVia(via.getIdVia() == null ? 0L : via.getIdVia())
                .idSector(via.getIdSector() == null ? 0L : via.getIdSector())
                .nombre(via.getNombre() == null ? "" : via.getNombre())
                .grado(via.getGrado() == null ? "" : via.getGrado())
                .metros(via.getMetros() == null ? "" : via.getMetros())
                .numeroChapas(via.getNumeroChapas() == null ? "" : via.getNumeroChapas())
                .fechaApertura(via.getFechaApertura() == null ? "" : via.getFechaApertura())
                .fechaUltimaRevision(via.getFechaUltimaRevision() == null ? "" : via.getFechaUltimaRevision())
                .descripcion(via.getDescripcion() == null ? "" : via.getDescripcion())
                .foto(via.getFoto() == null ? new File(IMAGEN_VIA_GENERICA) : via.getFoto())
                .ascensiones(via.getAscensiones() == null ? new ArrayList<>() : via.getAscensiones())
                .aperturistas(via.getAperturistas() == null ? new ArrayList<>() : via.getAperturistas())
                .build();
    }
    
    public Via viaModificadaAVia(final ViaDto viaDto, final Via via) {
        return Via.builder()
                .idVia(via.getIdVia())
                .idSector(viaDto.getIdSector() == null ? via.getIdSector() : viaDto.getIdSector())
                .nombre(viaDto.getNombre() == null ? via.getNombre() : viaDto.getNombre())
                .grado(viaDto.getGrado() == null ? via.getGrado() : viaDto.getGrado())
                .metros(viaDto.getMetros() == null ? via.getMetros() : viaDto.getMetros())
                .numeroChapas(viaDto.getNumeroChapas() == null ? via.getNumeroChapas() : viaDto.getNumeroChapas())
                .fechaApertura(viaDto.getFechaApertura() == null ? via.getFechaApertura() : viaDto.getFechaApertura())
                .fechaUltimaRevision(viaDto.getFechaUltimaRevision() == null ? via.getFechaUltimaRevision()
                        : viaDto.getFechaUltimaRevision())
                .descripcion(viaDto.getDescripcion() == null ? via.getDescripcion() : viaDto.getDescripcion())
                .foto(viaDto.getFoto() == null ? via.getFoto() : viaDto.getFoto())
                .ascensiones(viaDto.getAscensiones() == null ? via.getAscensiones() : viaDto.getAscensiones())
                .aperturistas(viaDto.getAperturistas() == null ? via.getAperturistas() : viaDto.getAperturistas())
                .build();
    }
}
