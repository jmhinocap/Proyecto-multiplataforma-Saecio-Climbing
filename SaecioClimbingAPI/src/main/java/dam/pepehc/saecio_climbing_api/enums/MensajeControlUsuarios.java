package dam.pepehc.saecio_climbing_api.enums;

public enum MensajeControlUsuarios {
    USUARIO_EN_USO("El nombre de usuario ya está en uso"),
    CORREO_EN_USO("Ya existe una cuenta que usa este correo"),
    USUARIO_REGISTRADO("Usuario registrado correctamente");
    
    public final String mensaje;
    
    private MensajeControlUsuarios(String mensaje) {
        this.mensaje = mensaje;
    }
}
