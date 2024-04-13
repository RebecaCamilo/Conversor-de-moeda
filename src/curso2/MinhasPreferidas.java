package curso2;

public class MinhasPreferidas {

    public void inclui(Audio audio) {
        if (audio.getClassificacao() >= 9) {
            System.out.println(audio.getTitulo() + " é um sucesso absoluto!");
        } else {
            System.out.println(audio.getTitulo() + " é uma boa opção para escutar.");
        }
    }
}
