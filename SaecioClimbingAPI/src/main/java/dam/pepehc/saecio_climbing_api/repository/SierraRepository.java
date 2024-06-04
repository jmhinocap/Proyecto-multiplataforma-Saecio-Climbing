package dam.pepehc.saecio_climbing_api.repository;

import dam.pepehc.saecio_climbing_api.entity.Sierra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * La interfaz Sierra repository.
 */
@Repository
public interface SierraRepository extends JpaRepository<Sierra, Long> {
    /**
     * Encontrar nombre por id sierra string.
     *
     * @param idSierra el id sierra
     * @return el string
     */
    @Query(value = "SELECT sr.nombre FROM Sierra sr WHERE sr.idSierra = :idSierra")
    String encontrarNombrePorIdSierra(@Param("idSierra") final Long idSierra);
}
