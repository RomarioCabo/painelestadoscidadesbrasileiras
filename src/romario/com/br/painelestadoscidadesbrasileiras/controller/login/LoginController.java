package romario.com.br.painelestadoscidadesbrasileiras.controller.login;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.Response;
import romario.com.br.painelestadoscidadesbrasileiras.constants.Constants;
import romario.com.br.painelestadoscidadesbrasileiras.domain.ResponseInterface;
import romario.com.br.painelestadoscidadesbrasileiras.domain.dto.ErrorDTO;
import romario.com.br.painelestadoscidadesbrasileiras.domain.AuthenticatedUser;
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
            String url = Constants.BASE_URL + "login";

            String jsonInString = mapper.writeValueAsString(loginForm);
            
            System.out.print(url + "\n");
            System.out.print(jsonInString + "\n");

            Response response = getResponse(jsonInString, Constants.BASE_URL + "login", "POST");

            String responseApi = response.body().string();
            
            System.out.print(responseApi + "\n");
            
            if (response.code() == 200) {
                AuthenticatedUser userDTO = mapper.readValue(responseApi, AuthenticatedUser.class);
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
