package dam.pepehc.SaecioClimbingAPI.assembler;

import dam.pepehc.SaecioClimbingAPI.dto.SierraDto;
import dam.pepehc.SaecioClimbingAPI.entity.Sierra;
import dam.pepehc.SaecioClimbingAPI.resource.SierraResource;
import org.springframework.stereotype.Component;

@Component
public class SierraAssembler {
    
    public Sierra sierraDtoASierra(final SierraDto sierraDto) {
        return Sierra.builder().build();
    }
    
    public SierraResource sierraASierraResource(final Sierra sierra) {
        return SierraResource.builder().build();
    }
    
    public Sierra sierraModificadaASierra(final SierraDto sierraDto, final Sierra sierra) {
        return Sierra.builder().build();
    }
}
