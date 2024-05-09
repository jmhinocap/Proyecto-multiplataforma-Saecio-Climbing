package dam.pepehc.SaecioClimbingAPI.service.service_interface;

import dam.pepehc.SaecioClimbingAPI.dto.AperturistaDto;
import dam.pepehc.SaecioClimbingAPI.entity.Aperturista;
import dam.pepehc.SaecioClimbingAPI.resource.AperturistaResource;

public interface AperturistaService {
    public AperturistaResource nuevoAperturista(final AperturistaDto aperturistaDto);
    public AperturistaResource leerAperturista(final Long idAperturista);
    public AperturistaResource modificarAperturista(final AperturistaDto aperturistaDto, final Long idAperturista);
    public String eliminarAperturista(final Long idAperturista);
}
