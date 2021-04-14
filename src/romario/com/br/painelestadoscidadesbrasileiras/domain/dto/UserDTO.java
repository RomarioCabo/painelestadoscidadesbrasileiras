package romario.com.br.painelestadoscidadesbrasileiras.domain.dto;

import romario.com.br.painelestadoscidadesbrasileiras.domain.ResponseInterface;

/**
 *
 * @author Romario
 */
public class UserDTO implements ResponseInterface {
    private Long id;
    private String name;
    private String email;
    private String profile;
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserDTO() {
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }
}
