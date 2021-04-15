package romario.com.br.painelestadoscidadesbrasileiras.controller.user;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import okhttp3.Response;
import romario.com.br.painelestadoscidadesbrasileiras.constants.Constants;
import romario.com.br.painelestadoscidadesbrasileiras.domain.Page;
import romario.com.br.painelestadoscidadesbrasileiras.domain.dto.UserDto;
import romario.com.br.painelestadoscidadesbrasileiras.repositories.ApiBaseHelper;

/**
 *
 * @author Romario
 */
public class UserGetAllController extends ApiBaseHelper {

    public Page<UserDto> getAllUsers(Integer page) {
        try {
            ObjectMapper mapper = new ObjectMapper();

            String url = Constants.BASE_URL + Constants.URL_VERSION + "user?linesPerPage=" + 10 + "&page=" + page + "&sortBy=id";
            
            System.out.print(url + "\n");

            Response response = getResponse(null, url, "GET");

            String responseApi = response.body().string();

            System.out.print(responseApi + "\n");

            if (response.code() == 200) {
                if (response.body() != null) {
                    Page<UserDto> pageDto = new Page<>();
                    pageDto.setTotalElements(Long.parseLong(response.header("totalelements")));
                    pageDto.setTotalPages(Long.parseLong(response.header("totalpages")));
                    pageDto.setListDto(mapper.readValue(responseApi, new TypeReference<List<UserDto>>() {
                    }));

                    return pageDto;
                }

                return null;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }
}
