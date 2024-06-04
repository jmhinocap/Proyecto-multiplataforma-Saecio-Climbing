package dam.pepehc.saecio_climbing_api.service.service_implementation;

import dam.pepehc.saecio_climbing_api.assembler.ViaAssembler;
import dam.pepehc.saecio_climbing_api.dto.NuevaViaDto;
import dam.pepehc.saecio_climbing_api.dto.ViaDto;
import dam.pepehc.saecio_climbing_api.entity.Via;
import dam.pepehc.saecio_climbing_api.repository.ViaRepository;
import dam.pepehc.saecio_climbing_api.resource.ViaResource;
import dam.pepehc.saecio_climbing_api.service.service_interface.SectorService;
import dam.pepehc.saecio_climbing_api.service.service_interface.ViaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * El tipo Via service.
 */
@Slf4j
@Service
public class ViaServiceImpl implements ViaService {
    
    @Autowired
    private SectorService sectorService;
    
    @Autowired
    private ViaAssembler viaAssembler;
    
    @Autowired
    private ViaRepository viaRepository;
    
    @Override
    public ViaResource nuevaVia(final NuevaViaDto nuevaViaDto) {
        log.info("[ViaService]-[nuevaVia]-[nuevaViaDto: {}]-[Start]", nuevaViaDto);
        Via via = viaAssembler.nuevaViaDtoAVia(nuevaViaDto);
        sectorService.anadirNuevaVia(via);
        log.info("[ViaService]-[nuevaVia]-[viaResource: {}]-[End]", viaAssembler.viaAViaResource(via));
        
        return viaAssembler.viaAViaResource(via);
    }

    @Override
    public ViaResource leerVia(final Long idVia) {
        log.info("[ViaService]-[leerVia]-[idVia: {}]-[Start]", idVia);
        Via via = viaRepository.findById(idVia).orElseThrow(() -> new RuntimeException());
        log.info("[ViaService]-[leerVia]-[viaResource: {}]-[End]", viaAssembler.viaAViaResource(via));
        
        return viaAssembler.viaAViaResource(via);
    }

    @Override
    public ViaResource modificarVia(final ViaDto viaDto, final Long idVia) {
        log.info("[ViaService]-[modificarVia]-[viaDto: {}, idVia: {}]", viaDto, idVia);
        Via via = viaRepository.findById(idVia).orElseThrow(() -> new RuntimeException());
        Via viaModificada = viaAssembler.viaModificadaAVia(viaDto, via);
        log.info("[ViaService]-[modificarVia]-[viaResource: {}]-[End]", viaAssembler.viaAViaResource(viaModificada));
        
        return null;
    }

    @Override
    public String borrarVia(final Long idVia) {
        log.info("[ViaService]-[eliminarVia]-[idVia: {}]-[Start]", idVia);
        Via via = viaRepository.findById(idVia).orElseThrow(RuntimeException::new);
        String mensaje = sectorService.eliminarVia(via);
        log.info("[ViaService]-[eliminarVia]-[mensaje: {}]-[End]", mensaje);
        
        return mensaje;
    }

    @Override
    public List<ViaResource> leerUltimas5Vias() {
        log.info("[ViaService]-[leerUltimasEntradas]-[Start]");
        List<Via> vias = viaRepository.encontrarUltimasEntradas();
        List<ViaResource> viasResource = new ArrayList<>();

        for (Via v : vias) {
            viasResource.add(viaAssembler.viaAViaResource(v));
        }

        log.info("[ViaService]-[leerUltimasEntradas]-[viasResource: {}]-[End]", viasResource);

        return viasResource;
    }
    
    @Override
    public List<ViaResource> leerViasPorIdSector(final Long idSector) {
        log.info("[ViaService]-[leerViasPorSector]-[idSector: {}]-[Start]", idSector);
        List<Via> vias = viaRepository.encontrarViasPorIdSector(idSector);
        List<ViaResource> viasResource = new ArrayList<>();

        for (Via v : vias) {
            viasResource.add(viaAssembler.viaAViaResource(v));
        }

        log.info("[ViaService]-[leerViasPorSector]-[viasResource: {}]-[End]", viasResource);

        return viasResource;
    }
}
