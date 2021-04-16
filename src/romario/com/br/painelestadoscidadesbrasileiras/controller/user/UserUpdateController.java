package romario.com.br.painelestadoscidadesbrasileiras.controller.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.Response;
import romario.com.br.painelestadoscidadesbrasileiras.constants.Constants;
import romario.com.br.painelestadoscidadesbrasileiras.domain.AuthenticatedUser;
import romario.com.br.painelestadoscidadesbrasileiras.domain.ResponseInterface;
import romario.com.br.painelestadoscidadesbrasileiras.domain.dto.ErrorDTO;
import romario.com.br.painelestadoscidadesbrasileiras.domain.dto.UserDTO;
import romario.com.br.painelestadoscidadesbrasileiras.domain.form.UserForm;
import romario.com.br.painelestadoscidadesbrasileiras.repositories.ApiBaseHelper;

/**
 *
 * @author Romario
 */
public class UserUpdateController extends ApiBaseHelper {

    public ResponseInterface update(Long idUser, Long idProfile, UserForm form) {
        try {
            AuthenticatedUser authenticatedUser = new AuthenticatedUser();

            ObjectMapper mapper = new ObjectMapper();

            String url = Constants.BASE_URL + Constants.URL_VERSION + "user/update/" + idUser + "/" + idProfile;

            System.out.print(url + "\n");

            String jsonInString = mapper.writeValueAsString(form);

            Response response = getResponse(jsonInString, url, "PUT", authenticatedUser.getToken());

            String responseApi = response.body().string();

            System.out.print(responseApi + "\n");

           if (response.code() == 200) {
                return mapper.readValue(responseApi, UserDTO.class);
            } else {
                return mapper.readValue(responseApi, ErrorDTO.class);
            }
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }
}
