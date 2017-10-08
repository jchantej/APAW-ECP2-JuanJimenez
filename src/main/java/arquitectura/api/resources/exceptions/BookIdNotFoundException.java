package arquitectura.api.resources.exceptions;

public class BookIdNotFoundException extends Exception {
    private static final long serialVersionUID = -3893110892899234744L;

    public static final String DESCRIPTION = "El isbn debe ser un entero";

    public BookIdNotFoundException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

    public BookIdNotFoundException() {
        this("");
    }
}
