package dam.pepehc.saecio_climbing_api.service.service_interface;

import dam.pepehc.saecio_climbing_api.dto.NuevaSierraDto;
import dam.pepehc.saecio_climbing_api.dto.SierraDto;
import dam.pepehc.saecio_climbing_api.entity.Zona;
import dam.pepehc.saecio_climbing_api.resource.SierraResource;

import java.util.List;

/**
 * La interfaz Sierra service.
 */
public interface SierraService {
    /**
     * Nueva sierra sierra resource.
     *
     * @param nuevaSierraDto el nueva sierra dto
     * @return el sierra resource
     */
    public SierraResource nuevaSierra(final NuevaSierraDto nuevaSierraDto);

    /**
     * Leer sierra sierra resource.
     *
     * @param idSierra el id sierra
     * @return el sierra resource
     */
    public SierraResource leerSierra(final Long idSierra);

    /**
     * Modificar sierra sierra resource.
     *
     * @param sierraDto el sierra dto
     * @param idSierra  el id sierra
     * @return el sierra resource
     */
    public SierraResource modificarSierra(final SierraDto sierraDto, final Long idSierra);

    /**
     * Borrar sierra string.
     *
     * @param idSierra el id sierra
     * @return el string
     */
    public String borrarSierra(final Long idSierra);

    /**
     * Leer todas las sierras list.
     *
     * @return el list
     */
    public List<SierraResource> leerTodasLasSierras();

    /**
     * Leer nombre sierra string.
     *
     * @param idSierra el id sierra
     * @return el string
     */
    public String leerNombreSierra(final Long idSierra);

    /**
     * Anadir nueva zona.
     *
     * @param zona el zona
     */
    public void anadirNuevaZona(final Zona zona);

    /**
     * Eliminar zona string.
     *
     * @param zona el zona
     * @return el string
     */
    public String eliminarZona(final Zona zona);
}
