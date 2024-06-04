package dam.pepehc.saecio_climbing_api.enums;

/**
 * El enumerado Tipo de escalada.
 */
public enum TipoDeEscalada {
    /**
     * Boulder tipo de escalada.
     */
    BOULDER(1),
    /**
     * Clásica tipo de escalada.
     */
    CLASICA(2),
    /**
     * Deportiva tipo de escalada.
     */
    DEPORTIVA(3);

    /**
     * Elección.
     */
    public final int eleccion;
    
    private TipoDeEscalada(int eleccion) {
        this.eleccion = eleccion;
    }
}
