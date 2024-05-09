package dam.pepehc.SaecioClimbingAPI.entity;

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
public class Zona {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idZona;
    
    private String nombre;
    private String coordenadas;
    private File foto;
    
    @ManyToOne
    private List<Sector> sectores;
}
