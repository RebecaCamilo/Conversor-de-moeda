package curso1;

import java.util.Random;
import java.util.Scanner;

public class JogoAdivinhacao {
    public static void main(String[] args) {
        final int NUMERO_MAXIMO_TENTATIVAS = 5;
        Scanner sc = new Scanner(System.in);
        int numeroAleatorio = geraNumeroAleatorio();

        System.out.println("""
                Tente adivinhar qual o número que estou pensando!
                Você tem 5 tentativas.
                """);

        int palpite;

        for (int i = NUMERO_MAXIMO_TENTATIVAS; i >= 0; i--) {
            System.out.print("Digite seu palpite: ");
            palpite = sc.nextInt();

            if (verificaPalpite(numeroAleatorio, palpite)) {
                break;
            }

            if ((i - 1) == 0) {
                System.out.println("Infelizmente acabaram suas tentativas :(");
                System.out.println("O número que estava pensando era " + numeroAleatorio);
                break;
            }

            System.out.println("Você tem mais " + (i - 1) +" tentativas.\n");
        }
    }

    private static int geraNumeroAleatorio() {
        return new Random().nextInt(100);
    }

    private static boolean verificaPalpite(int numeroAleatorio, int palpite) {
        if (palpite < numeroAleatorio) {
            System.out.println("O número " + palpite + " é menor que o número que estou pensando.");
            if ((numeroAleatorio - palpite) <= 3) {
                System.out.println("Mas está próximo!");
            }
            return false;
        } else if (palpite > numeroAleatorio) {
            System.out.println("O número " + palpite + " é maior que o número que estou pensando.");
            if ((palpite - numeroAleatorio) <= 3) {
                System.out.println("Mas está próximo!");
            }
            return false;
        } else {
            System.out.println("Parabéns, você adivinhou! " + palpite + " é exatamente o número que estava pensando!");
            return true;
        }
    }

}
