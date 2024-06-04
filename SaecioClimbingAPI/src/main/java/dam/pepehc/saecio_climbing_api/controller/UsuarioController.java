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

/**
 * El tipo Usuario controller.
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
    
    @Autowired
    private BeanFactory beanFactory;

    /**
     * Nuevo usuario.
     *
     * @param nuevoUsuarioDto el usuario que se añade a la base de datos
     * @return respuesta positiva de la cabecera HTTP
     */
    @PostMapping("/nuevo-usuario")
    public ResponseEntity<UsuarioResource> nuevoUsuario(@Valid @RequestBody final NuevoUsuarioDto nuevoUsuarioDto) {
        log.info("[UsuarioController]-[nuevoUsuario]-[nuevoUsuarioDto: {}]-[Start]", nuevoUsuarioDto);
        NuevoUsuarioCommand nuevoUsuarioCommand = beanFactory.getBean(NuevoUsuarioCommand.class, nuevoUsuarioDto);
        UsuarioResource usuarioResource = nuevoUsuarioCommand.execute();
        log.info("[UsuarioController]-[nuevoUsuario]-[usuarioResource: {}]-[End]", usuarioResource);
        
        return ResponseEntity.ok(usuarioResource);
    }

    /**
     * Leer usuario.
     *
     * @param idUsuario el id usuario
     * @return respuesta positiva de la cabecera HTTP
     */
    @GetMapping("/leer-usuario/{idUsuario}")
    public ResponseEntity<UsuarioResource> leerUsuario(@PathVariable("idUsuario") final Long idUsuario) {
        log.info("[UsuarioController]-[leerUsuario]-[idUsuario: {}]-[Start]", idUsuario);
        LeerUsuarioCommand leerUsuarioCommand = beanFactory.getBean(LeerUsuarioCommand.class, idUsuario);
        UsuarioResource usuarioResource = leerUsuarioCommand.execute();
        log.info("[UsuarioController]-[leerUsuario]-[usuarioResource: {}]-[End]", usuarioResource);
        
        return ResponseEntity.ok(usuarioResource);
    }

    /**
     * Modificar usuario.
     *
     * @param usuarioDto el usuario que se modifica
     * @param idUsuario  el id usuario
     * @return respuesta positiva de la cabecera HTTP
     */
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

    /**
     * Borrar usuario.
     *
     * @param idUsuario el id usuario
     * @return respuesta positiva de la cabecera HTTP
     */
    @DeleteMapping("/borrar-usuario/{idUsuario}")
    public ResponseEntity<String> borrarUsuario(@PathVariable("idUsuario") final Long idUsuario) {
        log.info("[UsuarioController]-[borrarUsuario]-[idUsuario: {}]-[Start]", idUsuario);
        BorrarUsuarioCommand borrarUsuarioCommand = beanFactory.getBean(BorrarUsuarioCommand.class, idUsuario);
        String mensaje = borrarUsuarioCommand.execute();
        log.info("[UsuarioController]-[borrarUsuario]-[mensaje: {}]-[End]", mensaje);
        
        return ResponseEntity.ok(mensaje);
    }
}
