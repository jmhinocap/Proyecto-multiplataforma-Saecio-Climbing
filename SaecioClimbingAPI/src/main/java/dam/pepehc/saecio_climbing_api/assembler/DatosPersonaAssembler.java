package dam.pepehc.saecio_climbing_api.assembler;

import dam.pepehc.saecio_climbing_api.dto.RegistrarseDto;
import dam.pepehc.saecio_climbing_api.entity.DatosPersona;
import dam.pepehc.saecio_climbing_api.entity.Rol;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class DatosPersonaAssembler {
    
    private final static String IMAGEN_PERSONA_GENERICA = ""; // TODO crear imagen genérica de persona

    public DatosPersona registrarseDtoADatosPersona(final RegistrarseDto registrarseDto) {
        return DatosPersona.builder()
                .idDatosPersona(0L)
                .nombre(registrarseDto.getNombre() == null ? "" : registrarseDto.getNombre())
                .apellidos(registrarseDto.getApellidos() == null ? "" : registrarseDto.getApellidos())
                .foto(registrarseDto.getFoto() == null ? new File(IMAGEN_PERSONA_GENERICA) : registrarseDto.getFoto())
                .build();
    }
}
