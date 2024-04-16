package curso3;

import java.util.List;

public class Cartao {
    private Double limite;
    private List<Produto> produtos;

    public Cartao(Double limite, List<Produto> produto) {
        this.limite = limite;
        this.produtos = produto;
    }

    public Double getLimite() {
        return limite;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
}
