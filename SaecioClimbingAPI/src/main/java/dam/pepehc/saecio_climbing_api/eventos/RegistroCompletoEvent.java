package dam.pepehc.saecio_climbing_api.eventos;

import dam.pepehc.saecio_climbing_api.entity.Usuario;
import org.springframework.context.ApplicationEvent;

import java.util.Locale;

/**
 * El tipo Registro completo event.
 */
public class RegistroCompletoEvent extends ApplicationEvent {

    private String appUrl;
    private Locale locale;
    private Usuario usuario;

    /**
     * Instancia un nuevo Registro completo event.
     *
     * @param appUrl  el app url
     * @param locale  el locale
     * @param usuario el usuario
     */
    public RegistroCompletoEvent(String appUrl, Locale locale, Usuario usuario) {
        super(usuario);
        
        this.appUrl = appUrl;
        this.locale = locale;
        this.usuario = usuario;
    }

    /**
     * Consigue app url.
     *
     * @return el app url
     */
    public String getAppUrl() {
        return appUrl;
    }

    /**
     * Consigue locale.
     *
     * @return el locale
     */
    public Locale getLocale() {
        return locale;
    }

    /**
     * Consigue usuario.
     *
     * @return el usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Asigna app url.
     *
     * @param appUrl el app url
     */
    public void setAppUrl(String appUrl) {
        this.appUrl = appUrl;
    }

    /**
     * Asigna locale.
     *
     * @param locale el locale
     */
    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    /**
     * Asigna usuario.
     *
     * @param usuario el usuario
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
