package desafio.exception;

public class InvalidJsonException extends RuntimeException {
    private String message = "Algo inesperado aconteceu ao consultar nossa API externa";

    @Override
    public String getMessage() {
        return this.message;
    }
}
