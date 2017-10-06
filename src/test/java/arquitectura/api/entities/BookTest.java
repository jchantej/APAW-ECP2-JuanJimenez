package arquitectura.api.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class BookTest {
    
    Author author = new Author(1, "Pablo Jimenez");
    Book book =  new Book(1, author);
    
    @Test
    public void testBookIntString() {

        assertEquals(1, author.getId());
        assertEquals("Pablo Jimenez", book.getAutor().getName());
        
    }
    
    @Test
    public void testBookGetDateNotNull() {
        assertNotNull(book.getDate());
    }


}
