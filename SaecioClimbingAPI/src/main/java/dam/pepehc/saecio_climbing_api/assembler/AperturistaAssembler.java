package dam.pepehc.saecio_climbing_api.assembler;

import dam.pepehc.saecio_climbing_api.dto.AperturistaDto;
import dam.pepehc.saecio_climbing_api.dto.NuevoAperturistaDto;
import dam.pepehc.saecio_climbing_api.entity.Aperturista;
import dam.pepehc.saecio_climbing_api.entity.DatosPersona;
import dam.pepehc.saecio_climbing_api.resource.AperturistaResource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;

@Component
public class AperturistaAssembler {
    
    public Aperturista aparturistaDtoAAperturista(final NuevoAperturistaDto nuevoAperturistaDto) {
        return Aperturista.builder()
                .idAperturista(nuevoAperturistaDto.getIdAperturista() == null ? 0L
                        : nuevoAperturistaDto.getIdAperturista())
                .idDatosPersona(nuevoAperturistaDto.getIdAperturista() == null ? 0L
                        : nuevoAperturistaDto.getIdAperturista())
                .vias(new ArrayList<>())
                .build();
    }
    
    public AperturistaResource aperturistaAAperturistaResource(final Aperturista aperturista) {
        return AperturistaResource.builder()
                .idAperturista(aperturista.getIdAperturista() == null ? 0L : aperturista.getIdAperturista())
                .idDatosPersona(aperturista.getIdAperturista() == null ? 0L : aperturista.getIdAperturista())
                .vias(aperturista.getVias() == null ? new ArrayList<>() : aperturista.getVias())
                .build();
    }
    
    public Aperturista aperturistaModificadoAAperturista (final AperturistaDto aperturistaDto,
                                                          final Aperturista aperturista) {
        return Aperturista.builder()
                .idAperturista(aperturista.getIdAperturista())
                .idDatosPersona(aperturistaDto.getIdAperturista() == null ? aperturista.getIdAperturista() 
                        : aperturistaDto.getIdAperturista())
                .vias(aperturistaDto.getVias() == null ? aperturista.getVias() : aperturistaDto.getVias())
                .build();
    }
}
