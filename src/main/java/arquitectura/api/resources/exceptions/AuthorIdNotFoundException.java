package arquitectura.api.resources.exceptions;

public class AuthorIdNotFoundException extends Exception {
    private static final long serialVersionUID = -3893110892899234744L;

    public static final String DESCRIPTION = "El id del author no existe";

    public AuthorIdNotFoundException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

    public AuthorIdNotFoundException() {
        this("");
    }
}
