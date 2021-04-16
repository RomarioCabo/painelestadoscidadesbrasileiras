package romario.com.br.painelestadoscidadesbrasileiras.domain.form;

import lombok.Data;

/**
 *
 * @author Romario
 */
@Data
public class UserForm {
    private String name;
    private String email;
    private String password;
    
    private int codProfile;
}
