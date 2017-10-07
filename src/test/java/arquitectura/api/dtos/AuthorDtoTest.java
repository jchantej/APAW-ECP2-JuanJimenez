package arquitectura.api.dtos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import arquitectura.api.entities.Author;

public class AuthorDtoTest {
    
    @Test
    public void testAuthorIntString() {
        Author author = new Author("Pablo Jimenez");
        AuthorDto authorDto = new AuthorDto(author);
        authorDto.setLanguage("Español");
        assertEquals("Pablo Jimenez", authorDto.getName());
        assertEquals("Español", authorDto.getLanguage());
        
    }
    
    @Test
    public void testNotNullAuthor() {
        assertNotNull(new AuthorDto(new Author("Juan Jimenez")));
    }


}