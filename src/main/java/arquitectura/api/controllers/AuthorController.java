package arquitectura.api.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import arquitectura.api.daos.DaoFactory;
import arquitectura.api.dtos.AuthorBookListDto;
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

    public List<AuthorDto> authorList() {
        List<AuthorDto> authorDtoList = new ArrayList<>();
        List<Author> authors = DaoFactory.getFactory().getAuthorDao().findAll();
        for (Author author : authors) {
            authorDtoList.add(new AuthorDto(author));
        }
        return authorDtoList;
    }

    public Optional<AuthorBookListDto> authorBooks(int authorId) {
        if (existAuthorId(authorId)) {
            List<Integer> isbnsList = DaoFactory.getFactory().getBookDao().findIsbnByAuthorId(authorId);
            return Optional.of(new AuthorBookListDto(DaoFactory.getFactory().getAuthorDao().read(authorId), isbnsList));
        } else {
            return Optional.empty();
        }
    }

}
