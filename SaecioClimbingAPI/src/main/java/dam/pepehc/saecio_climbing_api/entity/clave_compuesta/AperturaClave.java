package dam.pepehc.saecio_climbing_api.entity.clave_compuesta;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

/**
 * El tipo Apertura clave.
 */
@Embeddable
public class AperturaClave implements Serializable {
    
    @Column(name = "id_aperturista")
    private Long idAperturista;
    
    @Column(name = "id_via")
    private Long idVia;
}
