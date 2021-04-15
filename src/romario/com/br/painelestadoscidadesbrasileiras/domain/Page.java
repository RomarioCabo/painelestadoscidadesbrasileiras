
package romario.com.br.painelestadoscidadesbrasileiras.domain;

import java.util.List;

/**
 *
 * @author Romario
 * @param <DTO>
 */
public class Page<DTO> {
    
    private Long totalElements;
    private Long totalPages;
    private List<DTO> listDto;

    public Page() {
    }

    public Long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(Long totalElements) {
        this.totalElements = totalElements;
    }

    public Long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Long totalPages) {
        this.totalPages = totalPages;
    }

    public List<DTO> getListDto() {
        return listDto;
    }

    public void setListDto(List<DTO> listDto) {
        this.listDto = listDto;
    }
}
