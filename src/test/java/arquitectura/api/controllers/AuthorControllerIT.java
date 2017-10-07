package arquitectura.api.controllers;

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


}
