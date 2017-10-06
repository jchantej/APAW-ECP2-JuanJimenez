package arquitectura.api.daos.memory;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import arquitectura.api.daos.DaoFactory;
import arquitectura.api.entities.Author;
import arquitectura.api.entities.Book;


public class BookDaoMemoryTest {

    private Author author;

    private Book book;

    @Before
    public void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
        author = new Author(1,"Pablo Jimenez");
        book = new Book(3, author);
        book.setIsbn(3);
        DaoFactory.getFactory().getBookDao().create(book);

    }


    @Test
    public void testCreatedRead() {
        assertEquals(3, DaoFactory.getFactory().getBookDao().read((int)book.getId()).getIsbn());
    }

}
