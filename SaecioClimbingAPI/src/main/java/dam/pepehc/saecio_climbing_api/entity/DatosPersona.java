package dam.pepehc.saecio_climbing_api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DatosPersona {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDatosPersona;
    
    private String nombre;
    private String apellidos;
    private String foto;
}
