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
public class Via {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVia;
    
    private String nombre;
    private String grado;
    private String metros;
    private String numeroChapas;
    private String fechaApertura;
    private String fechaUltimaRevision;
    private String descripcion;
    private File foto;
    
    @OneToMany(mappedBy = "primarykey.via",
            cascade = CascadeType.ALL)
    private List<Ascension> ascensiones;
    
    @OneToMany(mappedBy = "primarykey.via", 
            cascade = CascadeType.ALL)
    private List<Apertura> aperturas;
}
