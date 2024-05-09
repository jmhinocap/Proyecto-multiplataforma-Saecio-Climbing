package dam.pepehc.saecio_climbing_api.controller;

import dam.pepehc.saecio_climbing_api.command.aperturista_command.BorrarAperturistaCommand;
import dam.pepehc.saecio_climbing_api.command.aperturista_command.LeerAperturistaCommand;
import dam.pepehc.saecio_climbing_api.command.aperturista_command.ModificarAperturistaCommand;
import dam.pepehc.saecio_climbing_api.command.aperturista_command.NuevoAperturistaCommand;
import dam.pepehc.saecio_climbing_api.dto.AperturistaDto;
import dam.pepehc.saecio_climbing_api.dto.NuevoAperturistaDto;
import dam.pepehc.saecio_climbing_api.repository.AperturistaRepository;
import dam.pepehc.saecio_climbing_api.resource.AperturistaResource;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Validated
@RestController
@RequestMapping("/api/aperturista")
public class AperturistaController {
    
    @Autowired
    private BeanFactory beanFactory;
    
    @PostMapping("/nuevo-aperturista")
    public ResponseEntity<AperturistaResource> nuevoAperturista(
            @Valid @RequestBody final NuevoAperturistaDto nuevoAperturistaDto) {
        log.info("[AperturistaController]-[nuevoAperturista]-[nuevoAperturistaDto: {}]-[Start]", nuevoAperturistaDto);
        NuevoAperturistaCommand nuevoAperturistaCommand = beanFactory.getBean(NuevoAperturistaCommand.class,
                nuevoAperturistaDto);
        AperturistaResource aperturistaResource = nuevoAperturistaCommand.execute();
        log.info("[AperturistaController]-[nuevoAperturista]-[aperturistaResource: {}]-[End]", aperturistaResource);
        
        return ResponseEntity.ok(aperturistaResource);
    }
    
    @GetMapping("/leer-aperturista/{idAperturista}")
    public ResponseEntity<AperturistaResource> leerAperturista(
            @PathVariable("idAperturista") final Long idAperturista) {
        log.info("[AperturistaController]-[leerAperturista]-[idAperturista: {}]-[Start]", idAperturista);
        LeerAperturistaCommand leerAperturistaCommand = beanFactory.getBean(LeerAperturistaCommand.class,
                idAperturista);
        AperturistaResource aperturistaResource = leerAperturistaCommand.execute();
        log.info("[AperturistaController]-[leerAperturista]-[aperturistaResource: {}]-[End]", aperturistaResource);
        
        return ResponseEntity.ok(aperturistaResource);
    }
    
    @PutMapping("/modificar-aperturista/{idAperturista}")
    public ResponseEntity<AperturistaResource> modificarAperturista(
            @Valid @RequestBody final AperturistaDto aperturistaDto,
            @PathVariable("idAperturista") final Long idAperturista) {
        log.info("[AperturistaController]-[modificarAperturista]-[aperturistaDto: {}, idAperturista: {}]-[Start]",
                aperturistaDto, idAperturista);
        ModificarAperturistaCommand modificarAperturistaCommand = beanFactory.getBean(ModificarAperturistaCommand.class,
                aperturistaDto, idAperturista);
        AperturistaResource aperturistaResource = modificarAperturistaCommand.execute();
        log.info("[AperturistaController]-[modificarAperturista]-[aperturistaResource: {}]-[End]", aperturistaResource);
        
        return ResponseEntity.ok(aperturistaResource);
    }
    
    @DeleteMapping("/borrar-aperturista/{idAperturista}")
    public ResponseEntity<String> borrarAperturista(@PathVariable("idAperturista") final Long idAperturista) {
        log.info("[AperturistaController]-[borrarAperturista]-[idAperturista: {}]-[Start]", idAperturista);
        BorrarAperturistaCommand borrarAperturistaCommand = beanFactory.getBean(BorrarAperturistaCommand.class,
                idAperturista);
        String mensaje = borrarAperturistaCommand.execute();
        log.info("[AperturistaController]-[borrarAperturista]-[mensaje: {}]-[End]", mensaje);
        
        return ResponseEntity.ok(mensaje);
    }
}
