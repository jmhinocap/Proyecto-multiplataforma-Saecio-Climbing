package dam.pepehc.saecio_climbing_api.enums;

/**
 * El enumerado Roles.
 */
public enum Roles {
    /**
     * Rol admin roles.
     */
    ROL_ADMIN("ROL_ADMIN"),
    /**
     * Rol usuario roles.
     */
    ROL_USUARIO("ROL_USUARIO");

    /**
     * El Nombre rol.
     */
    public final String nombreRol;
    
    private Roles(String nombreRol) {
        this.nombreRol = nombreRol;
    }
}
