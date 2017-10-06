package arquitectura.api.resources;

import java.util.List;
import java.util.Optional;

import arquitectura.api.resources.exceptions.AuthorFieldInvalidException;


public class AuthorResource {

    public static final String AUTHOR = "authors";


    public void createAuthor(String authorName) throws AuthorFieldInvalidException {
        this.validateField(authorName);
        // TODO: llamar al controlador para que cree el tema
    }

    private void validateField(String field) throws AuthorFieldInvalidException {
        if (field == null || field.isEmpty()) {
            throw new AuthorFieldInvalidException(field);
        }
    }



}
