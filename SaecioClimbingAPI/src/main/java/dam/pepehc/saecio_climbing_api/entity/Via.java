package dam.pepehc.saecio_climbing_api.entity;

import dam.pepehc.saecio_climbing_api.enums.TipoDeEscalada;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.util.List;

import static jakarta.persistence.EnumType.STRING;

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
    private String nombre;
    private String grado;
    private String metros;
    private String numeroChapas;
    private String fechaApertura;
    private String fechaUltimaRevision;
    private String descripcion;
    
    @Enumerated(STRING)
    private TipoDeEscalada tipoDeEscalada;
    
    private File foto;
    
    @ManyToMany(mappedBy = "vias")
    private List<Aperturista> aperturistas;

    @OneToMany(mappedBy = "via", cascade = CascadeType.ALL)
    private List<Ascension> ascensiones;
}
