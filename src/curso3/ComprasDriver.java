package curso3;

import java.util.Comparator;
import java.util.Scanner;

public class ComprasDriver {
    public static void main(String[] args) {
        Scanner scNumber = new Scanner(System.in);
        Scanner scString = new Scanner(System.in);

        System.out.println("Digite o limite do cartão:");
        Double limite = scNumber.nextDouble();

        Cartao cartao = new Cartao(limite);

        int op = 1;

        while (op != 0) {
            System.out.println("Digite a descrição da compra");
            String descricao = scString.nextLine();
            System.out.println("Digite o valor da compra");
            Double valor = scNumber.nextDouble();

            cartao.lancaCompra(new Produto(descricao, valor));

            System.out.println("Digite '0' para sair ou '1' para continuar");
            op = scNumber.nextInt();
        }

        cartao.getProdutos().sort(Comparator.comparing(Produto::getValor));

        System.out.println("***************************");
        System.out.println("COMPRAS REALIZADAS:\n");

        for (Produto produto : cartao.getProdutos()) {
            System.out.printf("%s - %.2f\n", produto.getDescricao(), produto.getValor());
        }

        System.out.println();
        System.out.println("***************************\n");
        System.out.println("Saldo do cartão: " + cartao.getSaldo());

    }

}
