package curso4.via_cep;

public class CepNotFoundException extends RuntimeException {
    private String message = "Cep não encontrado.";

    @Override
    public String getMessage() {
        return this.message;
    }
}
