package romario.com.br.painelestadoscidadesbrasileiras.domain.dto;

import lombok.Data;
import romario.com.br.painelestadoscidadesbrasileiras.domain.ResponseInterface;

/**
 *
 * @author Romario
 */
@Data
public class UserDTO implements ResponseInterface {

    private Long id;
    private String name;
    private String email;
    private ProfileDTO profile;
}
