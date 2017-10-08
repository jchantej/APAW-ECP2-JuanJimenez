package arquitectura.api.resources;

import javax.swing.text.html.parser.DTD;

import arquitectura.api.controllers.AuthorController;
import arquitectura.api.dtos.AuthorDto;
import arquitectura.api.entities.Author;
import arquitectura.api.resources.exceptions.AuthorFieldInvalidException;
import arquitectura.api.resources.exceptions.AuthorIdNotFoundException;



public class AuthorResource {

    public static final String AUTHOR = "authors";
    public static final String ID = "/{id}";


    public void createAuthor(String authorName) throws AuthorFieldInvalidException {
        this.validateField(authorName);
        new AuthorController().createAuthor(authorName);
    }
    
    public String readTheme(int authorId) throws AuthorFieldInvalidException, AuthorIdNotFoundException {
        if(authorId!=1) {
            throw new AuthorIdNotFoundException();

        }
        AuthorDto dtoTemp =  new AuthorDto(new Author("Pablo Jimenez")); //TODO pendiene de integrgar con el contralador
        dtoTemp.setAuthorLanguage("Español");
        return dtoTemp.toString();
    }

    private void validateField(String field) throws AuthorFieldInvalidException {
        if (field == null || field.isEmpty()) {
            throw new AuthorFieldInvalidException(field);
        }
    }



}
