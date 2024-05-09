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
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    
    @Id
    @GeneratedValue
    private Long idUsuario;
    
    private DatosPersona datosPersona;
    private String correoElectronico;
    private String contrasena;
    
    @OneToMany(mappedBy = "primarykey.usuario",
            cascade = CascadeType.ALL)
    private List<Ascension> ascensiones;
}
