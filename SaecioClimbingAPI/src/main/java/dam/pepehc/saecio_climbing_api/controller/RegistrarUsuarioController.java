package dam.pepehc.saecio_climbing_api.controller;

import dam.pepehc.saecio_climbing_api.assembler.DatosPersonaAssembler;
import dam.pepehc.saecio_climbing_api.assembler.UsuarioAssembler;
import dam.pepehc.saecio_climbing_api.dto.NuevoUsuarioDto;
import dam.pepehc.saecio_climbing_api.dto.RegistrarseDto;
import dam.pepehc.saecio_climbing_api.entity.DatosPersona;
import dam.pepehc.saecio_climbing_api.entity.TokenVerificacion;
import dam.pepehc.saecio_climbing_api.entity.Usuario;
import dam.pepehc.saecio_climbing_api.eventos.RegistroCompletoEvent;
import dam.pepehc.saecio_climbing_api.repository.RolRepository;
import dam.pepehc.saecio_climbing_api.resource.UsuarioResource;
import dam.pepehc.saecio_climbing_api.service.service_interface.UsuarioService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;

/**
 * El tipo Registrar usuario controller.
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/api/registrar-usuario")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RegistrarUsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
    private RolRepository rolRepository;
    
    @Autowired
    private UsuarioAssembler usuarioAssembler;
    
    @Autowired
    private DatosPersonaAssembler datosPersonaAssembler;
    
    @Autowired
    private ApplicationEventPublisher eventPublisher;

    /**
     * Registrar cuenta usuario.
     *
     * @param registrarseDto los valores para registrar una cuenta
     * @param request        
     * @return 
     */
    @PostMapping("/registracion")
    public ResponseEntity<Usuario> registrarCuentaUsuario(@RequestBody @Valid final RegistrarseDto registrarseDto,
                                                          final HttpServletRequest request) {
        log.info("[RegistrarUsuarioController]-[registrarCuentaUsuario]-[registrarseDto: {}, request: {}]-[Start]",
                registrarseDto, request);
        // Refactor este troncho a RegistrarUsuarioService. Mamma mia...
        DatosPersona datosPersona = datosPersonaAssembler.registrarseDtoADatosPersona(registrarseDto);
        NuevoUsuarioDto nuevoUsuarioDto = usuarioAssembler.registrarseDtoANuevoUsuarioDto(registrarseDto,
                datosPersona.getIdDatosPersona());
        UsuarioResource usuarioResource = usuarioService.nuevoUsuario(nuevoUsuarioDto);
        Usuario registrado = usuarioAssembler.usuarioResourceAUsuario(usuarioResource);
        try {
            RegistroCompletoEvent evento = new RegistroCompletoEvent(request.getContextPath(), request.getLocale(), 
                    registrado);
            eventPublisher.publishEvent(evento);
        } catch (RuntimeException ex) {
            System.err.println(ex);
            return ResponseEntity.badRequest().body(registrado);
        }

        log.info("[RegistrarUsuarioController]-[registrarCuentaUsuario]-[registrado: {}]-[End]", registrado);

        return ResponseEntity.ok(registrado);
    }

    /**
     * Confirmación de registro.
     *
     * @param model 
     * @param token el token de verificación
     * @return redirecciones a distintas partes de la página según el tipo de respuesta
     */
    @GetMapping("/confirmacion-de-registro")
    public ResponseEntity<String> confirmacionRegistro(final Model model, @RequestParam("token") final String token) {
        log.info("[RegistrarUsuarioController]-[confirmacionRegistro]-[model: {}, token: {}]-[Start]", model, token);
        HttpHeaders headers = new HttpHeaders();
        TokenVerificacion tokenVerificacion = usuarioService.conseguirTokenVerificacion(token);
        if (tokenVerificacion == null) {
            headers.add("Location", "/badUser.html");
            return new ResponseEntity<String>(headers, HttpStatus.BAD_REQUEST); // TODO badUser.html o similar
        }
        
        Usuario usuario = tokenVerificacion.getUsuario();
        Calendar cal = Calendar.getInstance();
        if ((tokenVerificacion.getFechaCaducidad().getTime() - cal.getTime().getTime()) <= 0) {
            headers.add("Location", "/badUser.html");
            return new ResponseEntity<String>(headers, HttpStatus.BAD_REQUEST);
        }
        
        usuario.setActivado(true);
        usuarioService.guardarUsuarioRegistrado(usuario);
        String url = "/index.html";
        headers.add("index", url);
        log.info("[RegistrarUsuarioController]-[confirmacionRegistro]-[url: {}]-[End]", url);
        return new ResponseEntity<String>(headers, HttpStatus.OK);
    }
}
