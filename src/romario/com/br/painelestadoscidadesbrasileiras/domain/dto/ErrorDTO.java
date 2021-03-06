package romario.com.br.painelestadoscidadesbrasileiras.domain.dto;

import lombok.Data;
import romario.com.br.painelestadoscidadesbrasileiras.domain.ResponseInterface;

/**
 *
 * @author Romario
 */
@Data
public class ErrorDTO implements ResponseInterface {
    private Integer status;
    private String message;
    private Long timeStamp;
}
