package dam.pepehc.saecio_climbing_api.repository;

import dam.pepehc.saecio_climbing_api.entity.Sector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * La interfaz Sector repository.
 */
@Repository
public interface SectorRepository extends JpaRepository<Sector, Long> {
    /**
     * Encontrar sectores por id zona list.
     *
     * @param idZona el id zona
     * @return el list
     */
    @Query(value = "SELECT sc FROM Sector sc WHERE sc.idZona = :idZona")
    List<Sector> encontrarSectoresPorIdZona(@Param("idZona") final Long idZona);

    /**
     * Encontrar id zona por id sector long.
     *
     * @param idSector el id sector
     * @return el long
     */
    @Query(value = "SELECT sc.idZona FROM Sector sc WHERE sc.idSector = :idSector")
    Long encontrarIdZonaPorIdSector(@Param("idSector") final Long idSector);
}
