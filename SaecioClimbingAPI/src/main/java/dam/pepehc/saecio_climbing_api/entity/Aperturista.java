package dam.pepehc.saecio_climbing_api.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * La entidad Aperturista representa a personas con una serie de atributos comunes que realizan el trabajo de abrir y
 * equipar vías de escalada en la vida real. Su información, esta es nombre, apellidos y una foto, se muestra en la
 * página web.
 */
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
