package arquitectura.api.dtos;

import static org.junit.Assert.assertEquals;


import org.junit.Test;

import arquitectura.api.entities.Author;
import arquitectura.api.entities.Book;

public class BookDtoTest {
    
    @Test
    public void testBookIntString() {
        Author author = new Author("Pablo Jimenez");
        Book book = new Book(123,"Java",author);
        BookDto bookDto = new BookDto(book);
       assertEquals(123, bookDto.getBookIsbn());
       assertEquals("Java", bookDto.getBookTitle());
       assertEquals("Pablo Jimenez", bookDto.getAuthor().getName());
        
    }
    



}
