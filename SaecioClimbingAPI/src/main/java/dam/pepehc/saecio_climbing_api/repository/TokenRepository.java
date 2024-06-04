package dam.pepehc.saecio_climbing_api.repository;

import dam.pepehc.saecio_climbing_api.entity.TokenVerificacion;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * La interfaz Token repository.
 */
public interface TokenRepository extends JpaRepository<TokenVerificacion, Long> {
    /**
     * Find by token token verificacion.
     *
     * @param token el token
     * @return el token verificacion
     */
    TokenVerificacion findByToken(String token);
}
