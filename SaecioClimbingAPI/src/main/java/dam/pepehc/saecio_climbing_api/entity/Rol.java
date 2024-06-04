package dam.pepehc.saecio_climbing_api.entity;

import dam.pepehc.saecio_climbing_api.enums.Roles;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.EnumType.STRING;

/**
 * La clase Rol es una utilidad para los Usuarios. Determina qué acciones puede y qué acciones no puede hacer un
 * Usuario.
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Rol {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRol;
    
    @Enumerated(STRING)
    private Roles nombre;
}
