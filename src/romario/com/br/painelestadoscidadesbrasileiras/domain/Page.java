package romario.com.br.painelestadoscidadesbrasileiras.domain;

import java.util.List;
import lombok.Data;

/**
 *
 * @author Romario
 * @param <DTO>
 */
@Data
public class Page<DTO> {
    
    private Long totalElements;
    private Long totalPages;
    private List<DTO> listDto;
}
