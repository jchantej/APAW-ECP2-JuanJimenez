package arquitectura.api.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class BookTest {
    
    Author author = new Author("Pablo Jimenez");
    Book book =  new Book(123, author);
    
    @Test
    public void testBookIntString() {
        assertEquals("Pablo Jimenez", book.getAutor().getName());
        assertEquals(123, book.getIsbn());
        
    }
    
    @Test
    public void testBookGetDateNotNull() {
        assertNotNull(book.getDate());
    }


}
