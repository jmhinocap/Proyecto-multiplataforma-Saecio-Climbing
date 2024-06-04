package dam.pepehc.saecio_climbing_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Las vías son los caminos escalables en una pared o sector. Tienen distintas dificultades y se le aplican uno o varios
 * tipos de escalada. Pueden disponer o no de chapas.
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Via {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVia;
    
    private Long idSector;
    private String numeroDeCroquis;
    private String nombre;
    private String grado;
    private String metros;
    private String numeroChapas;
    private String fechaApertura;
    private String fechaUltimaRevision;
    private String descripcion;
    
    private String tipoDeEscalada;
    
    private String foto;
    
    @ManyToMany(mappedBy = "vias")
    private List<Aperturista> aperturistas;

    @OneToMany(mappedBy = "via", cascade = CascadeType.ALL)
    private List<Ascension> ascensiones;
}
