package arquitectura.api.controllers;

import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import arquitectura.api.daos.DaoFactory;
import arquitectura.api.daos.memory.DaoMemoryFactory;

public class BookControllerIT {

    private BookController bookController;

    @Before
    public void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
        bookController = new BookController();
    }

    @Test
    public void testCreateVoteAndVoteList() {
        new AuthorController().createAuthor("Pablo Jiemenez");
        bookController.createBook(1, 123, "Programacion");

    }

    @Test
    public void testCreateVoteNonExistentId() {
        new AuthorController().createAuthor("Pablo Jiemenez"); 
        assertFalse (bookController.createBook(2, 123, "Programacion"));
    }

}
