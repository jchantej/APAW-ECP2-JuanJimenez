package arquitectura.api.entities;

import java.util.Calendar;

public class Book {

    private long id;

    private long isbn;

    private String title;

    private Calendar date;

    private Author autor;

    public Book(long isbn, String title, Author autor) {
       
        this.isbn = isbn;
        this.title = title;
        this.autor = autor;
        this.date = Calendar.getInstance();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public Author getAutor() {
        return autor;
    }

    public void setAutor(Author autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", isbn=" + isbn + ", title=" + title + ", date=" + date + ", autor=" + autor + "]";
    }

}
