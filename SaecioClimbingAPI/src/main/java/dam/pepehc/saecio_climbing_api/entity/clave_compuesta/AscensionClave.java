package dam.pepehc.SaecioClimbingAPI.entity.clave_compuesta;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class AscensionClave implements Serializable {
    
    @Column(name = "id_usuario")
    private Long idUsuario;
    
    @Column(name = "id_via")
    private Long idVia;
}
