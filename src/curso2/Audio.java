package curso2;

import java.sql.Time;

public class Audio {
    private String Titulo;
    private Time duracao;
    private int TotalReproducoes;
    private int totalCurtidas;
    private int classificacao;

    public void curte() {
        this.totalCurtidas++;
    }

    public void reproduz() {
        this.TotalReproducoes++;
    }

    public String getTitulo() {
        return Titulo;
    }

    public Time getDuracao() {
        return duracao;
    }

    public int getTotalReproducoes() {
        return TotalReproducoes;
    }

    public int getTotalCurtidas() {
        return totalCurtidas;
    }

    public int getClassificacao() {
        return classificacao;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public void setDuracao(Time duracao) {
        this.duracao = duracao;
    }
}
