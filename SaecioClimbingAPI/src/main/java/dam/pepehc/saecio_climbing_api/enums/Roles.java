package dam.pepehc.saecio_climbing_api.enums;

public enum Roles {
    ROL_ADMIN("ROL_ADMIN"),
    ROL_USUARIO("ROL_USUARIO");
    
    public final String nombreRol;
    
    private Roles(String nombreRol) {
        this.nombreRol = nombreRol;
    }
}
