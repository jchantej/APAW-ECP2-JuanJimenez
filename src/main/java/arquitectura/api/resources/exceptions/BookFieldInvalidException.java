package arquitectura.api.resources.exceptions;

public class BookFieldInvalidException extends Exception {
    private static final long serialVersionUID = -642045799876625537L;

    public static final String DESCRIPTION = "Nombre del Libro no encontrado";

    public BookFieldInvalidException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

    public BookFieldInvalidException() {
        this("");
    }

}
