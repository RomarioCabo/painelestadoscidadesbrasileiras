package romario.com.br.painelestadoscidadesbrasileiras.controller.user;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import okhttp3.Response;
import romario.com.br.painelestadoscidadesbrasileiras.constants.Constants;
import romario.com.br.painelestadoscidadesbrasileiras.domain.Page;
import romario.com.br.painelestadoscidadesbrasileiras.domain.dto.UserDTO;
import romario.com.br.painelestadoscidadesbrasileiras.repositories.ApiBaseHelper;

/**
 *
 * @author Romario
 */
public class UserGetAllController extends ApiBaseHelper {

    public Page<UserDTO> getAllUsers(Integer page) {
        try {
            ObjectMapper mapper = new ObjectMapper();

            String url = Constants.BASE_URL + Constants.URL_VERSION + "user?linesPerPage=" + 10 + "&page=" + page + "&sortBy=id";

            System.out.print(url + "\n");

            Response response = getResponse(null, url, "GET", null);

            String responseApi = response.body().string();

            System.out.print(responseApi + "\n");

            if (response.code() == 200) {
                if (response.body() != null) {
                    return getPage(
                            response.header("totalelements"),
                            response.header("totalpages"),
                            mapper.readValue(responseApi, new TypeReference<List<UserDTO>>(){})
                    );
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

    private Page<UserDTO> getPage(String totalElements, String toalPages, List<UserDTO> listDto) {
        Page<UserDTO> pageDto = new Page<>();
        pageDto.setTotalElements(Long.parseLong(totalElements));
        pageDto.setTotalPages(Long.parseLong(toalPages));
        pageDto.setListDto(listDto);

        return pageDto;
    }
}
