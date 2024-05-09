package dam.pepehc.SaecioClimbingAPI.resource;

import dam.pepehc.SaecioClimbingAPI.entity.Ascension;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ViaResource {
    private Long idVia;
    private String nombre;
    private String grado;
    private String metros;
    private String numeroChapas;
    private String fechaApertura;
    private String fechaUltimaRevision;
    private String descripcion;
    private File foto;
    private List<Ascension> ascensiones; 
}
