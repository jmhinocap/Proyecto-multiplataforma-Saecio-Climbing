package dam.pepehc.saecio_climbing_api.enums;

/**
 * El enumerado Tipo de ascensión.
 */
public enum TipoDeAscension {
    /**
     * Punto rojo tipo de ascensión.
     */
    PUNTO_ROJO("Punto rojo"),
    /**
     * Flash tipo de ascensión.
     */
    FLASH("Flash"),
    /**
     * A vista tipo de ascensión.
     */
    A_VISTA("A vista"),
    /**
     * Terminada en primero tipo de ascensión
     */
    TERMINADA_PRIMERO("Terminada de primero"),
    /**
     * Top rope tipo de ascensión.
     */
    TOP_ROPE("En top-rope"),
    /**
     * Intento tipo de ascensión.
     */
    INTENTO("Intento"),
    /**
     * Proyecto tipo de ascensión.
     */
    PROYECTO("Proyecto"),
    /**
     * Otro tipo de ascensión.
     */
    OTRO("Otro");
    
    private String tipo;
    
    private TipoDeAscension(String tipo) {
        this.tipo = tipo;
    }
    
    public String getTipo() {
        return tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    @Override
    public String toString() {
        return tipo;
    }
}
