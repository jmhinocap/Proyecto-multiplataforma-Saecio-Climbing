package dam.pepehc.saecio_climbing_api.repository;

import dam.pepehc.saecio_climbing_api.entity.Zona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * La interfaz Zona repository.
 */
@Repository
public interface ZonaRepository extends JpaRepository<Zona, Long> {
    /**
     * Encontrar zonas por id sierra list.
     *
     * @param idSierra el id sierra
     * @return el list
     */
    @Query(value = "SELECT zn FROM Zona zn WHERE zn.idSierra = :idSierra")
    List<Zona> encontrarZonasPorIdSierra(@Param("idSierra") final Long idSierra);

    /**
     * Encontrar nombre zona string.
     *
     * @param idZona el id zona
     * @return el string
     */
    @Query(value = "SELECT zn.nombre FROM Zona zn WHERE zn.idZona = :idZona")
    String encontrarNombreZona(@Param("idZona") final Long idZona);
}
