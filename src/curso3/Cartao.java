package curso3;

import java.util.List;

public class Cartao {
    private Double limite;
    private List<Produto> produto;

    public Cartao(Double limite, List<Produto> produto) {
        this.limite = limite;
        this.produto = produto;
    }

    public Double getLimite() {
        return limite;
    }

    public List<Produto> getProduto() {
        return produto;
    }
}
