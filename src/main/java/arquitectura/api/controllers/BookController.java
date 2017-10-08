package arquitectura.api.controllers;


import arquitectura.api.daos.DaoFactory;
import arquitectura.api.entities.Author;
import arquitectura.api.entities.Book;

public class BookController {

    public boolean createBook(int authorId, int isbnBook, String titleBook) {
        Author author = DaoFactory.getFactory().getAuthorDao().read(authorId);
        if (author != null) {
            DaoFactory.getFactory().getBookDao().create(new Book(isbnBook, titleBook, author));
            return true;
        }else { 
            return false;
        }
    }


}
