package arquitectura.api.entities;


import static org.junit.Assert.*;

import org.junit.Test;


public class AuthorTest {
    
    @Test
    public void testAuthorIntString() {
        Author author = new Author(1, "Pablo Jimenez");
        assertEquals(1, author.getId());
        assertEquals("Pablo Jimenez", author.getName());
        
    }
    
    @Test
    public void testNotNullAuthor() {
        assertNotNull(new Author(1, "Pablo Jimenez"));
    }

}
