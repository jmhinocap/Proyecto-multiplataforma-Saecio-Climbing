package dam.pepehc.saecio_climbing_api.service.service_interface;

import dam.pepehc.saecio_climbing_api.dto.AscensionDto;
import dam.pepehc.saecio_climbing_api.resource.AscensionResource;

public interface AscensionService {
    public AscensionResource nuevaAscension(final AscensionDto ascensionDto);
    public AscensionResource leerAscension(final Long idAscension);
    public AscensionResource modificarAscension(final AscensionDto ascensionDto, final Long idAscension);
    public String borrarAscension(final Long idAscension);
}
