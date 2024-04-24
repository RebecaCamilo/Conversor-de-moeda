package desafio;

import desafio.connection.ExchangerateApi;
import desafio.model.Currency;
import desafio.model.CurrencyType;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);

        System.out.println(CurrencyType.values());

        System.out.println("Seja bem vinde ao conversor de moedas");
        System.out.println("Digite qual moeda quer fazer a conversão:");
        CurrencyType moedaBase = mainMenu(sc);

        System.out.println("Digite para qual moeda quer fazer a conversão:");
        CurrencyType moedaFinal = mainMenu(sc);

        HttpRequest request = ExchangerateApi.createRequestToGetCurrencyRate(moedaBase);
        HttpResponse<String> response = ExchangerateApi.getResponse(request);

        var taxa = Currency.getConversionRate(response.body(), moedaFinal);

        System.out.println("Quantos " + moedaBase.getDescricao() + " gostaria de converter para " + moedaFinal.getDescricao() + "?" );
        var valor = sc.nextDouble();

        System.out.println("Esse valor corresponde a " + (valor * taxa) + " " + moedaFinal.getDescricao());

    }

    private static CurrencyType mainMenu(Scanner sc) {
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
                return CurrencyType.fromDescription("United States Dollar");
            case "2":
                return CurrencyType.fromDescription("Argentine Peso");
            case "3":
                return CurrencyType.fromDescription("Brazilian Real");
            case "4":
                return CurrencyType.fromDescription("Colombian Peso");
            case "+":
                return extendedMenu(sc);
            case "0":
                return null;
            default:
                System.out.println("Opção inválida");
        }
        return null;
    }

    private static CurrencyType extendedMenu(Scanner sc) {
        int opcaoInicial = 1;
        int incremento = 10;

        while (opcaoInicial <= CurrencyType.lastItem()) {
            System.out.println("***********************************************");
            for (int i = opcaoInicial - 1; i < (opcaoInicial + incremento - 1); i++) {
                if ((i + 1) > CurrencyType.lastItem()) {
                    break;
                }
                System.out.println((i + 1) + " -> " + CurrencyType.fromId(i + 1).getDescricao());
            }
            System.out.println("+ -> Mostrar mais opções");
            System.out.println("0 -> Sair");
            System.out.println("***********************************************");

            String escolha = sc.nextLine();
            if (!escolha.equals("+") && (Integer.parseInt(escolha) >= opcaoInicial && Integer.parseInt(escolha) <= (opcaoInicial + incremento - 1))) {
                return CurrencyType.fromId(Integer.parseInt(escolha));
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

}
