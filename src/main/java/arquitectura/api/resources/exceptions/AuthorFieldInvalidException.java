package arquitectura.api.resources.exceptions;

public class AuthorFieldInvalidException extends Exception {
    private static final long serialVersionUID = -642045799876625537L;

    public static final String DESCRIPTION = "Nombre del author no encontrado";

    public AuthorFieldInvalidException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

    public AuthorFieldInvalidException() {
        this("");
    }

}
