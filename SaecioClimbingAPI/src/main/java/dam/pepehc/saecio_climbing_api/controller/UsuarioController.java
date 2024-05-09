package dam.pepehc.saecio_climbing_api.controller;

import dam.pepehc.saecio_climbing_api.command.usuario_command.BorrarUsuarioCommand;
import dam.pepehc.saecio_climbing_api.command.usuario_command.LeerUsuarioCommand;
import dam.pepehc.saecio_climbing_api.command.usuario_command.ModificarUsuarioCommand;
import dam.pepehc.saecio_climbing_api.command.usuario_command.NuevoUsuarioCommand;
import dam.pepehc.saecio_climbing_api.dto.NuevoUsuarioDto;
import dam.pepehc.saecio_climbing_api.dto.UsuarioDto;
import dam.pepehc.saecio_climbing_api.resource.UsuarioResource;
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
@RequestMapping("/api/usuario")
public class UsuarioController {
    
    @Autowired
    private BeanFactory beanFactory;
    
    @PostMapping("/nuevo-usuario")
    public ResponseEntity<UsuarioResource> nuevoUsuario(@Valid @RequestBody final NuevoUsuarioDto nuevoUsuarioDto) {
        log.info("[UsuarioController]-[nuevoUsuario]-[nuevoUsuarioDto: {}]-[Start]", nuevoUsuarioDto);
        NuevoUsuarioCommand nuevoUsuarioCommand = beanFactory.getBean(NuevoUsuarioCommand.class, nuevoUsuarioDto);
        UsuarioResource usuarioResource = nuevoUsuarioCommand.execute();
        log.info("[UsuarioController]-[nuevoUsuario]-[usuarioResource: {}]-[End]", usuarioResource);
        
        return ResponseEntity.ok(usuarioResource);
    }
    
    @GetMapping("/leer-usuario/{idUsuario}")
    public ResponseEntity<UsuarioResource> leerUsuario(@PathVariable("idUsuario") final Long idUsuario) {
        log.info("[UsuarioController]-[leerUsuario]-[idUsuario: {}]-[Start]", idUsuario);
        LeerUsuarioCommand leerUsuarioCommand = beanFactory.getBean(LeerUsuarioCommand.class, idUsuario);
        UsuarioResource usuarioResource = leerUsuarioCommand.execute();
        log.info("[UsuarioController]-[leerUsuario]-[usuarioResource: {}]-[End]", usuarioResource);
        
        return ResponseEntity.ok(usuarioResource);
    }
    
    @PutMapping("/modificar-usuario/{idUsuario}")
    public ResponseEntity<UsuarioResource> modificarUsuario(@Valid @RequestBody final UsuarioDto usuarioDto,
                                                             @PathVariable("idUsuario") final Long idUsuario) {
        log.info("[UsuarioController]-[modificarUsuario]-[usuarioDto: {}, idUsuario: {}]-[Start]", usuarioDto,
                idUsuario);
        ModificarUsuarioCommand modificarUsuarioCommand = beanFactory.getBean(ModificarUsuarioCommand.class,
                usuarioDto, idUsuario);
        UsuarioResource usuarioResource = modificarUsuarioCommand.execute();
        log.info("[UsuarioController]-[modificarUsuario]-[usuarioResource: {}]-[End]", usuarioResource);
        
        return ResponseEntity.ok(usuarioResource);
    }
    
    @DeleteMapping("/borrar-usuario/{idUsuario}")
    public ResponseEntity<String> borrarUsuario(@PathVariable("idUsuario") final Long idUsuario) {
        log.info("[UsuarioController]-[borrarUsuario]-[idUsuario: {}]-[Start]", idUsuario);
        BorrarUsuarioCommand borrarUsuarioCommand = beanFactory.getBean(BorrarUsuarioCommand.class, idUsuario);
        String mensaje = borrarUsuarioCommand.execute();
        log.info("[UsuarioController]-[borrarUsuario]-[mensaje: {}]-[End]", mensaje);
        
        return ResponseEntity.ok(mensaje);
    }
}
