package romario.com.br.painelestadoscidadesbrasileiras.controller.login;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.Response;
import romario.com.br.painelestadoscidadesbrasileiras.constants.Constants;
import romario.com.br.painelestadoscidadesbrasileiras.domain.ResponseInterface;
import romario.com.br.painelestadoscidadesbrasileiras.domain.dto.ErrorDTO;
import romario.com.br.painelestadoscidadesbrasileiras.domain.dto.UserDTO;
import romario.com.br.painelestadoscidadesbrasileiras.domain.form.LoginForm;
import romario.com.br.painelestadoscidadesbrasileiras.repositories.ApiBaseHelper;

/**
 *
 * @author Romario
 */
public class LoginController extends ApiBaseHelper {

    public ResponseInterface authenticate(LoginForm loginForm) {
        try {
            ObjectMapper mapper = new ObjectMapper();

            String jsonInString = mapper.writeValueAsString(loginForm);

            Response response = getResponse(jsonInString, Constants.BASE_URL + "login", "POST");

            if (response.code() == 200) {
                UserDTO userDTO = mapper.readValue(response.body().string(), UserDTO.class);
                userDTO.setToken(response.header("Authorization"));

                return userDTO;
            } else {
                return mapper.readValue(response.body().string(), ErrorDTO.class);
            }
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }
}
