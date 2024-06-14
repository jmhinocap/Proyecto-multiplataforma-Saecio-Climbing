package dam.pepehc.saecio_climbing_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

/**
 * El tipo Token verificación.
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TokenVerificacion {
    
    private static final int CADUCIDAD = 60 * 24;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idToken;
    
    private String token;
    
    @OneToOne(targetEntity = Usuario.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "id_usuario")
    private Usuario usuario;
    
    private Date fechaCaducidad;
    
    private Date calcularFechaCaducidad(int fechaCaducidadMinutos) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Timestamp(cal.getTime().getTime()));
        cal.add(Calendar.MINUTE, fechaCaducidadMinutos);
        return new Date(cal.getTime().getTime());
    }
    
    public void setCaducidad() {
        this.fechaCaducidad = calcularFechaCaducidad(CADUCIDAD);
    }
}
