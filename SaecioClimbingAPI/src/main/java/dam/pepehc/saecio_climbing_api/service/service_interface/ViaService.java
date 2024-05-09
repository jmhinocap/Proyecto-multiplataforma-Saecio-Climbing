package dam.pepehc.saecio_climbing_api.service.service_interface;

import dam.pepehc.saecio_climbing_api.dto.NuevaViaDto;
import dam.pepehc.saecio_climbing_api.dto.ViaDto;
import dam.pepehc.saecio_climbing_api.resource.ViaResource;

import java.util.List;

public interface ViaService {
    public ViaResource nuevaVia(final NuevaViaDto nuevaViaDto);
    public ViaResource leerVia(final Long idVia);
    public ViaResource modificarVia(final ViaDto viaDto, final Long idVia);
    public String borrarVia(final Long idVia);
    public List<ViaResource> leerUltimas5Vias();
    public List<ViaResource> leerViasPorIdSector(final Long idSector);
}
