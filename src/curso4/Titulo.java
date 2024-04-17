package curso4;

import com.google.gson.annotations.SerializedName;

public class Titulo {

//    @SerializedName("Title")
    private String nome;
//    @SerializedName("Year")
    private int anoDeLancamento;
    private int duracao;

    public Titulo() {
    }

    public Titulo(TituloOmdb tituloOmdb) {
        this.nome = tituloOmdb.title();
        this.anoDeLancamento = Integer.valueOf(tituloOmdb.year());
        this.duracao = Integer.valueOf(tituloOmdb.runtime().substring(0, tituloOmdb.runtime().indexOf(" ")));
    }

    public Titulo(String nome, int anoDeLancamento, int duracao) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
        this.duracao = duracao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    @Override
    public String toString() {
        return "Nome='" + nome + '\'' +
                ", anoDeLancamento='" + anoDeLancamento + '\'' +
                ", duração='" + duracao + "'";
    }
}
