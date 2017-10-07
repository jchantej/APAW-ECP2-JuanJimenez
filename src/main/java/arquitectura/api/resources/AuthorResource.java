package arquitectura.api.resources;

import arquitectura.api.controllers.AuthorController;
import arquitectura.api.resources.exceptions.AuthorFieldInvalidException;


public class AuthorResource {

    public static final String AUTHOR = "authors";


    public void createAuthor(String authorName) throws AuthorFieldInvalidException {
        this.validateField(authorName);
        new AuthorController().createAuthor(authorName);
    }

    private void validateField(String field) throws AuthorFieldInvalidException {
        if (field == null || field.isEmpty()) {
            throw new AuthorFieldInvalidException(field);
        }
    }



}
