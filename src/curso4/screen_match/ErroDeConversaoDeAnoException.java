package curso4.screen_match;

public class ErroDeConversaoDeAnoException extends RuntimeException {
    private String mensagem;

    public ErroDeConversaoDeAnoException(String s) {
        this.mensagem = s;
    }

    @Override
    public String getMessage() {
        return this.mensagem;
    }
}
