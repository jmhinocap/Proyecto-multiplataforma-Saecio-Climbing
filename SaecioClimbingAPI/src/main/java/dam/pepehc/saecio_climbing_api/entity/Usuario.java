package dam.pepehc.saecio_climbing_api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * Un usuario para la página web
 */
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idUsuario;

    private Long idDatosPersona;
    private String correoElectronico;
    private String nombreUsuario;
    private String contrasena;

    @ToString.Exclude
    @JsonIgnore
    @OneToMany(mappedBy = "usuario",
            cascade = CascadeType.ALL)
    private List<Ascension> ascensiones;
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "roles_usuario",
        joinColumns = @JoinColumn(name = "id_usuario"),
        inverseJoinColumns = @JoinColumn(name = "id_rol", referencedColumnName = "idRol"))
    private List<Rol> roles;

    @ToString.Exclude
    @JsonIgnore
    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private TokenVerificacion tokenVerificacion;
    
    @Column(name = "activado")
    private boolean activado;
}
