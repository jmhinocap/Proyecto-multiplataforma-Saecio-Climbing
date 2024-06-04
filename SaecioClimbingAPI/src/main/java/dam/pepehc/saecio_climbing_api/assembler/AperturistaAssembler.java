package dam.pepehc.saecio_climbing_api.assembler;

import dam.pepehc.saecio_climbing_api.dto.AperturistaDto;
import dam.pepehc.saecio_climbing_api.dto.NuevoAperturistaDto;
import dam.pepehc.saecio_climbing_api.entity.Aperturista;
import dam.pepehc.saecio_climbing_api.resource.AperturistaResource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * El tipo Aperturista assembler.
 */
@Component
public class AperturistaAssembler {

    /**
     * Aparturista dto a aperturista aperturista.
     *
     * @param nuevoAperturistaDto
     * @return 
     */
    public Aperturista aperturistaDtoAAperturista(final NuevoAperturistaDto nuevoAperturistaDto) {
        return Aperturista.builder()
                .idAperturista(nuevoAperturistaDto.getIdAperturista() == null ? 0L
                        : nuevoAperturistaDto.getIdAperturista())
                .idDatosPersona(nuevoAperturistaDto.getIdAperturista() == null ? 0L
                        : nuevoAperturistaDto.getIdAperturista())
                .vias(new ArrayList<>())
                .build();
    }

    /**
     * Aperturista a aperturista resource aperturista resource.
     *
     * @param aperturista 
     * @return 
     */
    public AperturistaResource aperturistaAAperturistaResource(final Aperturista aperturista) {
        return AperturistaResource.builder()
                .idAperturista(aperturista.getIdAperturista() == null ? 0L : aperturista.getIdAperturista())
                .idDatosPersona(aperturista.getIdAperturista() == null ? 0L : aperturista.getIdAperturista())
                .vias(aperturista.getVias() == null ? new ArrayList<>() : aperturista.getVias())
                .build();
    }

    /**
     * Aperturista modificado a aperturista aperturista.
     *
     * @param aperturistaDto 
     * @param aperturista    
     * @return 
     */
    public Aperturista aperturistaModificadoAAperturista (final AperturistaDto aperturistaDto,
                                                          final Aperturista aperturista) {
        return Aperturista.builder()
                .idAperturista(aperturista.getIdAperturista())
                .idDatosPersona(aperturistaDto.getIdAperturista() == null ? aperturista.getIdAperturista() 
                        : aperturistaDto.getIdAperturista())
                .vias(aperturista.getVias())
                .build();
    }
}
