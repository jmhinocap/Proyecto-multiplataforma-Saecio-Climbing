package dam.pepehc.saecio_climbing_api.service.service_interface;

import dam.pepehc.saecio_climbing_api.dto.NuevoSectorDto;
import dam.pepehc.saecio_climbing_api.dto.SectorDto;
import dam.pepehc.saecio_climbing_api.entity.Via;
import dam.pepehc.saecio_climbing_api.resource.SectorResource;

import java.util.List;

/**
 * La interfaz Sector service.
 */
public interface SectorService {
    /**
     * Nuevo sector sector resource.
     *
     * @param nuevoSectorDto el nuevo sector dto
     * @return el sector resource
     */
    public SectorResource nuevoSector(final NuevoSectorDto nuevoSectorDto);

    /**
     * Leer sector sector resource.
     *
     * @param idSector el id sector
     * @return el sector resource
     */
    public SectorResource leerSector(final Long idSector);

    /**
     * Modificar sector sector resource.
     *
     * @param sectorDto el sector dto
     * @param idSector  el id sector
     * @return el sector resource
     */
    public SectorResource modificarSector(final SectorDto sectorDto, final Long idSector);

    /**
     * Borrar sector string.
     *
     * @param idSector el id sector
     * @return el string
     */
    public String borrarSector(final Long idSector);

    /**
     * Anadir nueva via.
     *
     * @param via el via
     */
    public void anadirNuevaVia(final Via via);

    /**
     * Eliminar via string.
     *
     * @param via el via
     * @return el string
     */
    public String eliminarVia(final Via via);

    /**
     * Leer sectores por id zona list.
     *
     * @param idZona el id zona
     * @return el list
     */
    public List<SectorResource> leerSectoresPorIdZona(final Long idZona);

    /**
     * Leer id zona por id sector long.
     *
     * @param idSector el id sector
     * @return el long
     */
    public Long leerIdZonaPorIdSector(final Long idSector);
}
