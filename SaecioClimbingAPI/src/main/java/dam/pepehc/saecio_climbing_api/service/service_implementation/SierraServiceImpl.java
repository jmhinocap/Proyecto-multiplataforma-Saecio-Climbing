package dam.pepehc.SaecioClimbingAPI.service.service_implementation;

import dam.pepehc.SaecioClimbingAPI.dto.SierraDto;
import dam.pepehc.SaecioClimbingAPI.resource.SierraResource;
import dam.pepehc.SaecioClimbingAPI.service.service_interface.SierraService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SierraServiceImpl implements SierraService {
    @Override
    public SierraResource nuevaSierra(SierraDto sierraDto) {
        return null;
    }

    @Override
    public SierraResource leerSierra(Long idSierra) {
        return null;
    }

    @Override
    public SierraResource modificarSierra(SierraDto sierraDto, Long idSierra) {
        return null;
    }

    @Override
    public String eliminarSierra(Long idSierra) {
        return "";
    }
}
