package dam.pepehc.saecio_climbing_api.repository;

import dam.pepehc.saecio_climbing_api.entity.Via;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * La interfaz Via repository.
 */
@Repository
public interface ViaRepository extends JpaRepository<Via, Long> {

    /**
     * Encontrar ultimas entradas list.
     *
     * @return el list
     */
    @Query(value = "SELECT v FROM Via v ORDER BY v.idVia DESC LIMIT 5")
    List<Via> encontrarUltimasEntradas();

    /**
     * Encontrar vias por id sector list.
     *
     * @param idSector el id sector
     * @return el list
     */
    @Query(value = "SELECT v FROM Via v WHERE v.idSector = :idSector")
    List<Via> encontrarViasPorIdSector(@Param("idSector") final Long idSector);
}
