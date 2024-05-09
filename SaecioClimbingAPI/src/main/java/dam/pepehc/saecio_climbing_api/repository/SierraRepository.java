package dam.pepehc.saecio_climbing_api.repository;

import dam.pepehc.saecio_climbing_api.entity.Sierra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SierraRepository extends JpaRepository<Sierra, Long> {
}
