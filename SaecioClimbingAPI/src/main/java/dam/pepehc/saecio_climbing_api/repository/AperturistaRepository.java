package dam.pepehc.SaecioClimbingAPI.repository;

import dam.pepehc.SaecioClimbingAPI.entity.Aperturista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AperturistaRepository extends JpaRepository<Aperturista, Long> {
}
