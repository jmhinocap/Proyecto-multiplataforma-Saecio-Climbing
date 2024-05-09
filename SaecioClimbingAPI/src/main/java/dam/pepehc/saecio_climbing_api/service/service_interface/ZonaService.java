package dam.pepehc.saecio_climbing_api.service.service_interface;

import dam.pepehc.saecio_climbing_api.dto.NuevaZonaDto;
import dam.pepehc.saecio_climbing_api.dto.NuevoSectorDto;
import dam.pepehc.saecio_climbing_api.dto.ZonaDto;
import dam.pepehc.saecio_climbing_api.entity.Sector;
import dam.pepehc.saecio_climbing_api.entity.Zona;
import dam.pepehc.saecio_climbing_api.resource.ZonaResource;

import java.util.List;

public interface ZonaService {
    public ZonaResource nuevaZona(final NuevaZonaDto nuevaZonaDto);
    public ZonaResource leerZona(final Long idZona);
    public ZonaResource modificarZona(final ZonaDto zonaDto, final Long idZona);
    public String borrarZona(final Long idZona);
    public void anadirNuevoSector(final Sector sector);
    public List<ZonaResource> leerZonasPorIdSierra(final Long idSierra);
}
