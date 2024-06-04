package dam.pepehc.saecio_climbing_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Una Sierra representa una cadena montañosa dentro de la provincia, la cuál agrupa distintas Zonas donde se puede
 * escalar.
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Sierra {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSierra;
    
    private String nombre;
    
    @Column(columnDefinition = "MEDIUMTEXT")
    private String coordenadas;
    private String foto;
    
    @OneToMany(cascade = CascadeType.ALL)
    private List<Zona> zonas;
}
