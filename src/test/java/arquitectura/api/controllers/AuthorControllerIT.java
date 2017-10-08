package arquitectura.api.controllers;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import arquitectura.api.daos.DaoFactory;
import arquitectura.api.daos.memory.DaoMemoryFactory;


public class AuthorControllerIT {

    private AuthorController authorController;

    @Before
    public void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
        authorController = new AuthorController();

    }

    @Test
    public void testCreatedTheme() {
        authorController.createAuthor("Pablo Jimenez");
    }

    @Test
    public void testReadAuthor() {
        authorController.createAuthor("Pablo Jimenez");
        assertEquals("Pablo Jimenez", authorController.readAuthor(1).get().getAuthorName());
    }

    @Test
    public void testAuthorList() {
        authorController.createAuthor("Pablo Jimenez");
        authorController.createAuthor("Juan Jimenez");
        assertEquals(2, authorController.authorList().size());
        assertEquals(1, authorController.authorList().get(0).getAuthorId());
        assertEquals("Pablo Jimenez", authorController.authorList().get(0).getAuthorName());
        assertEquals("Español", authorController.authorList().get(0).getAuthorLanguage());
        
        assertEquals(2, authorController.authorList().get(1).getAuthorId());
        assertEquals("Juan Jimenez", authorController.authorList().get(1).getAuthorName());
        assertEquals("Español", authorController.authorList().get(1).getAuthorLanguage());
    }

}
