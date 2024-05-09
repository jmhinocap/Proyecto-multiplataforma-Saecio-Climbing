package dam.pepehc.SaecioClimbingAPI.service.service_implementation;

import dam.pepehc.SaecioClimbingAPI.dto.ZonaDto;
import dam.pepehc.SaecioClimbingAPI.resource.ZonaResource;
import dam.pepehc.SaecioClimbingAPI.service.service_interface.ZonaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ZonaServiceImpl implements ZonaService {
    @Override
    public ZonaResource nuevaZona(ZonaDto zonaDto) {
        return null;
    }

    @Override
    public ZonaResource leerZona(Long idZona) {
        return null;
    }

    @Override
    public ZonaResource modificarZona(ZonaDto zonaDto, Long idZona) {
        return null;
    }

    @Override
    public String eliminarZona(Long idZona) {
        return "";
    }
}
