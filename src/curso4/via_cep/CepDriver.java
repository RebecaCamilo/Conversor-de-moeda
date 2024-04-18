package curso4.via_cep;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class CepDriver {
    public static void main(String[] args) throws IOException, InterruptedException {

        String url = getViaCepUrl();
        System.out.println(url);

        HttpResponse<String> req = sendHttpRequest(url);
        var t = req.body();

        createJsonFile(req.body());
    }

    private static String getViaCepUrl() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o cep para busca: ");
        String cep = sc.nextLine();
        sc.close();
        return "https://viacep.com.br/ws/" + cep + "/json/";
    }

    private static HttpResponse<String> sendHttpRequest(String url) throws IOException, InterruptedException {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();
            return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    private static void createJsonFile(String body) throws IOException {
        FileWriter escrita = new FileWriter("endereco.json");
        escrita.write(body);
        escrita.close();
    }

}
