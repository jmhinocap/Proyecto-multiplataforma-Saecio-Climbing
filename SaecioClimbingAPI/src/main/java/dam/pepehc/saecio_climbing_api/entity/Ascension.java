package dam.pepehc.saecio_climbing_api.entity;

import dam.pepehc.saecio_climbing_api.entity.clave_compuesta.AscensionClave;
import dam.pepehc.saecio_climbing_api.enums.TipoDeAscension;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.EnumType.STRING;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ascension {
    
    @Id
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
    
    @Enumerated(STRING)
    private TipoDeAscension tipoDeAscension;
}
