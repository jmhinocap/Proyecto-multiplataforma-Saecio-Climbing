package dam.pepehc.saecio_climbing_api.repository;

import dam.pepehc.saecio_climbing_api.entity.Ascension;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * La interfaz Ascension repository.
 */
@Repository
public interface AscensionRepository extends JpaRepository<Ascension, Long> {
}
