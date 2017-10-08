package arquitectura.api.dtos;

import java.util.Calendar;

import arquitectura.api.entities.Author;
import arquitectura.api.entities.Book;

public class BookDto {

    private long bookId;

    private long bookIsbn;

    private String bookTitle;

    private Calendar bookDate;
    
    private Author author;


    public BookDto(Book book) {
     
        this.bookId = book.getId();
        this.bookIsbn = book.getIsbn();
        this.bookTitle = book.getTitle();
        this.bookDate = Calendar.getInstance();
        this.author = book.getAutor();
    }


    public long getBookId() {
        return bookId;
    }


    public void setBookId(long bookId) {
        this.bookId = bookId;
    }


    public long getBookIsbn() {
        return bookIsbn;
    }


    public void setBookIsbn(long bookIsbn) {
        this.bookIsbn = bookIsbn;
    }


    public String getBookTitle() {
        return bookTitle;
    }


    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }


    public Calendar getBookDate() {
        return bookDate;
    }


    public void setBookDate(Calendar bookDate) {
        this.bookDate = bookDate;
    }
    
    


    public Author getAuthor() {
        return author;
    }


    public void setAuthor(Author author) {
        this.author = author;
    }


    @Override
    public String toString() {
       // return "BookDto [bookId=" + bookId + ", bookIsbn=" + bookIsbn + ", bookTitle=" + bookTitle + "]";
        return "{\"id\":" + bookId + ",\"isbn\":\"" + bookIsbn + ",\"title\":\"" + bookTitle + "\"}";
    }



}
