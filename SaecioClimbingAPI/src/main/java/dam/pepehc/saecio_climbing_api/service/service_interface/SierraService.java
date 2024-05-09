package dam.pepehc.saecio_climbing_api.service.service_interface;

import dam.pepehc.saecio_climbing_api.dto.NuevaSierraDto;
import dam.pepehc.saecio_climbing_api.dto.SierraDto;
import dam.pepehc.saecio_climbing_api.entity.Zona;
import dam.pepehc.saecio_climbing_api.resource.SierraResource;

public interface SierraService {
    public SierraResource nuevaSierra(final NuevaSierraDto nuevaSierraDto);
    public SierraResource leerSierra(final Long idSierra);
    public SierraResource modificarSierra(final SierraDto sierraDto, final Long idSierra);
    public String borrarSierra(final Long idSierra);
    public void anadirNuevaZona(final Zona zona);
}
