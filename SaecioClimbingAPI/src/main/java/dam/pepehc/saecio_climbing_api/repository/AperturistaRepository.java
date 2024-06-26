package dam.pepehc.saecio_climbing_api.repository;

import dam.pepehc.saecio_climbing_api.entity.Aperturista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * La interfaz Aperturista repository.
 */
@Repository
public interface AperturistaRepository extends JpaRepository<Aperturista, Long> {
}
