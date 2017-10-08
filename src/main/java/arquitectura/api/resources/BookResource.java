package arquitectura.api.resources;

import java.util.List;

import arquitectura.api.controllers.AuthorController;
import arquitectura.api.resources.exceptions.AuthorFieldInvalidException;
import arquitectura.api.resources.exceptions.AuthorIdNotFoundException;
import arquitectura.api.resources.exceptions.BookFieldInvalidException;
import arquitectura.api.resources.exceptions.BookIdNotFoundException;
import arquitectura.api.resources.exceptions.RequestInvalidException;

public class BookResource {

    public static final String VOTES = "books";

    public void createVote(int authorId, int isbnBook, String titleBook)
            throws RequestInvalidException, AuthorIdNotFoundException, BookIdNotFoundException, BookFieldInvalidException {

        this.validateFields(authorId, titleBook);
        // TODO:Pendiente de Delegar el controlador
    }

    private void validateFields(int authorId, String titleBook) throws AuthorIdNotFoundException, BookFieldInvalidException {
        if (authorId < 1) {
            throw new AuthorIdNotFoundException(Integer.toString(authorId));
        }
        if (titleBook == null || titleBook.isEmpty()) {
            throw new BookFieldInvalidException(titleBook);
        }
    }

}
