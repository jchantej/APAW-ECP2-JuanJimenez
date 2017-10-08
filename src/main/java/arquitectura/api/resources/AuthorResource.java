package arquitectura.api.resources;

import java.util.List;
import java.util.Optional;

import arquitectura.api.controllers.AuthorController;
import arquitectura.api.dtos.AuthorDto;
import arquitectura.api.resources.exceptions.AuthorFieldInvalidException;
import arquitectura.api.resources.exceptions.AuthorIdNotFoundException;

public class AuthorResource {

    public static final String AUTHOR = "authors";

    public static final String ID = "/{id}";

    public void createAuthor(String authorName) throws AuthorFieldInvalidException {
        this.validateField(authorName);
        new AuthorController().createAuthor(authorName);
    }

    public AuthorDto readTheme(int authorId) throws AuthorFieldInvalidException, AuthorIdNotFoundException {
        Optional<AuthorDto> optional = new AuthorController().readAuthor(authorId);
        return optional.orElseThrow(() -> new AuthorIdNotFoundException(Integer.toString(authorId)));
    }

    private void validateField(String field) throws AuthorFieldInvalidException {
        if (field == null || field.isEmpty()) {
            throw new AuthorFieldInvalidException(field);
        }
    }

    public List<AuthorDto> authorList() {
        
        //TODO: pendiente de delegar controlador

      return null;
    }

}
