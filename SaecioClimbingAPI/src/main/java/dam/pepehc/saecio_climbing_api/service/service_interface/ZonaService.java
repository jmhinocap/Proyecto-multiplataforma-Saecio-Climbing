package dam.pepehc.saecio_climbing_api.service.service_interface;

import dam.pepehc.saecio_climbing_api.dto.NuevaZonaDto;
import dam.pepehc.saecio_climbing_api.dto.ZonaDto;
import dam.pepehc.saecio_climbing_api.entity.Sector;
import dam.pepehc.saecio_climbing_api.resource.ZonaResource;

import java.util.List;

/**
 * La interfaz Zona service.
 */
public interface ZonaService {
    /**
     * Nueva zona zona resource.
     *
     * @param nuevaZonaDto el nueva zona dto
     * @return el zona resource
     */
    public ZonaResource nuevaZona(final NuevaZonaDto nuevaZonaDto);

    /**
     * Leer zona zona resource.
     *
     * @param idZona el id zona
     * @return el zona resource
     */
    public ZonaResource leerZona(final Long idZona);

    /**
     * Leer zonas list
     * 
     * @return la lista
     */
    public List<ZonaResource> leerZonas();

    /**
     * Modificar zona zona resource.
     *
     * @param zonaDto el zona dto
     * @param idZona  el id zona
     * @return el zona resource
     */
    public ZonaResource modificarZona(final ZonaDto zonaDto, final Long idZona);

    /**
     * Borrar zona string.
     *
     * @param idZona el id zona
     * @return el string
     */
    public String borrarZona(final Long idZona);

    /**
     * Anadir nuevo sector.
     *
     * @param sector el sector
     */
    public void anadirNuevoSector(final Sector sector);

    /**
     * Eliminar sector string.
     *
     * @param sector el sector
     * @return el string
     */
    public String eliminarSector(final Sector sector);

    /**
     * Leer zonas por id sierra list.
     *
     * @param idSierra el id sierra
     * @return el list
     */
    public List<ZonaResource> leerZonasPorIdSierra(final Long idSierra);

    /**
     * Leer nombre zona string.
     *
     * @param idZona el id zona
     * @return el string
     */
    public String leerNombreZona(final Long idZona);
}
