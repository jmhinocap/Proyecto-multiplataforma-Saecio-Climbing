package dam.pepehc.saecio_climbing_api.repository;

import dam.pepehc.saecio_climbing_api.entity.DatosPersona;
import dam.pepehc.saecio_climbing_api.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByNombreUsuarioOrCorreoElectronico(final String nombreUsuario, final String correoElectronico);
    Optional<Usuario> findByNombreUsuario(final String nombreUsuario);
    Boolean existsByNombreUsuario(final String nombreUsuario);
    Boolean existsByCorreoElectronico(final String correoElectronico);
}
