package dam.pepehc.SaecioClimbingAPI.assembler;

import dam.pepehc.SaecioClimbingAPI.dto.ZonaDto;
import dam.pepehc.SaecioClimbingAPI.entity.Zona;
import dam.pepehc.SaecioClimbingAPI.resource.ZonaResource;
import org.springframework.stereotype.Component;

@Component
public class ZonaAssembler {
    
    public Zona zonaDtoAZona(final ZonaDto zonaDto) {
        return Zona.builder().build();
    }
    
    public ZonaResource zonaAZonaResource(final Zona zona) {
        return ZonaResource.builder().build();
    }
    
    public Zona zonaModificadaAZona(final ZonaDto zonaDto, final Zona zona) {
        return Zona.builder().build();
    }
}
