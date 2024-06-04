package dam.pepehc.saecio_climbing_api.repository;

import dam.pepehc.saecio_climbing_api.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * La interfaz Usuario repository.
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    /**
     * Find by nombre usuario or correo electronico optional.
     *
     * @param nombreUsuario     el nombre usuario
     * @param correoElectronico el correo electronico
     * @return el optional
     */
    Optional<Usuario> findByNombreUsuarioOrCorreoElectronico(final String nombreUsuario, 
                                                             final String correoElectronico);

    /**
     * Find by nombre usuario optional.
     *
     * @param nombreUsuario el nombre usuario
     * @return el optional
     */
    Optional<Usuario> findByNombreUsuario(final String nombreUsuario);

    /**
     * Exists by nombre usuario boolean.
     *
     * @param nombreUsuario el nombre usuario
     * @return el boolean
     */
    Boolean existsByNombreUsuario(final String nombreUsuario);

    /**
     * Exists by correo electronico boolean.
     *
     * @param correoElectronico el correo electronico
     * @return el boolean
     */
    Boolean existsByCorreoElectronico(final String correoElectronico);
}
