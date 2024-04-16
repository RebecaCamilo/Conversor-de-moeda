package curso3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ComprasDriver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o limite do cartão:");
        Double limite = sc.nextDouble();

        Cartao cartao =  new Cartao(limite, new ArrayList<>());

        int op = 1;
        Double somaCompras = 0.0;

        while (op != 0 && somaCompras < cartao.getLimite()) {
            System.out.println("Digite a descrição da compra");
            String descricao = sc.nextLine();
            System.out.println("Digite o valor da compra");
            Double valor = sc.nextDouble();

            cartao.getProduto().add(new Produto(descricao, valor));
            somaCompras += valor;
            System.out.println("Compra realizada!");

            System.out.println("Digite '0' para sair ou '1' para continuar");
            op = sc.nextInt();
        }

    }
}
