package dam.pepehc.saecio_climbing_api.entity;

import dam.pepehc.saecio_climbing_api.enums.TipoDeEscalada;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.util.List;

/**
 * Un Sector es un área dentro de una Zona que agrupa una o más Vías. Cuenta con un croquis que se muestra en la página
 * web así como con coordenadas que enseñan dónde se encuentra este área.
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Sector {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSector;
    
    private Long idZona;
    private String nombre;
    
    @Column(columnDefinition = "MEDIUMTEXT")
    private String coordenadas;
    
    private String croquis;
    private String foto;
    
    @ElementCollection
    private List<String> tiposDeEscalada;
    
    @OneToMany(cascade = CascadeType.ALL)
    private List<Via> vias;
}
