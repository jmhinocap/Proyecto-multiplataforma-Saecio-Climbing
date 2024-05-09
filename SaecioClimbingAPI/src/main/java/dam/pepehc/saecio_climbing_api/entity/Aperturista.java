package dam.pepehc.SaecioClimbingAPI.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Aperturista {
    
    @Id
    @GeneratedValue
    private Long idAperturista;
    
    private DatosPersona datosPersona;
    
    @OneToMany(mappedBy = "primarykey.aperturista", 
            cascade = CascadeType.ALL)
    private List<Apertura> aperturas;
}
