package desafio;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ConversorMoedas {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);

        System.out.println(TipoMoeda.values());

        System.out.println("Seja bem vinde ao conversor de moedas");
        System.out.println("Digite a partir de qual moeda quer fazer a conversão:");
        TipoMoeda moedaBase = menuPrincipal(sc);
        System.out.println(moedaBase.name());

        System.out.println("Digite para qual moeda quer fazer a conversão:");
        TipoMoeda moedaFinal = menuPrincipal(sc);
        System.out.println(moedaFinal.name());

        HttpClient client = createClient();
        HttpRequest request = createRequestCotacaoMoeda(moedaBase);
        HttpResponse<String> response = getResponse(client, request);

        System.out.println(response.body());

    }

    private static TipoMoeda menuPrincipal(Scanner sc) {
        System.out.println("***********************************************");
        System.out.println("""
                1 -> United States Dollar
                2 -> Argentine Peso
                3 -> Brazilian Real
                4 -> Colombian Peso
                + -> Mostrar mais opções
                0 -> Sair""");
        System.out.println("***********************************************");

        String op = sc.nextLine();
        switch (op) {
            case "1":
                return TipoMoeda.fromDescription("United States Dollar");
            case "2":
                return TipoMoeda.fromDescription("Argentine Peso");
            case "3":
                return TipoMoeda.fromDescription("Brazilian Real");
            case "4":
                return TipoMoeda.fromDescription("Colombian Peso");
            case "+":
                return menuCompleto(sc);
            case "0":
                return null;
            default:
                System.out.println("Opção inválida");
        }
        return null;
    }

    private static TipoMoeda menuCompleto(Scanner sc) {
        int opcaoInicial = 1;
        int incremento = 10;

        while (opcaoInicial <= TipoMoeda.lastItem()) {
            System.out.println("***********************************************");
            for (int i = opcaoInicial - 1; i < (opcaoInicial + incremento - 1); i++) {
                if ((i + 1) > TipoMoeda.lastItem()) {
                    break;
                }
                System.out.println((i + 1) + " -> " + TipoMoeda.fromId(i + 1).getDescricao());
            }
            System.out.println("+ -> Mostrar mais opções");
            System.out.println("0 -> Sair");
            System.out.println("***********************************************");

            String escolha = sc.nextLine();
            if (!escolha.equals("+") && (Integer.parseInt(escolha) >= opcaoInicial && Integer.parseInt(escolha) <= (opcaoInicial + incremento - 1))) {
                return TipoMoeda.fromId(Integer.parseInt(escolha));
            } else if (escolha.equals("+")) {
                opcaoInicial += incremento;
            } else if (escolha.equals("0")) {
                break;
            } else {
                System.out.println("Opção inválida.");
            }
        }
        System.out.println("Saindo do menu.");
        return null;
    }

    private static HttpClient createClient() {
        return HttpClient.newHttpClient();
    }

    private static HttpRequest createRequestCotacaoMoeda(TipoMoeda moeda) throws IOException, InterruptedException {
        String url = "https://v6.exchangerate-api.com/v6/50c9052bdb8f8b10f6264c4e/latest/" + moeda.name();

        return HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
    }

    private static HttpResponse<String> getResponse(HttpClient client, HttpRequest request) throws IOException, InterruptedException {
        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

}
