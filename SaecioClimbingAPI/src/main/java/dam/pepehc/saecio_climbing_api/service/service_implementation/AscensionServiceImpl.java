package dam.pepehc.saecio_climbing_api.service.service_implementation;

import dam.pepehc.saecio_climbing_api.assembler.AscensionAssembler;
import dam.pepehc.saecio_climbing_api.dto.AscensionDto;
import dam.pepehc.saecio_climbing_api.entity.Ascension;
import dam.pepehc.saecio_climbing_api.repository.AscensionRepository;
import dam.pepehc.saecio_climbing_api.resource.AscensionResource;
import dam.pepehc.saecio_climbing_api.service.service_interface.AscensionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * El tipo Ascension service.
 */
@Slf4j
@Component
public class AscensionServiceImpl implements AscensionService {

    @Autowired
    private AscensionAssembler ascensionAssembler;

    @Autowired
    private AscensionRepository ascensionRepository;

    @Override
    public AscensionResource nuevaAscension(final AscensionDto ascensionDto) {
        log.info("[AscensionService]-[nuevaAscension]-[ascensionDto: {}]-[Start]", ascensionDto);
        Ascension ascension = ascensionAssembler.ascensionDtoAAscension(ascensionDto);
        ascensionRepository.save(ascension);
        log.info("[AscensionService]-[nuevaAscension]-[ascensionResource: {}]-[End]",
                ascensionAssembler.ascensionAAscensionResource(ascension));

        return ascensionAssembler.ascensionAAscensionResource(ascension);
    }

    @Override
    public AscensionResource leerAscension(final Long idAscension) {
        log.info("[AscensionService]-[leerAscension]-[idAscension: {}]-[Start]", idAscension);
        Ascension ascension = ascensionRepository.findById(idAscension)
                .orElseThrow(() -> new RuntimeException());
        log.info("[AscensionService]-[leerAscension]-[ascensionResource: {}]-[End]",
                ascensionAssembler.ascensionAAscensionResource(ascension));

        return ascensionAssembler.ascensionAAscensionResource(ascension);
    }
    
    @Override
    public List<AscensionResource> leerAscensionesPorIdUsuario(final Long idUsuario) {
        log.info("[AscensionController]-[leerAscensionesPorIdUsuario]-[idUsuario: {}]-[Start]", idUsuario);
        List<Ascension> ascensiones = ascensionRepository.encontrarAscensionesPorIdUsuario(idUsuario);
        List<AscensionResource> ascensionesResource = new ArrayList<>();
        
        for (Ascension a : ascensiones) {
            ascensionesResource.add(ascensionAssembler.ascensionAAscensionResource(a));
        }
        
        log.info("[AscensionController]-[leerAscensionesPorIdUsuario]-[ascensionesResource: {}]-[End]",
                ascensionesResource);
        
        return ascensionesResource;
    }

    @Override
    public AscensionResource modificarAscension(final AscensionDto ascensionDto, final Long idAscension) {
        log.info("[AscensionService]-[modificarAscension]-[ascensionDto: {}, idAscension: {}]-[Start]", ascensionDto,
                idAscension);
        Ascension ascension = ascensionRepository.findById(idAscension)
                .orElseThrow(() -> new RuntimeException());
        Ascension ascensionModificada = ascensionAssembler.ascensionModificadaAAscension(ascensionDto, ascension);
        ascensionRepository.save(ascensionModificada);
        log.info("[AscensionService]-[modificarAscension]-[ascensionResource: {}]-[End]",
                ascensionAssembler.ascensionAAscensionResource(ascensionModificada));

        return ascensionAssembler.ascensionAAscensionResource(ascensionModificada);
    }

    @Override
    public String borrarAscension(final Long idAscension) {
        log.info("[AscensionService]-[borrarAscension]-[idAscension: {}]-[Start]", idAscension);
        ascensionRepository.deleteById(idAscension);
        String mensaje = "Ascensión " + idAscension + " eliminada correctamente de la base de datos";
        log.info("[AscensionService]-[borrarAscension]-[mensaje: {}]-[End]", mensaje);
        
        return mensaje;
    }
}
