package arquitectura.api.resources;

import arquitectura.api.controllers.BookController;
import arquitectura.api.resources.exceptions.AuthorIdNotFoundException;
import arquitectura.api.resources.exceptions.BookFieldInvalidException;
import arquitectura.api.resources.exceptions.BookIdNotFoundException;
import arquitectura.api.resources.exceptions.RequestInvalidException;

public class BookResource {

    public static final String BOOK = "books";

    public void createBook(int authorId, int isbnBook, String titleBook)
            throws RequestInvalidException, AuthorIdNotFoundException, BookIdNotFoundException, BookFieldInvalidException {

        this.validateFields(authorId, titleBook);
        
        if (!new BookController().createBook(authorId, isbnBook, titleBook)) {
            throw new AuthorIdNotFoundException(Integer.toString(authorId));
        }
        
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
