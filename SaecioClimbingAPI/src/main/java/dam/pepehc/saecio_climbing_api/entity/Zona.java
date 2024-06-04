package dam.pepehc.saecio_climbing_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

/**
 * El tipo Zona.
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Zona {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idZona;
    
    private Long idSierra;
    private String nombre;
    
    @Column(columnDefinition = "MEDIUMTEXT")
    private String coordenadas;
    private String foto;
    
    @ElementCollection
    private List<String> tiposDeEscalada;
    
    @OneToMany(cascade = CascadeType.ALL)
    private List<Sector> sectores;
}
