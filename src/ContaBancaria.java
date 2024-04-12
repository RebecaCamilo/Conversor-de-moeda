import java.util.Scanner;

public class ContaBancaria {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        dadosIniciais();

        int op = 0;
        double saldo = 2500.0;

        while (op != 4) {
            menu();
            op = sc.nextInt();
            saldo = realizarOperacao(op, saldo, sc);
        }

        sc.close();
    }

    private static double realizarOperacao(int op, double saldo, Scanner sc) {
        switch (op) {
            case 1 -> System.out.printf("O saldo atual é R$ %.2f\n\n", saldo);
            case 2 -> {
                System.out.println("Informe o valor a receber:");
                saldo += sc.nextDouble();
                System.out.printf("Saldo atualizado R$ %.2f\n\n", saldo);
            }
            case 3 -> {
                System.out.println("Informe o valor que deseja transferir:");
                saldo -= sc.nextDouble();
                System.out.printf("Saldo atualizado R$ %.2f\n\n", saldo);
            }
            case 4 -> System.out.println("Encerrando programa...");
            default -> System.out.println("Opção inválida\n");
        }
        return saldo;
    }

    private static void menu() {
        System.out.println(
                """
                Operações disponíveis:
                1- Consultar saldos
                2- Receber Valor
                3- Transferir valor
                4- Sair
                
                Digite a operação desejada:"""
        );
    }

    private static void dadosIniciais() {
        System.out.println(
                """
                *****************************************
                Dados iniciais do cliente:
                
                Nome:           Rebeca Camilo
                Tipo conta:     Corrente
                Saldo inicial:  R$ 2500,00
                *****************************************
                """
        );
    }
}
