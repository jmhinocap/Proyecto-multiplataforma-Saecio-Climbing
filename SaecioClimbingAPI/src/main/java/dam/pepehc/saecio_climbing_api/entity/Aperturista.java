package dam.pepehc.saecio_climbing_api.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Aperturista {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAperturista;
    
    private Long idDatosPersona;
    
    @ManyToMany
    @JoinTable(name = "vias_abiertas",
            joinColumns = @JoinColumn(name = "id_aperturista"),
            inverseJoinColumns = @JoinColumn(name = "id_via"))   
    private List<Via> vias;
}
