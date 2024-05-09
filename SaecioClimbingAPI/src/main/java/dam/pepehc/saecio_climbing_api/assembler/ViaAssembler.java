package dam.pepehc.SaecioClimbingAPI.assembler;

import dam.pepehc.SaecioClimbingAPI.dto.ViaDto;
import dam.pepehc.SaecioClimbingAPI.entity.Via;
import dam.pepehc.SaecioClimbingAPI.resource.ViaResource;
import org.springframework.stereotype.Component;

@Component
public class ViaAssembler {
    
    public Via viaDtoAVia(final ViaDto viaDto) {
        return Via.builder().build();
    }
    
    public ViaResource viaAViaResource(final Via via) {
        return ViaResource.builder().build();
    }
    
    public Via viaModificadaAVia(final ViaDto viaDto, final Via via) {
        return Via.builder().build();
    }
}
