package dam.pepehc.SaecioClimbingAPI.repository;

import dam.pepehc.SaecioClimbingAPI.entity.Ascension;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AscensionRepository extends JpaRepository<Ascension, Long> {
}
