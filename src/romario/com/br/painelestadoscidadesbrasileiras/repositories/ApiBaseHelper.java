package romario.com.br.painelestadoscidadesbrasileiras.repositories;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 *
 * @author Romario
 */
public abstract class ApiBaseHelper {
    
    public Response getResponse(String objectInJoson, String url, String method) throws Exception {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, objectInJoson);

        Request request = new Request.Builder()
                .url(url)
                .method(method, body)
                .addHeader("Content-Type", "application/json")
                .build();
        
        return client.newCall(request).execute();
    }
}