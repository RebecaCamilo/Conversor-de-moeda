package curso2;

public class MusicaDriver {
    public static void main(String[] args) {
        Musica houdini = new Musica();
        houdini.setTitulo("Houdini");
        houdini.setAlbum("Radical Optimism");
        houdini.setArtista("Dua Lipa");
        houdini.setGenero("Pop");

        Podcast flow= new Podcast();
        flow.setTitulo("Flow");
        flow.setHost("Bruno Chato Grau");
        flow.setDescricao("Chatice");

        for (int i= 0; i < 1000; i++) {
            houdini.reproduz();
        }

        for (int i= 0; i < 50; i++) {
            houdini.curte();
        }

        for (int i= 0; i < 1000; i++) {
            flow.reproduz();
        }

        for (int i= 0; i < 200; i++) {
            flow.curte();
        }

        MinhasPreferidas preferidas = new MinhasPreferidas();
        preferidas.inclui(houdini);
        preferidas.inclui(flow);
    }
}
