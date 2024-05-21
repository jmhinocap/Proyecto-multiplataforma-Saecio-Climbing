package dam.pepehc.saecio_climbing_api.assembler;

import dam.pepehc.saecio_climbing_api.dto.AscensionDto;
import dam.pepehc.saecio_climbing_api.entity.Ascension;
import dam.pepehc.saecio_climbing_api.entity.Usuario;
import dam.pepehc.saecio_climbing_api.entity.Via;
import dam.pepehc.saecio_climbing_api.entity.clave_compuesta.AscensionClave;
import dam.pepehc.saecio_climbing_api.enums.TipoDeAscension;
import dam.pepehc.saecio_climbing_api.resource.AscensionResource;
import org.springframework.stereotype.Component;

import java.util.Date;

import static dam.pepehc.saecio_climbing_api.enums.TipoDeAscension.OTRO;

@Component
public class AscensionAssembler {

    /**
     * 
     * @param ascensionDto Un DTO que contiene toda la información para crear una nueva instancia de la entidad 
     *                     Ascension
     * @return Ascension
     */
    public Ascension ascensionDtoAAscension(final AscensionDto ascensionDto) {
        return Ascension.builder()
                .idAscension(ascensionDto.getIdAscension() == null ? new AscensionClave() 
                        : ascensionDto.getIdAscension())
                .usuario(ascensionDto.getUsuario() == null ? new Usuario() : ascensionDto.getUsuario())
                .via(ascensionDto.getVia() == null ? new Via() : ascensionDto.getVia())
                .fechaAscension(ascensionDto.getFechaAscension() == null ? new Date().toString()
                        : ascensionDto.getFechaAscension())
                .tipoDeAscension(ascensionDto.getTipoDeAscension() == null ? OTRO
                        : ascensionDto.getTipoDeAscension())
                .build();
    }

    /**
     * 
     * @param ascension Un objeto de la entidad Ascension
     * @return AscensionResource
     */
    public AscensionResource ascensionAAscensionResource(final Ascension ascension) {
        return AscensionResource.builder()
                .idAscension(ascension.getIdAscension() == null ? new AscensionClave() : ascension.getIdAscension())
                .usuario(ascension.getUsuario() == null ? new Usuario() : ascension.getUsuario())
                .via(ascension.getVia() == null ? new Via() : ascension.getVia())
                .fechaAscension(ascension.getFechaAscension() == null ? new Date().toString() 
                        : ascension.getFechaAscension())
                .tipoDeAscension(ascension.getTipoDeAscension() == null ? OTRO : ascension.getTipoDeAscension())
                .build();
    }

    /**
     *
     * @param ascensionDto Un DTO que contiene la información necesaria para crear una instancia de Ascension con
     *                     información modificada
     * @param ascension Una objeto de la entidad Ascension, sirviendo como refuerzo de aquellos atributos que no han 
     *                  sido modificados de la entrada
     * @return Ascension
     */
    public Ascension ascensionModificadaAAscension(final AscensionDto ascensionDto, final Ascension ascension) {
        return Ascension.builder()
                .idAscension(ascension.getIdAscension())
                .usuario(ascensionDto.getUsuario() == null ? ascension.getUsuario() : ascensionDto.getUsuario())
                .via(ascensionDto.getVia() == null ? ascension.getVia() : ascensionDto.getVia())
                .fechaAscension(ascensionDto.getFechaAscension() == null ? ascension.getFechaAscension()
                        : ascensionDto.getFechaAscension())
                .tipoDeAscension(ascensionDto.getTipoDeAscension() == null ? ascension.getTipoDeAscension()
                        : ascensionDto.getTipoDeAscension())
                .build();
    }
}
