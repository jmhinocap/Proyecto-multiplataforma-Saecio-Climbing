package dam.pepehc.SaecioClimbingAPI.repository;

import dam.pepehc.SaecioClimbingAPI.entity.Sierra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SierraRepository extends JpaRepository<Sierra, Long> {
}
