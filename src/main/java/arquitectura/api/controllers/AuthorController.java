package arquitectura.api.controllers;


import arquitectura.api.daos.DaoFactory;
import arquitectura.api.entities.Author;


public class AuthorController {

    public void createAuthor(String authorName) {
        DaoFactory.getFactory().getAuthorDao().create(new Author(authorName));
    }


}
