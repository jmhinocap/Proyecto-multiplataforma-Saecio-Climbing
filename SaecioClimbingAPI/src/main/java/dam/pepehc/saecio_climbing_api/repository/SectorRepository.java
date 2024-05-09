package dam.pepehc.SaecioClimbingAPI.repository;

import dam.pepehc.SaecioClimbingAPI.entity.Sector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectorRepository extends JpaRepository<Sector, Long> {
}
