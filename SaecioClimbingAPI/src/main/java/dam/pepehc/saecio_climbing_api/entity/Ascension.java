package dam.pepehc.SaecioClimbingAPI.entity;

import dam.pepehc.SaecioClimbingAPI.entity.clave_compuesta.AscensionClave;
import dam.pepehc.SaecioClimbingAPI.enums.TipoDeAscension;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ascension {
    
    @EmbeddedId
    private AscensionClave idAscension;
    
    @ManyToOne
    @MapsId("idUsuario")
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    
    @ManyToOne
    @MapsId("idVia")
    @JoinColumn(name = "id_via")
    private Via via;
    
    private String fechaAscension;
    private TipoDeAscension tipoDeAscension;
}
