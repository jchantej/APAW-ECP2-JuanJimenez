package arquitectura.api.controllers;

import java.util.Optional;

import arquitectura.api.daos.DaoFactory;
import arquitectura.api.dtos.AuthorDto;
import arquitectura.api.entities.Author;

public class AuthorController {

    public void createAuthor(String authorName) {
        DaoFactory.getFactory().getAuthorDao().create(new Author(authorName));
    }

    public Optional<AuthorDto> readAuthor(int authorId) {
        if (existAuthorId(authorId)) {
            return Optional.of(new AuthorDto(DaoFactory.getFactory().getAuthorDao().read(authorId)));
        } else {
            return Optional.empty();
        }
    }

    private boolean existAuthorId(int authorId) {
        return DaoFactory.getFactory().getAuthorDao().read(authorId) != null;
    }

}
