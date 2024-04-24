package desafio.connection;

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

    public static HttpRequest createRequestToGetCurrencyRate(CurrencyType currencyType) throws IOException, InterruptedException {
        String url = "https://v6.exchangerate-api.com/v6/50c9052bdb8f8b10f6264c4e/latest/" + currencyType.name();

        return HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
    }

    public static HttpResponse<String> getResponse(HttpRequest request) throws IOException, InterruptedException {
        HttpClient client = createClient();
        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }
}
