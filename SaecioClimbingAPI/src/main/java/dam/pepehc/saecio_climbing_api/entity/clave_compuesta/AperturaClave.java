package dam.pepehc.SaecioClimbingAPI.entity.clave_compuesta;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class AperturaClave implements Serializable {
    
    @Column(name = "id_aperturista")
    private Long idAperturista;
    
    @Column(name = "id_via")
    private Long idVia;
}
