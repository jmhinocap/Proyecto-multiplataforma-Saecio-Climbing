package dam.pepehc.saecio_climbing_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.util.List;

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
    private String coordenadas;
    private String foto;
    
    @OneToMany(cascade = CascadeType.ALL)
    private List<Zona> zonas;
}
