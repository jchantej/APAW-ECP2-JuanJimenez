package arquitectura.api.resources;

import java.util.List;
import java.util.Optional;

import arquitectura.api.controllers.AuthorController;
import arquitectura.api.dtos.AuthorBookListDto;
import arquitectura.api.dtos.AuthorDto;
import arquitectura.api.resources.exceptions.AuthorFieldInvalidException;
import arquitectura.api.resources.exceptions.AuthorIdNotFoundException;

public class AuthorResource {

    public static final String AUTHOR = "authors";

    public static final String ID = "/{id}";

    public static final String ID_ISBNS = ID + "/isbns";

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
        return new AuthorController().authorList();
    }

    public AuthorBookListDto authorBookIsbnList(int authorId) throws AuthorIdNotFoundException, AuthorFieldInvalidException {
        
        Optional<AuthorBookListDto> optional = new AuthorController().authorBooks(authorId);
        return optional.orElseThrow(() -> new AuthorIdNotFoundException(Integer.toString(authorId)));
    }

}
