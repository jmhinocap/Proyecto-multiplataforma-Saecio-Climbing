package dam.pepehc.saecio_climbing_api.service.service_interface;

import dam.pepehc.saecio_climbing_api.dto.AperturistaDto;
import dam.pepehc.saecio_climbing_api.dto.NuevoAperturistaDto;
import dam.pepehc.saecio_climbing_api.resource.AperturistaResource;

public interface AperturistaService {
    public AperturistaResource nuevoAperturista(final NuevoAperturistaDto nuevoAperturistaDto);
    public AperturistaResource leerAperturista(final Long idAperturista);
    public AperturistaResource modificarAperturista(final AperturistaDto aperturistaDto, final Long idAperturista);
    public String borrarAperturista(final Long idAperturista);
}
