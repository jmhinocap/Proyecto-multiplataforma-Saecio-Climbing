package dam.pepehc.saecio_climbing_api.repository;

import dam.pepehc.saecio_climbing_api.entity.Ascension;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * La interfaz Ascension repository.
 */
@Repository
public interface AscensionRepository extends JpaRepository<Ascension, Long> {
    @Query(value = "SELECT as FROM Ascension as JOIN as.usuario u WHERE u.idUsuario = :idUsuario")
    List<Ascension> encontrarAscensionesPorIdUsuario(@Param("idUsuario") final Long idUsuario);
}
