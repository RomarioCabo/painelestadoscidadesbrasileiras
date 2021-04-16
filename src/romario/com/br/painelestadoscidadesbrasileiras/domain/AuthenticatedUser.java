package romario.com.br.painelestadoscidadesbrasileiras.domain;

/**
 *
 * @author Romario
 */
public class AuthenticatedUser implements ResponseInterface {
    private static Long id;
    private static String name;
    private static String email;
    private static String profile;
    private static String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        AuthenticatedUser.token = token;
    }

    public AuthenticatedUser() {
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        AuthenticatedUser.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        AuthenticatedUser.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        AuthenticatedUser.email = email;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        AuthenticatedUser.profile = profile;
    }
}
