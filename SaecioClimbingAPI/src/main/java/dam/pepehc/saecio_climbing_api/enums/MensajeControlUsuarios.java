package dam.pepehc.saecio_climbing_api.enums;

/**
 * El enumerado Mensaje control usuarios.
 */
public enum MensajeControlUsuarios {
    /**
     * El Usuario en uso.
     */
    USUARIO_EN_USO("userEnUso"),
    /**
     * El Correo en uso.
     */
    CORREO_EN_USO("emailEnUso"),
    /**
     * El Usuario registrado.
     */
    USUARIO_REGISTRADO("registroCorrecto");

    /**
     * El Mensaje.
     */
    public final String mensaje;
    
    private MensajeControlUsuarios(String mensaje) {
        this.mensaje = mensaje;
    }
}
