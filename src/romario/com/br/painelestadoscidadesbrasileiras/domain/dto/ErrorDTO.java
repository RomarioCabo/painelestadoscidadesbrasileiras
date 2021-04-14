package romario.com.br.painelestadoscidadesbrasileiras.domain.dto;

import romario.com.br.painelestadoscidadesbrasileiras.domain.ResponseInterface;

/**
 *
 * @author Romario
 */
public class ErrorDTO implements ResponseInterface {
    private Integer status;
    private String message;
    private Long timeStamp;

    public ErrorDTO() {
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
