package dam.pepehc.saecio_climbing_api.assembler;

import dam.pepehc.saecio_climbing_api.dto.RegistrarseDto;
import dam.pepehc.saecio_climbing_api.entity.DatosPersona;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;


/**
 * El tipo Datos persona assembler.
 */
@Component
public class DatosPersonaAssembler {
    
    private final static String IMAGEN_PERSONA_GENERICA = ""; // TODO crear imagen genérica de persona

    /**
     * Registrarse dto a datos persona datos persona.
     *
     * @param registrarseDto 
     * @return 
     */
    public DatosPersona registrarseDtoADatosPersona(final RegistrarseDto registrarseDto) {
        return DatosPersona.builder()
                .idDatosPersona(0L)
                .nombre(registrarseDto.getNombre() == null ? StringUtils.EMPTY : registrarseDto.getNombre())
                .apellidos(registrarseDto.getApellidos() == null ? StringUtils.EMPTY : registrarseDto.getApellidos())
                .foto(registrarseDto.getFoto() == null ? IMAGEN_PERSONA_GENERICA : registrarseDto.getFoto())
                .build();
    }
}
