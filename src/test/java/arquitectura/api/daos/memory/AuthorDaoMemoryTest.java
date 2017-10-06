package arquitectura.api.daos.memory;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import arquitectura.api.daos.DaoFactory;
import arquitectura.api.entities.Author;



public class AuthorDaoMemoryTest {

    private Author author;

    @Before
    public void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
        author = new Author(1,"Pablo Jimenez");
        DaoFactory.getFactory().getAuthorDao().create(author);
    }
    
    @Test
    public void testCreatedRead() {
        assertEquals("Pablo Jimenez", DaoFactory.getFactory().getAuthorDao().read(1).getName());
    }
    
    



}
