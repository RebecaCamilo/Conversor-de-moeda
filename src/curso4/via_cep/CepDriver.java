package curso4.via_cep;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class CepDriver {
    public static void main(String[] args) {
        try {
            String url = getViaCepUrl();
            HttpResponse<String> req = sendHttpRequest(url);
            var body = req.body();
            String json = removeUnusedFields(body);
            createJsonFile(json);
            System.out.println("Endereço encontrado e salvo com sucesso.");
        } catch (IOException | InterruptedException e) {
            System.out.println("Erro ao processar a solicitação: " + e.getMessage());
        } catch (CepNotFoundException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        System.out.println("Finalizando o programa...");
    }

    private static String getViaCepUrl() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Digite o CEP para busca: ");
            return "https://viacep.com.br/ws/" + sc.nextLine() + "/json/";
        }
    }

    private static HttpResponse<String> sendHttpRequest(String url) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    private static String removeUnusedFields(String body) {
        validateBody(body);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Endereco endereco = gson.fromJson(body, Endereco.class);
        return gson.toJson(endereco);
    }

    private static void validateBody(String body) {
        if (!body.contains("cep")) {
            throw new CepNotFoundException();
        }
    }

    private static void createJsonFile(String json) {
        try (FileWriter escrita = new FileWriter("endereco.json")) {
            escrita.write(json);
            System.out.println("Arquivo JSON criado com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao criar o arquivo JSON: " + e.getMessage());
        }
    }
}