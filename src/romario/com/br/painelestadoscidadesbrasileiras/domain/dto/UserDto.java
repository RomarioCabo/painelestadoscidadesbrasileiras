package romario.com.br.painelestadoscidadesbrasileiras.domain.dto;

/**
 *
 * @author Romario
 */
public class UserDto {

    private Long id;
    private String name;
    private String email;
    private String profile;
    private Long totalElements;
    private Long totalpages;

    public UserDto() {
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

    public Long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(Long totalElements) {
        this.totalElements = totalElements;
    }

    public Long getTotalpages() {
        return totalpages;
    }

    public void setTotalpages(Long totalpages) {
        this.totalpages = totalpages;
    }
}
