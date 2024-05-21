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

    /**
     * 
     * @param nuevoAperturistaDto Un DTO que contiene toda la información para crear una nueva instancia de la entidad
     *                            Aperturista
     * @return Aperturista
     */
    public Aperturista aparturistaDtoAAperturista(final NuevoAperturistaDto nuevoAperturistaDto) {
        return Aperturista.builder()
                .idAperturista(nuevoAperturistaDto.getIdAperturista() == null ? 0L
                        : nuevoAperturistaDto.getIdAperturista())
                .idDatosPersona(nuevoAperturistaDto.getIdAperturista() == null ? 0L
                        : nuevoAperturistaDto.getIdAperturista())
                .vias(new ArrayList<>())
                .build();
    }

    /**
     * 
     * @param aperturista Un objeto de la entidad Aperturista
     * @return AperturistaResource
     */
    public AperturistaResource aperturistaAAperturistaResource(final Aperturista aperturista) {
        return AperturistaResource.builder()
                .idAperturista(aperturista.getIdAperturista() == null ? 0L : aperturista.getIdAperturista())
                .idDatosPersona(aperturista.getIdAperturista() == null ? 0L : aperturista.getIdAperturista())
                .vias(aperturista.getVias() == null ? new ArrayList<>() : aperturista.getVias())
                .build();
    }

    /**
     * 
     * @param aperturistaDto Un DTO que contiene la información necesaria para crear una instancia de Aperturista con
     *                       información modificada
     * @param aperturista Una objeto de la entidad Aperturista, sirviendo como refuerzo de aquellos atributos que no
     *                    han sido modificados de la entrada
     * @return Aperturista
     */
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
