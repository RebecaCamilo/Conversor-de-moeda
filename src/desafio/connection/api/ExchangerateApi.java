package desafio.connection.api;

import desafio.connection.file.EnvUtil;
import desafio.model.CurrencyType;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangerateApi {

    private static HttpClient createClient() {
        return HttpClient.newHttpClient();
    }

    public static HttpRequest createRequestToGetCurrencyRate(CurrencyType currencyType) {
        String apiKey = EnvUtil.get("API_KEY");

        String url = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + currencyType.name();

        return HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
    }

    public static HttpResponse<String> getResponse(HttpRequest request) {
        HttpClient client = createClient();
        try {
            return client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            System.out.println("Não foi estabelecer conexão com a ExchangerateApi. Finalizando programa...");
            System.exit(0);
        }
        return null;
    }
}
