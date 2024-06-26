package dam.pepehc.saecio_climbing_api.service.service_implementation;

import dam.pepehc.saecio_climbing_api.assembler.ZonaAssembler;
import dam.pepehc.saecio_climbing_api.dto.NuevaZonaDto;
import dam.pepehc.saecio_climbing_api.dto.ZonaDto;
import dam.pepehc.saecio_climbing_api.entity.Sector;
import dam.pepehc.saecio_climbing_api.entity.Zona;
import dam.pepehc.saecio_climbing_api.repository.ZonaRepository;
import dam.pepehc.saecio_climbing_api.resource.ZonaResource;
import dam.pepehc.saecio_climbing_api.service.service_interface.SierraService;
import dam.pepehc.saecio_climbing_api.service.service_interface.ZonaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * El tipo Zona service.
 */
@Slf4j
@Service
public class ZonaServiceImpl implements ZonaService {
    
    @Autowired
    private SierraService sierraService;
    
    @Autowired
    private ZonaAssembler zonaAssembler;
    
    @Autowired
    private ZonaRepository zonaRepository;
    
    @Override
    public ZonaResource nuevaZona(final NuevaZonaDto nuevaZonaDto) {
        log.info("[ZonaService]-[nuevaZona]-[nuevaZonaDto: {}]-[Start]", nuevaZonaDto);
        Zona zona = zonaAssembler.zonaDtoAZona(nuevaZonaDto);
        sierraService.anadirNuevaZona(zona);
        log.info("[ZonaService]-[nuevaZona]-[zonaResource: {}]-[End]", zonaAssembler.zonaAZonaResource(zona));
        
        return zonaAssembler.zonaAZonaResource(zona);
    }

    @Override
    public ZonaResource leerZona(final Long idZona) {
        log.info("[ZonaService]-[leerZona]-[idZona: {}]-[Start]", idZona);
        Zona zona = zonaRepository.findById(idZona).orElseThrow(RuntimeException::new);
        log.info("[ZonaService]-[leerZona]-[zonaResource: {}]-[End]", zonaAssembler.zonaAZonaResource(zona));
        
        return zonaAssembler.zonaAZonaResource(zona);
    }
    
    @Override
    public List<ZonaResource> leerZonas() {
        log.info("[ZonaService]-[leerZonas]-[Start]");
        List<Zona> zonas = zonaRepository.findAll();
        List<ZonaResource> zonasResource = new ArrayList<>();
        
        for (Zona z : zonas) {
            zonasResource.add(zonaAssembler.zonaAZonaResource(z));
        }
        
        log.info("[ZonaService]-[leerZonas]-[zonasResource: {}]-[End]", zonasResource);
        
        return zonasResource;
    }

    @Override
    public ZonaResource modificarZona(final ZonaDto zonaDto, final Long idZona) {
        log.info("[ZonaService]-[modificarZona]-[zonaDto: {}, idZona: {}]-[Start]", zonaDto, idZona);
        Zona zona = zonaRepository.findById(idZona).orElseThrow(RuntimeException::new);
        Zona zonaModificada = zonaAssembler.zonaModificadaAZona(zonaDto, zona);
        zonaRepository.save(zonaModificada);
        log.info("[ZonaService]-[modificarZona]-[zonaResource: {}]-[End]",
                zonaAssembler.zonaAZonaResource(zonaModificada));
        
        return zonaAssembler.zonaAZonaResource(zonaModificada);
    }

    @Override
    public String borrarZona(final Long idZona) {
        log.info("[ZonaService]-[eliminarZona]-[idZona: {}]-[Start]", idZona);
        Zona zona = zonaRepository.findById(idZona).orElseThrow(RuntimeException::new);
        String mensaje = sierraService.eliminarZona(zona);
        zonaRepository.deleteById(idZona);
        log.info("[ZonaService]-[eliminarZona]-[mensaje: {}]-[End]", mensaje);
        
        return mensaje;
    }
    
    @Override
    public void anadirNuevoSector(final Sector sector) {
        log.info("[ZonaService]-[anadirNuevoSector]-[sector: {}]-[Start]", sector);
        Zona zona = zonaRepository.findById(sector.getIdZona()).orElseThrow(RuntimeException::new);
        zona.getSectores().add(sector);
        zonaRepository.save(zona);
        log.info("[ZonaService]-[anadirNuevoSector]-[End]");
    }
    
    @Override
    public String eliminarSector(final Sector sector) {
        log.info("[ZonaService]-[eliminarSector]-[sector: {}]-[Start]", sector);
        Zona zona = zonaRepository.findById(sector.getIdZona()).orElseThrow(RuntimeException::new);
        zona.getSectores().remove(zona);
        zonaRepository.save(zona);
        String mensaje = "Sector " + sector.getIdSector() + " eliminado correctamente";
        log.info("[ZonaService]-[eliminarSector]-[mensaje: {}]-[End]", mensaje);
        
        return mensaje;
    }
    
    @Override
    public List<ZonaResource> leerZonasPorIdSierra(final Long idSierra) {
        log.info("[ZonaService]-[leerZonasPorIdSierra]-[idSierra: {}]-[Start]", idSierra);
        List<Zona> zonas = zonaRepository.encontrarZonasPorIdSierra(idSierra);
        List<ZonaResource> zonasResource = new ArrayList<>();
        
        for (Zona z : zonas) {
            zonasResource.add(zonaAssembler.zonaAZonaResource(z));
        }
        
        log.info("[ZonaService]-[leerZonasPorIdSierra]-[zonasResource: {}]-[End]", zonasResource);
        
        return zonasResource;
    }
    
    @Override
    public String leerNombreZona(final Long idZona) {
        log.info("[ZonaService]-[leerNombreZona]-[idZona: {}]-[Start]", idZona);
        String nombreZona = zonaRepository.encontrarNombreZona(idZona);
        log.info("[ZonaService]-[leerNombreZona]-[nombreZona: {}]-[End]", nombreZona);
        
        return nombreZona;
    }
}
