package curso3;

public class Produto {
    private String descricao;
    private Double valor;

    public Produto(String descricao, Double valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public Double getValor() {
        return valor;
    }
}
