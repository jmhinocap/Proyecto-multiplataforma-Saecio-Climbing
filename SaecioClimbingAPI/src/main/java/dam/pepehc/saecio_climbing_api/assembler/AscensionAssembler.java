package dam.pepehc.SaecioClimbingAPI.assembler;

import dam.pepehc.SaecioClimbingAPI.dto.AscensionDto;
import dam.pepehc.SaecioClimbingAPI.entity.Ascension;
import dam.pepehc.SaecioClimbingAPI.resource.AscensionResource;
import org.springframework.stereotype.Component;

@Component
public class AscensionAssembler {
    
    public Ascension ascensionDtoAAscension(final AscensionDto ascensionDto) {
        return Ascension.builder().build();
    }
    
    public AscensionResource ascensionAAscensionResource(final Ascension ascension) {
        return AscensionResource.builder().build();
    }
    
    public Ascension ascensionModificadaAAscension(final AscensionDto ascensionDto, final Ascension ascension) {
        return Ascension.builder().build();
    }
}
