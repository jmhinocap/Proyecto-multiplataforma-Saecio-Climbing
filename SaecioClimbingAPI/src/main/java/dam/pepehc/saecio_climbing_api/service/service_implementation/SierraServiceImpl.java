package dam.pepehc.saecio_climbing_api.service.service_implementation;

import dam.pepehc.saecio_climbing_api.assembler.SierraAssembler;
import dam.pepehc.saecio_climbing_api.dto.NuevaSierraDto;
import dam.pepehc.saecio_climbing_api.dto.SierraDto;
import dam.pepehc.saecio_climbing_api.entity.Sierra;
import dam.pepehc.saecio_climbing_api.entity.Zona;
import dam.pepehc.saecio_climbing_api.repository.SierraRepository;
import dam.pepehc.saecio_climbing_api.resource.SierraResource;
import dam.pepehc.saecio_climbing_api.service.service_interface.SierraService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * El tipo Sierra service.
 */
@Slf4j
@Service
public class SierraServiceImpl implements SierraService {
    
    @Autowired
    private SierraAssembler sierraAssembler;
    
    @Autowired
    private SierraRepository sierraRepository;
    
    @Override
    public SierraResource nuevaSierra(final NuevaSierraDto nuevaSierraDto) {
        log.info("[SierraService]-[nuevaSierra]-[nuevaSierraDto: {}]-[Start]", nuevaSierraDto);
        Sierra sierra = sierraAssembler.sierraDtoASierra(nuevaSierraDto);
        sierraRepository.save(sierra);
        log.info("[SierraService]-[nuevaSierra]-[sierraResource: {}]-[End]", 
                sierraAssembler.sierraASierraResource(sierra));
        
        return sierraAssembler.sierraASierraResource(sierra);
    }

    @Override
    public SierraResource leerSierra(final Long idSierra) {
        log.info("[SierraService]-[leerSierra]-[idSierra: {}]-[Start]", idSierra);
        Sierra sierra = sierraRepository.findById(idSierra)
                .orElseThrow(() -> new RuntimeException());
        log.info("[SierraService]-[leerSierra]-[sierraResource: {}]-[End]", 
                sierraAssembler.sierraASierraResource(sierra));
        
        return sierraAssembler.sierraASierraResource(sierra);
    }

    @Override
    public SierraResource modificarSierra(final SierraDto sierraDto, final Long idSierra) {
        log.info("[SierraService]-[modificarSierra]-[sierraDto: {}, idSierra: {}]", sierraDto, idSierra);
        Sierra sierra = sierraRepository.findById(idSierra)
                .orElseThrow(() -> new RuntimeException());
        Sierra sierraModificada = sierraAssembler.sierraModificadaASierra(sierraDto, sierra);
        log.info("[SierraService]-[modificarSierra]-[sierraResource: {}]-[End]", 
                sierraAssembler.sierraASierraResource(sierraModificada));
        
        return sierraAssembler.sierraASierraResource(sierraModificada);
    }

    @Override
    public String borrarSierra(final Long idSierra) {
        log.info("[SierraService]-[eliminarSierra]-[idSierra: {}]-[Start]", idSierra);
        sierraRepository.deleteById(idSierra);
        String mensaje = "Sierra " + idSierra + " eliminada correctamente de la base de datos";
        log.info("[SierraService]-[eliminarSierra]-[mensaje: {}]-[End]", mensaje);
        
        return mensaje;
    }
    
    @Override
    public List<SierraResource> leerTodasLasSierras() {
        log.info("[SierraService]-[leerTodasLasSierras]-[Start]");
        List<Sierra> sierras = sierraRepository.findAll();
        List<SierraResource> sierrasResource = new ArrayList<>();
        
        for (Sierra s : sierras) {
            sierrasResource.add(sierraAssembler.sierraASierraResource(s));
        }
        
        log.info("[SierraService]-[leerTodasLasSierras]-[sierrasResource: {}]-[End]", sierrasResource);
        
        return sierrasResource;
    }
    
    @Override
    public String leerNombreSierra(final Long idSierra) {
        log.info("[SierraService]-[leerNombreSierra]-[idSierra: {}]-[Start]", idSierra);
        String nombreSierra = sierraRepository.encontrarNombrePorIdSierra(idSierra);
        log.info("[SierraService]-[leerNombreSierra]-[nombreSierra: {}]-[End]", nombreSierra);
        
        return nombreSierra;
    }
    
    @Override
    public void anadirNuevaZona(final Zona zona) {
        log.info("[SierraService]-[anadirNuevaZona]-[zona: {}]-[Start]", zona);
        Sierra sierra = sierraRepository.findById(zona.getIdSierra()).orElseThrow(RuntimeException::new);
        sierra.getZonas().add(zona);
        sierraRepository.save(sierra);
        log.info("[SierraService]-[anadirNuevaZona]-[End]");
    }
    
    @Override
    public String eliminarZona(final Zona zona) {
        log.info("[SierraService]-[eliminarZona]-[zona: {}]-[Start]", zona);
        Sierra sierra = sierraRepository.findById(zona.getIdSierra()).orElseThrow(RuntimeException::new);
        sierra.getZonas().remove(zona);
        sierraRepository.save(sierra);
        String mensaje = "Zona " + zona.getIdZona() + " eliminada correctamente";
        log.info("[SierraService]-[eliminarZona]-[mesnaje: {}]-[End]", mensaje);
        
        return mensaje;
    }
}
