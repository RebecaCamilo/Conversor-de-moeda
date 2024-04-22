package desafio;

import java.io.IOException;
import java.util.Scanner;

public class ConversorMoedas {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);

        menuPrincipal(sc);

    }

    private static TipoMoeda menuPrincipal(Scanner sc) {
        System.out.println("***********************************************");
        System.out.println("Seja bem vinde ao conversor de moedas");
        System.out.println("Digite qual moeda quer fazer a conversão:");
        System.out.println("""
                1 -> United States Dollar
                2 -> Argentine Peso
                3 -> Brazilian Real
                4 -> Colombian Peso
                + -> Mostrar mais opções
                0 -> Sair
                """);

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
            case "5":
                return menuCompleto(sc);
            case "0":
                return null;
            default:
                System.out.println("Opção inválida");
        }
        System.out.println("***********************************************");
        return null;
    }

    private static TipoMoeda menuCompleto(Scanner sc) {
        int opcaoInicial = 1;
        int incremento = 5;

        while (opcaoInicial <= TipoMoeda.lastItem()) {
            System.out.println("***********************************************");
            System.out.println("Digite qual moeda quer fazer a conversão:");
            for (int i = opcaoInicial - 1; i < (opcaoInicial + incremento - 1); i++) {
                System.out.println((i + 1) + " -> " + TipoMoeda.fromId(i + 1).getDescricao());
            }
            System.out.println("+ -> Mostrar mais opções");
            System.out.println("0 -> Sair");
            System.out.println("***********************************************");

            String escolha = sc.nextLine();
            if (escolha.equals("+")) {
                opcaoInicial += incremento;
            } else if (escolha.equals("0")) {
                break;
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }
        System.out.println("Saindo do menu.");
        return null;
    }

}
