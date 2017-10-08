package arquitectura.api.dtos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import arquitectura.api.entities.Author;

public class AuthorBookListDtoTest {
    
    @Test
    public void testAuthorIntString() {
        Author author = new Author("Pablo Jimenez");
        List<Integer> isbnsList = new ArrayList<>();
        isbnsList.add(123);
        isbnsList.add(124);
        
        AuthorBookListDto authorDtoList = new AuthorBookListDto(author, isbnsList);
        author.setLanguage("Español");
        assertEquals(123, authorDtoList.getIsbnList().get(0).intValue());
   
        
    }
    
    @Test
    public void testNotNullAuthor() {
        assertNotNull(new AuthorDto(new Author("Juan Jimenez")));
    }


}
