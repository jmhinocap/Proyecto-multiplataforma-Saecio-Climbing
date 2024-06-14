package dam.pepehc.saecio_climbing_api.controller;

import dam.pepehc.saecio_climbing_api.command.auth_command.AutentificarUsuarioCommand;
import dam.pepehc.saecio_climbing_api.command.auth_command.RegistrarUsuarioCommand;
import dam.pepehc.saecio_climbing_api.dto.IniciarSesionDto;
import dam.pepehc.saecio_climbing_api.dto.RegistrarseDto;
import dam.pepehc.saecio_climbing_api.enums.MensajeControlUsuarios;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static dam.pepehc.saecio_climbing_api.enums.MensajeControlUsuarios.CORREO_EN_USO;
import static dam.pepehc.saecio_climbing_api.enums.MensajeControlUsuarios.USUARIO_EN_USO;

/**
 * El tipo Auth controller.
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AuthController {
    
    @Autowired
    private BeanFactory beanFactory;

    /**
     * Autentificar usuario.
     *
     * @param iniciarSesionDto valores para confirmar que el incio de sesión puede efectuarse
     * @return respuesta positiva de la cabecera HTTP
     */
    @PostMapping("/iniciar-sesion")
    public ResponseEntity<String> autentificarUsuario(@RequestBody final IniciarSesionDto iniciarSesionDto) {
        log.info("[AuthController]-[autentificarUsuario]-[iniciarSesionDto: {}]-[Start]", iniciarSesionDto);
        AutentificarUsuarioCommand autentificarUsuarioCommand = beanFactory
                .getBean(AutentificarUsuarioCommand.class, iniciarSesionDto);
        String mensaje = autentificarUsuarioCommand.execute();
        log.info("[AuthController]-[autentificarUsuario]-[mensaje: {}]-[End]", mensaje);
        
        return ResponseEntity.ok(mensaje);
    }

    /**
     * Registrar usuario.
     *
     * @param registrarseDto valores para confirmar que el registro puede efectuarse
     * @return respuesta de la cabecera HTTP, puede ser positiva o negativa
     */
    @PostMapping("/registrar-usuario")
    public ResponseEntity<String> registrarUsuario(@RequestBody final RegistrarseDto registrarseDto) {
        log.info("[AuthController]-[registrarUsuario]-[registrarseDto: {}]-[Start]", registrarseDto);
        RegistrarUsuarioCommand registrarUsuarioCommand = beanFactory.getBean(RegistrarUsuarioCommand.class,
                registrarseDto);
        MensajeControlUsuarios mensajeControlUsuarios = registrarUsuarioCommand.execute();
        log.info("[AuthController]-[registrarUsuario]-[mensaje: {}]-[End]", mensajeControlUsuarios.mensaje);
        
        if (mensajeControlUsuarios == USUARIO_EN_USO || mensajeControlUsuarios == CORREO_EN_USO)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensajeControlUsuarios.mensaje);
        else
            System.out.println(ResponseEntity.ok(mensajeControlUsuarios.mensaje));
            return ResponseEntity.ok(mensajeControlUsuarios.mensaje);
    }
}
