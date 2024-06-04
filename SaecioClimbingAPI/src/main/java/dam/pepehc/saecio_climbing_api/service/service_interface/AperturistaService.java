package dam.pepehc.saecio_climbing_api.service.service_interface;

import dam.pepehc.saecio_climbing_api.dto.AperturistaDto;
import dam.pepehc.saecio_climbing_api.dto.NuevoAperturistaDto;
import dam.pepehc.saecio_climbing_api.resource.AperturistaResource;

/**
 * La interfaz Aperturista service.
 */
public interface AperturistaService {
    /**
     * Nuevo aperturista aperturista resource.
     *
     * @param nuevoAperturistaDto el nuevo aperturista dto
     * @return el aperturista resource
     */
    public AperturistaResource nuevoAperturista(final NuevoAperturistaDto nuevoAperturistaDto);

    /**
     * Leer aperturista aperturista resource.
     *
     * @param idAperturista el id aperturista
     * @return el aperturista resource
     */
    public AperturistaResource leerAperturista(final Long idAperturista);

    /**
     * Modificar aperturista aperturista resource.
     *
     * @param aperturistaDto el aperturista dto
     * @param idAperturista  el id aperturista
     * @return el aperturista resource
     */
    public AperturistaResource modificarAperturista(final AperturistaDto aperturistaDto, final Long idAperturista);

    /**
     * Borrar aperturista string.
     *
     * @param idAperturista el id aperturista
     * @return el string
     */
    public String borrarAperturista(final Long idAperturista);
}
