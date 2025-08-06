import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conversor {
    public static double converter (String deMoeda, String paraMoeda, double valor) throws IOException, InterruptedException {
        String url = "https://v6.exchangerate-api.com/v6/5708521f00ac9d4279f9e145/pair/" + deMoeda + "/" + paraMoeda + "/" + valor;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();

        JsonObject jsonObject = JsonParser.parseString(response.body()).getAsJsonObject();
        double resultado = jsonObject.get("conversion_result").getAsDouble();

        return resultado;
    }

}
