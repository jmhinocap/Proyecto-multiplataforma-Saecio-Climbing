package dam.pepehc.saecio_climbing_api.entity.clave_compuesta;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

/**
 * El tipo Ascension clave.
 */
@Embeddable
public class AscensionClave implements Serializable {
    
    @Column(name = "id_usuario")
    private Long idUsuario;
    
    @Column(name = "id_via")
    private Long idVia;
}
