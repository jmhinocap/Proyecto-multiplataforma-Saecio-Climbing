package dam.pepehc.saecio_climbing_api.service.service_implementation;

import dam.pepehc.saecio_climbing_api.assembler.AperturistaAssembler;
import dam.pepehc.saecio_climbing_api.dto.AperturistaDto;
import dam.pepehc.saecio_climbing_api.dto.NuevoAperturistaDto;
import dam.pepehc.saecio_climbing_api.entity.Aperturista;
import dam.pepehc.saecio_climbing_api.repository.AperturistaRepository;
import dam.pepehc.saecio_climbing_api.resource.AperturistaResource;
import dam.pepehc.saecio_climbing_api.service.service_interface.AperturistaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * El tipo Aperturista service.
 */
@Slf4j
@Service
public class AperturistaServiceImpl implements AperturistaService {
    
    @Autowired
    private AperturistaAssembler aperturistaAssembler;
    
    @Autowired
    private AperturistaRepository aperturistaRepository;
    
    @Override
    public AperturistaResource nuevoAperturista(final NuevoAperturistaDto nuevoAperturistaDto) {
        log.info("[AperturistaService]-[nuevoAperturista]-[nuevoAperturistaDto: {}]-[Start]", nuevoAperturistaDto);
        Aperturista aperturista = aperturistaAssembler.aperturistaDtoAAperturista(nuevoAperturistaDto);
        aperturistaRepository.save(aperturista);
        log.info("[AperturistaService]-[nuevoAperturista]-[bancaResource: {}]-[End]",
                aperturistaAssembler.aperturistaAAperturistaResource(aperturista));
        
        return aperturistaAssembler.aperturistaAAperturistaResource(aperturista);
    }

    @Override
    public AperturistaResource leerAperturista(final Long idAperturista) {
        log.info("[AperturistaService]-[leerAperturista]-[idAperturista: {}]-[Start]", idAperturista);
        Aperturista aperturista = aperturistaRepository.findById(idAperturista)
                .orElseThrow(() -> new RuntimeException());
        log.info("[AperturistaService]-[leerAperturista]-[aperturistaResource: {}]-[End]",
                aperturistaAssembler.aperturistaAAperturistaResource(aperturista));
        
        return aperturistaAssembler.aperturistaAAperturistaResource(aperturista);
    }

    @Override
    public AperturistaResource modificarAperturista(final AperturistaDto aperturistaDto, final Long idAperturista) {
        log.info("[AperturistaService]-[modificarAperturista]-[aperturistaDto: {}. idAperturista: {}]-[Start]",
                aperturistaDto, idAperturista);
        Aperturista aperturista = aperturistaRepository.findById(idAperturista)
                .orElseThrow(() -> new RuntimeException());
        Aperturista aperturistaModificado = aperturistaAssembler.aperturistaModificadoAAperturista(aperturistaDto,
                aperturista);
        aperturistaRepository.save(aperturistaModificado);
        log.info("[AperturistaService]-[modificarAperturista]-[aperturistaResource: {}]-[End]", 
                aperturistaAssembler.aperturistaAAperturistaResource(aperturistaModificado));
        
        return aperturistaAssembler.aperturistaAAperturistaResource(aperturistaModificado);
    }

    @Override
    public String borrarAperturista(final Long idAperturista) {
        log.info("[AperturistaService]-[eliminarAperturista]-[idAperturista: {}]-[Start]", idAperturista);
        aperturistaRepository.deleteById(idAperturista);
        String mensaje = "Aperturista " + idAperturista + " correctamente de la base de datos";
        log.info("[AperturistaService]-[eliminarAperturista]-[mensaje: {}]-[End]", mensaje);
        
        return mensaje;
    }
}
