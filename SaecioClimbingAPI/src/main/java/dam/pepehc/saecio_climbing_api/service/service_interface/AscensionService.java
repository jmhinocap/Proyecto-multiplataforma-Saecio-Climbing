package dam.pepehc.saecio_climbing_api.service.service_interface;

import dam.pepehc.saecio_climbing_api.dto.AscensionDto;
import dam.pepehc.saecio_climbing_api.resource.AscensionResource;

import java.util.List;

/**
 * La interfaz Ascension service.
 */
public interface AscensionService {
    /**
     * Nueva ascension ascension resource.
     *
     * @param ascensionDto el ascension dto
     * @return el ascension resource
     */
    public AscensionResource nuevaAscension(final AscensionDto ascensionDto);

    /**
     * Leer ascension ascension resource.
     *
     * @param idAscension el id ascension
     * @return el ascension resource
     */
    public AscensionResource leerAscension(final Long idAscension);

    /**
     *  Leer ascensiones por id usuario
     * @param idUsuario el id usuario
     * @return la lista ascension resource
     */
    public List<AscensionResource> leerAscensionesPorIdUsuario(final Long idUsuario);

    /**
     * Modificar ascension ascension resource.
     *
     * @param ascensionDto el ascension dto
     * @param idAscension  el id ascension
     * @return el ascension resource
     */
    public AscensionResource modificarAscension(final AscensionDto ascensionDto, final Long idAscension);

    /**
     * Borrar ascension string.
     *
     * @param idAscension el id ascension
     * @return el string
     */
    public String borrarAscension(final Long idAscension);
}
