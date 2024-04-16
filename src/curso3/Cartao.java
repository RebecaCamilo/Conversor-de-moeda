package curso3;

import java.util.ArrayList;
import java.util.List;

public class Cartao {
    private Double limite;
    private Double saldo;
    private List<Produto> produtos;

    public Cartao(Double limite) {
        this.limite = limite;
        this.saldo = 0.0;
        this.produtos = new ArrayList<>();
    }

    public Double getSaldo() {
        return saldo;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void lancaCompra(Produto produto) {
        if ((this.saldo + produto.getValor()) <= this.limite) {
            this.produtos.add(produto);
            this.saldo += produto.getValor();
            System.out.println("Compra realizada!");
            return;
        }
        System.out.println("Saldo insuficiente!");

        if (this.saldo.equals(this.limite)) {
            System.out.println("Você não tem mais como gastar nesse cartão este mês.");
            return;
        }
        System.out.println("Você só tem mais R$ " + (this.limite - this.saldo) + " para gastar.");
    }
}
