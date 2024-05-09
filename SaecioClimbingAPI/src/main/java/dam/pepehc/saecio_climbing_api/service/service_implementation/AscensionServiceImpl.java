package dam.pepehc.SaecioClimbingAPI.service.service_implementation;

import dam.pepehc.SaecioClimbingAPI.assembler.AscensionAssembler;
import dam.pepehc.SaecioClimbingAPI.dto.AscensionDto;
import dam.pepehc.SaecioClimbingAPI.entity.Ascension;
import dam.pepehc.SaecioClimbingAPI.repository.AscensionRepository;
import dam.pepehc.SaecioClimbingAPI.resource.AscensionResource;
import dam.pepehc.SaecioClimbingAPI.service.service_interface.AscensionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AscensionServiceImpl implements AscensionService {

    @Autowired
    private AscensionAssembler ascensionAssembler;

    @Autowired
    private AscensionRepository ascensionRepository;

    @Override
    public AscensionResource nuevaAscension(AscensionDto ascensionDto) {
        log.info("[AscensionService]-[nuevaAscension]-[ascensionDto: {}]-[Start]", ascensionDto);
        Ascension ascension = ascensionAssembler.ascensionDtoAAscension(ascensionDto);
        ascensionRepository.save(ascension);
        log.info("[AscensionService]-[nuevaAscension]-[ascensionResource: {}]-[End]",
                ascensionAssembler.ascensionAAscensionResource(ascension));

        return ascensionAssembler.ascensionAAscensionResource(ascension);
    }

    @Override
    public AscensionResource leerAscension(Long idAscension) {
        log.info("[AscensionService]-[leerAscension]-[idAscension: {}]-[Start]", idAscension);
        Ascension ascension = ascensionRepository.findById(idAscension)
                .orElseThrow(() -> new RuntimeException());
        log.info("[AscensionService]-[leerAscension]-[ascensionResource: {}]-[End]",
                ascensionAssembler.ascensionAAscensionResource(ascension));

        return ascensionAssembler.ascensionAAscensionResource(ascension);
    }

    @Override
    public AscensionResource modificarAscension(AscensionDto ascensionDto, Long idAscension) {
        log.info("[AscensionService]-[modificarAscension]-[ascensionDto: {}, idAscension: {}]-[Start]", ascensionDto,
                idAscension);
        Ascension ascension = ascensionRepository.findById(idAscension)
                .orElseThrow(() -> new RuntimeException());
        Ascension ascensionModificada = ascensionAssembler.ascensionModificadaAAscension(ascensionDto, ascension);
        log.info("[AscensionService]-[modificarAscension]-[ascensionResource: {}]-[End]",
                ascensionAssembler.ascensionAAscensionResource(ascensionModificada));

        return ascensionAssembler.ascensionAAscensionResource(ascensionModificada);
    }

    @Override
    public String borrarAscension(Long idAscension) {
        log.info("[AscensionService]-[borrarAscension]-[idAscension: {}]-[Start]", idAscension);
        ascensionRepository.deleteById(idAscension);
        String mensaje = "Ascensión " + idAscension + " eliminada correctamente de la base de datos";
        log.info("[AscensionService]-[borrarAscension]-[mensaje: {}]-[End]", mensaje);
        
        return mensaje;
    }
}
