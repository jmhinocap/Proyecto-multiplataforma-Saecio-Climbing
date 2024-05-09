package dam.pepehc.SaecioClimbingAPI.service.service_interface;

import dam.pepehc.SaecioClimbingAPI.dto.ZonaDto;
import dam.pepehc.SaecioClimbingAPI.resource.ZonaResource;

public interface ZonaService {
    public ZonaResource nuevaZona(final ZonaDto zonaDto);
    public ZonaResource leerZona(final Long idZona);
    public ZonaResource modificarZona(final ZonaDto zonaDto, final Long idZona);
    public String eliminarZona(final Long idZona);
}
