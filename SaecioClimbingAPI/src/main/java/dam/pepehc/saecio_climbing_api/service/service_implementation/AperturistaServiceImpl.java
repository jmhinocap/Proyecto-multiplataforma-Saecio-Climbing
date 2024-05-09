package dam.pepehc.SaecioClimbingAPI.service.service_implementation;

import dam.pepehc.SaecioClimbingAPI.assembler.AperturistaAssembler;
import dam.pepehc.SaecioClimbingAPI.dto.AperturistaDto;
import dam.pepehc.SaecioClimbingAPI.entity.Aperturista;
import dam.pepehc.SaecioClimbingAPI.repository.AperturistaRepository;
import dam.pepehc.SaecioClimbingAPI.resource.AperturistaResource;
import dam.pepehc.SaecioClimbingAPI.service.service_interface.AperturistaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AperturistaServiceImpl implements AperturistaService {
    
    @Autowired
    private AperturistaAssembler aperturistaAssembler;
    
    @Autowired
    private AperturistaRepository aperturistaRepository;
    
    @Override
    public AperturistaResource nuevoAperturista(AperturistaDto aperturistaDto) {
        log.info("[AperturistaService]-[nuevoAperturista]-[aperturistaDto: {}]-[Start]", aperturistaDto);
        Aperturista aperturista = aperturistaAssembler.aparturistaDtoAAperturista(aperturistaDto);
        aperturistaRepository.save(aperturista);
        log.info("[AperturistaService]-[nuevoAperturista]-[bancaResource: {}]-[End]",
                aperturistaAssembler.aperturistaAAperturistaResource(aperturista));
        
        return aperturistaAssembler.aperturistaAAperturistaResource(aperturista);
    }

    @Override
    public AperturistaResource leerAperturista(Long idAperturista) {
        log.info("[AperturistaService]-[leerAperturista]-[idAperturista: {}]-[Start]", idAperturista);
        Aperturista aperturista = aperturistaRepository.findById(idAperturista)
                .orElseThrow(() -> new RuntimeException());
        log.info("[AperturistaService]-[leerAperturista]-[aperturistaResource: {}]-[End]",
                aperturistaAssembler.aperturistaAAperturistaResource(aperturista));
        
        return aperturistaAssembler.aperturistaAAperturistaResource(aperturista);
    }

    @Override
    public AperturistaResource modificarAperturista(AperturistaDto aperturistaDto, Long idAperturista) {
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
    public String eliminarAperturista(Long idAperturista) {
        log.info("[AperturistaService]-[eliminarAperturista]-[idAperturista: {}]-[Start]", idAperturista);
        aperturistaRepository.deleteById(idAperturista);
        String mensaje = "Aperturista eliminado correctamente de la base de datos";
        log.info("[AperturistaService]-[eliminarAperturista]-[mensaje: {}]-[End]", mensaje);
        
        return mensaje;
    }
}
