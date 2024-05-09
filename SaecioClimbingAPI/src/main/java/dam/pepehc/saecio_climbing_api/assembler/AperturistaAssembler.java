package dam.pepehc.SaecioClimbingAPI.assembler;

import dam.pepehc.SaecioClimbingAPI.dto.AperturistaDto;
import dam.pepehc.SaecioClimbingAPI.entity.Aperturista;
import dam.pepehc.SaecioClimbingAPI.resource.AperturistaResource;
import org.springframework.stereotype.Component;

@Component
public class AperturistaAssembler {
    
    public Aperturista aparturistaDtoAAperturista(final AperturistaDto aperturistaDto) {
        return Aperturista.builder().build();
    }
    
    public AperturistaResource aperturistaAAperturistaResource(final Aperturista aperturista) {
        return AperturistaResource.builder().build();
    }
    
    public Aperturista aperturistaModificadoAAperturista (final AperturistaDto aperturistaDto,
                                                          final Aperturista aperturista) {
        return Aperturista.builder().build();
    }
}
