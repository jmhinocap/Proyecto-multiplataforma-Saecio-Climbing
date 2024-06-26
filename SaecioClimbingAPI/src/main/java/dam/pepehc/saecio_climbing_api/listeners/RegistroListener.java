package dam.pepehc.saecio_climbing_api.listeners;

import dam.pepehc.saecio_climbing_api.entity.Usuario;
import dam.pepehc.saecio_climbing_api.eventos.RegistroCompletoEvent;
import dam.pepehc.saecio_climbing_api.service.service_interface.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.MessageSource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * El tipo Registro listener.
 */
@Slf4j
@Component
public class RegistroListener implements ApplicationListener<RegistroCompletoEvent> {
    
    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
    private MessageSource mensajes;
    
    @Autowired
    private JavaMailSender mailSender;
    
    @Override
    public void onApplicationEvent(RegistroCompletoEvent evento) {
        this.confirmarRegistro(evento);
    }
    
    private void confirmarRegistro(RegistroCompletoEvent evento) {
        log.info("[RegistroListener]-[confirmarRegistro]-[evento: {}]-[Start]", evento);
        Usuario usuario = evento.getUsuario();
        String token = UUID.randomUUID().toString();
        usuarioService.crearTokenVerificacion(usuario, token);
        
        String direccion = usuario.getCorreoElectronico();
        String asunto = "Confirmación de registro";
        String confirmacionUrl = evento.getAppUrl() + "/api/registrar-usuario/confirmacion-de-registro?token=" + token;
        String mensaje = mensajes.getMessage("mensaje.regLog", null, evento.getLocale());

        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(direccion);
        email.setSubject(asunto);
        email.setText(mensaje + "\r\n" + "http://localhost:8086" + confirmacionUrl);
        mailSender.send(email);
        log.info("[RegistroListener]-[confirmarRegistro]-[email: {}]-[End]", email);
    }
}
