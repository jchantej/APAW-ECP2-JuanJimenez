package arquitectura.api.daos.memory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import arquitectura.api.daos.BookDao;
import arquitectura.api.entities.Book;


public class BookDaoMemory extends GenericDaoMemory<Book> implements BookDao {

    public BookDaoMemory() {
        this.setMap(new HashMap<Integer, Book>());
    }

    @Override
    protected Integer getId(Book entity) {
        return (int) entity.getId();
    }

    @Override
    protected void setId(Book entity, Integer id) {
        entity.setId(id);
    }

    @Override
    public List<Integer> findIsbnByAuthorId(int authorId) {
        List<Book> books = this.findAll();
        List<Integer> booksIsbn = new ArrayList<>();
        for (Book book : books) {
            if (book.getAutor().getId() == authorId) {
                booksIsbn.add((int)book.getIsbn());
            }
        }
        return booksIsbn;
    }

}
