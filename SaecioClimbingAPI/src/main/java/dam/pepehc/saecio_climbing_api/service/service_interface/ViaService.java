package dam.pepehc.SaecioClimbingAPI.service.service_interface;

import dam.pepehc.SaecioClimbingAPI.dto.NuevaViaDto;
import dam.pepehc.SaecioClimbingAPI.dto.ViaDto;
import dam.pepehc.SaecioClimbingAPI.resource.ViaResource;

public interface ViaService {
    public ViaResource nuevaVia(final NuevaViaDto nuevaViaDto);
    public ViaResource leerVia(final Long idVia);
    public ViaResource modificarVia(final ViaDto viaDto, final Long idVia);
    public String eliminarVia(final Long idVia);
}
