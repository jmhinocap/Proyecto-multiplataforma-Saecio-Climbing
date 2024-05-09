package dam.pepehc.saecio_climbing_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.util.List;

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
    private String coordenadas;
    private File croquis;
    private File foto;
    
    @OneToMany(cascade = CascadeType.ALL)
    private List<Via> vias;
}
