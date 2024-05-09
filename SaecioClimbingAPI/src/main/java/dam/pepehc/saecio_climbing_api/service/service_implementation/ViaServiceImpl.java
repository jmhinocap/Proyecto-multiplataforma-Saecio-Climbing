package dam.pepehc.SaecioClimbingAPI.service.service_implementation;

import dam.pepehc.SaecioClimbingAPI.dto.NuevaViaDto;
import dam.pepehc.SaecioClimbingAPI.dto.ViaDto;
import dam.pepehc.SaecioClimbingAPI.resource.ViaResource;
import dam.pepehc.SaecioClimbingAPI.service.service_interface.ViaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ViaServiceImpl implements ViaService {
    @Override
    public ViaResource nuevaVia(NuevaViaDto nuevaViaDto) {
        return null;
    }

    @Override
    public ViaResource leerVia(Long idVia) {
        return null;
    }

    @Override
    public ViaResource modificarVia(ViaDto viaDto, Long idVia) {
        return null;
    }

    @Override
    public String eliminarVia(Long idVia) {
        return "";
    }
}
