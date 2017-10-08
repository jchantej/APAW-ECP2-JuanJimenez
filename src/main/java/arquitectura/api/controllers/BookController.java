package arquitectura.api.controllers;


import java.util.ArrayList;
import java.util.List;

import arquitectura.api.daos.DaoFactory;
import arquitectura.api.dtos.BookDto;
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
    
    public List<BookDto> bookList() {
        List<BookDto> bookDtoList = new ArrayList<>();
        List<Book> books = DaoFactory.getFactory().getBookDao().findAll();
        for (Book book : books) {
            bookDtoList.add(new BookDto(book));
        }
        return bookDtoList;
    }


}
