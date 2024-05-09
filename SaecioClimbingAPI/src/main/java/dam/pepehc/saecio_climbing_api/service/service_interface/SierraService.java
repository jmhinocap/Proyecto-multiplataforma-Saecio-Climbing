package dam.pepehc.SaecioClimbingAPI.service.service_interface;

import dam.pepehc.SaecioClimbingAPI.dto.SierraDto;
import dam.pepehc.SaecioClimbingAPI.resource.SectorResource;
import dam.pepehc.SaecioClimbingAPI.resource.SierraResource;

public interface SierraService {
    public SierraResource nuevaSierra(final SierraDto sierraDto);
    public SierraResource leerSierra(final Long idSierra);
    public SierraResource modificarSierra(final SierraDto sierraDto, final Long idSierra);
    public String eliminarSierra(final Long idSierra);
}
