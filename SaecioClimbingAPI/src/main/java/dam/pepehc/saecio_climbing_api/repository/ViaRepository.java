package dam.pepehc.SaecioClimbingAPI.repository;

import dam.pepehc.SaecioClimbingAPI.entity.Via;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViaRepository extends JpaRepository<Via, Long> {
}
