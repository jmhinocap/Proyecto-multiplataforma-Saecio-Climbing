package dam.pepehc.saecio_climbing_api.service.service_interface;

import dam.pepehc.saecio_climbing_api.dto.NuevaViaDto;
import dam.pepehc.saecio_climbing_api.dto.ViaDto;
import dam.pepehc.saecio_climbing_api.resource.ViaResource;

import java.util.List;

/**
 * La interfaz Via service.
 */
public interface ViaService {
    /**
     * Nueva via via resource.
     *
     * @param nuevaViaDto el nueva via dto
     * @return el via resource
     */
    public ViaResource nuevaVia(final NuevaViaDto nuevaViaDto);

    /**
     * Leer via via resource.
     *
     * @param idVia el id via
     * @return el via resource
     */
    public ViaResource leerVia(final Long idVia);

    /**
     * Modificar via via resource.
     *
     * @param viaDto el via dto
     * @param idVia  el id via
     * @return el via resource
     */
    public ViaResource modificarVia(final ViaDto viaDto, final Long idVia);

    /**
     * Borrar via string.
     *
     * @param idVia el id via
     * @return el string
     */
    public String borrarVia(final Long idVia);

    /**
     * Leer ultimas 5 vias list.
     *
     * @return el list
     */
    public List<ViaResource> leerUltimas5Vias();

    /**
     * Leer vias por id sector list.
     *
     * @param idSector el id sector
     * @return el list
     */
    public List<ViaResource> leerViasPorIdSector(final Long idSector);
}
