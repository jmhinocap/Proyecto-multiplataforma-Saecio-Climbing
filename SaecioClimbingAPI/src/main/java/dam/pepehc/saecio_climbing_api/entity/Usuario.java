package dam.pepehc.saecio_climbing_api.entity;

import jakarta.persistence.*;
import lombok.*;

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

    private Long idDatosPersona;
    private String correoElectronico;
    private String nombreUsuario;
    private String contrasena;
    
    @OneToMany(mappedBy = "usuario",
            cascade = CascadeType.ALL)
    private List<Ascension> ascensiones;
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "roles_usuario",
        joinColumns = @JoinColumn(name = "id_usuario"),
        inverseJoinColumns = @JoinColumn(name = "id_rol", referencedColumnName = "idRol"))
    private List<Rol> roles;
}
