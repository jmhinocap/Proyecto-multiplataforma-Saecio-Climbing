package dam.pepehc.saecio_climbing_api.repository;

import dam.pepehc.saecio_climbing_api.entity.Sector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SectorRepository extends JpaRepository<Sector, Long> {
    @Query(value = "SELECT sc FROM Sector sc WHERE sc.idZona = :idZona")
    List<Sector> encontrarSectoresPorIdSierra(@Param("idZona") final Long idZona);
}
