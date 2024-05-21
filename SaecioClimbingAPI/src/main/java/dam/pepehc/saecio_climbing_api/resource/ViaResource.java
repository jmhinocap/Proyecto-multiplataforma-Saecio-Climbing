package dam.pepehc.saecio_climbing_api.resource;

import dam.pepehc.saecio_climbing_api.entity.Aperturista;
import dam.pepehc.saecio_climbing_api.entity.Ascension;
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
    private Long idSector;
    private String nombre;
    private String grado;
    private String metros;
    private String numeroChapas;
    private String fechaApertura;
    private String fechaUltimaRevision;
    private String descripcion;
    private String foto;
    private List<Ascension> ascensiones;
    private List<Aperturista> aperturistas;
}
