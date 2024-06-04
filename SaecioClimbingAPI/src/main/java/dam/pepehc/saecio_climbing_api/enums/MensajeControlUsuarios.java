package dam.pepehc.saecio_climbing_api.enums;

/**
 * El enumerado Mensaje control usuarios.
 */
public enum MensajeControlUsuarios {
    /**
     * El Usuario en uso.
     */
    USUARIO_EN_USO("El nombre de usuario ya está en uso"),
    /**
     * El Correo en uso.
     */
    CORREO_EN_USO("Ya existe una cuenta que usa este correo"),
    /**
     * El Usuario registrado.
     */
    USUARIO_REGISTRADO("Usuario registrado correctamente");

    /**
     * El Mensaje.
     */
    public final String mensaje;
    
    private MensajeControlUsuarios(String mensaje) {
        this.mensaje = mensaje;
    }
}
