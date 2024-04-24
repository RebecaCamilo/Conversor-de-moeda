package desafio;

import desafio.connection.api.ExchangerateApi;
import desafio.model.Currency;
import desafio.model.CurrencyType;
import desafio.service.Converter;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class CurrencyConverterDriver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Seja bem vinde ao conversor de moedas");
        System.out.println("Digite qual moeda quer fazer a conversão:");
        CurrencyType baseCurrency = menu(sc);

        System.out.println("Digite para qual moeda quer fazer a conversão:");
        CurrencyType finalCurrency = menu(sc);

        HttpRequest request = ExchangerateApi.createRequestToGetCurrencyRate(baseCurrency);
        HttpResponse<String> response = ExchangerateApi.getResponse(request);

        var rate = Currency.getConversionRate(response.body(), finalCurrency);

        double convertedValue = Converter.covert(sc, rate, baseCurrency, finalCurrency);

        System.out.printf("Esse valor corresponde a %.3f %s", convertedValue, finalCurrency.getDescription());
    }

    private static CurrencyType menu(Scanner sc) {
        while (true) {
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
                    System.out.println("Finalizando programa...");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida");
            }
        }
    }

    private static CurrencyType extendedMenu(Scanner sc) {
        int initialOption = 1;
        int increment = 10;

        while (initialOption <= CurrencyType.lastItem()) {
            System.out.println("***********************************************");
            for (int i = initialOption - 1; i < (initialOption + increment - 1); i++) {
                if ((i + 1) > CurrencyType.lastItem()) {
                    break;
                }
                System.out.println((i + 1) + " -> " + CurrencyType.fromId(i + 1).getDescription());
            }
            System.out.println("+ -> Mostrar mais opções");
            System.out.println("0 -> Sair");
            System.out.println("***********************************************");

            try {
                String escolha = sc.nextLine();
                if (!escolha.equals("+") && (Integer.parseInt(escolha) >= initialOption && Integer.parseInt(escolha) <= (initialOption + increment - 1))) {
                    return CurrencyType.fromId(Integer.parseInt(escolha));
                } else if (escolha.equals("+")) {
                    initialOption += increment;
                } else if (escolha.equals("0")) {
                    System.out.println("Finalizando programa...");
                    System.exit(0);
                } else {
                    System.out.println("Opção inválida.");
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
                System.out.println("Opção inválida.");
            }
        }
        System.out.println("Saindo do menu.");
        return null;
    }

}
