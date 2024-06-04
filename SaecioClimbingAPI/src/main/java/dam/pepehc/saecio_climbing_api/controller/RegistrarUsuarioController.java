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
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Calendar;

/**
 * El tipo Registrar usuario controller.
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/api/registrar-usuario")
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
    public ModelAndView registrarCuentaUsuario(@RequestBody @Valid final RegistrarseDto registrarseDto,
                                               final HttpServletRequest request) {
        log.info("[RegistrarUsuarioController]-[registrarCuentaUsuario]-[registrarseDto: {}, request: {}]-[Start]",
                registrarseDto, request);
        // Refactor este troncho a RegistrarUsuarioService. Mamma mia...
        DatosPersona datosPersona = datosPersonaAssembler.registrarseDtoADatosPersona(registrarseDto);
        NuevoUsuarioDto nuevoUsuarioDto = usuarioAssembler.registrarseDtoANuevoUsuarioDto(registrarseDto,
                datosPersona.getIdDatosPersona());
        try {
            
            UsuarioResource usuarioResource = usuarioService.nuevoUsuario(nuevoUsuarioDto);
            Usuario registrado = usuarioAssembler.usuarioResourceAUsuario(usuarioResource);
            
            String appUrl = request.getContextPath();
            eventPublisher.publishEvent(new RegistroCompletoEvent(appUrl, request.getLocale(), registrado));
        } catch (RuntimeException ex) {
            ModelAndView mav = new ModelAndView("registration", "user", nuevoUsuarioDto);
            mav.addObject("mensaje", "Una cuenta con ese correo electrónico o nombre de" +
                    "usuario ya está en uso.");
            return mav;
        }
        
        log.info("[RegistrarUsuarioController]-[registrarCuentaUsuario]-[nuevoUsuarioDto: {}]-[End]", nuevoUsuarioDto);
        
        return new ModelAndView("registroExitoso", "usuario", nuevoUsuarioDto);
    }

    /**
     * Confirmación de registro.
     *
     * @param model 
     * @param token el token de verificación
     * @return redirecciones a distintas partes de la página según el tipo de respuesta
     */
    @GetMapping("/confirmacion-de-registro")
    public String confirmacionRegistro(final Model model, @RequestParam("token") final String token) {
        log.info("[RegistrarUsuarioController]-[confirmacionRegistro]-[model: {}, token: {}]-[Start]", model, token);
        TokenVerificacion tokenVerificacion = usuarioService.conseguirTokenVerificacion(token);
        if (tokenVerificacion == null) {
            return "redirect:/badUser.html"; // TODO badUser.html o similar
        }
        
        Usuario usuario = tokenVerificacion.getUsuario();
        Calendar cal = Calendar.getInstance();
        if ((tokenVerificacion.getFechaCaducidad().getTime() - cal.getTime().getTime()) <= 0) {
            return "redirect:/badUser.html";
        }
        
        usuario.setActivado(true);
        usuarioService.guardarUsuarioRegistrado(usuario);
        String url = "redirect:/index.html";
        log.info("[RegistrarUsuarioController]-[confirmacionRegistro]-[url: {}]-[End]", url);
        return url;
    }
}
