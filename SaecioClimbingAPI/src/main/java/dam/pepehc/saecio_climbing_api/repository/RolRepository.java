package dam.pepehc.saecio_climbing_api.repository;

import dam.pepehc.saecio_climbing_api.entity.Rol;
import dam.pepehc.saecio_climbing_api.enums.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * La interfaz Rol repository.
 */
public interface RolRepository extends JpaRepository<Rol, Long> {
    /**
     * Find by nombre optional.
     *
     * @param nombre el nombre
     * @return el optional
     */
    Optional<Rol> findByNombre(final Roles nombre);
}
