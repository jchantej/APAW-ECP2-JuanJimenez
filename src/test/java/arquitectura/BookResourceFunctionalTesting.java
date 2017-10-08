package arquitectura;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import arquitectura.api.daos.DaoFactory;
import arquitectura.api.daos.memory.DaoMemoryFactory;
import arquitectura.api.resources.AuthorResource;
import arquitectura.api.resources.BookResource;
import arquitectura.http.HttpClientService;
import arquitectura.http.HttpException;
import arquitectura.http.HttpMethod;
import arquitectura.http.HttpRequest;
import arquitectura.http.HttpRequestBuilder;

public class BookResourceFunctionalTesting {
    
    private String jsonEsperado = "[{\"id\":1,\"isbn\":\"123,\"title\":\"Java\"}, {\"id\":2,\"isbn\":\"124,\"title\":\"Python\"}]";

    @Before
    public void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
    }

    private void createAuthor() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(AuthorResource.AUTHOR).body("Pablo Jimenez").build();
        new HttpClientService().httpRequest(request);
    }

    private void createBook() {
        this.createAuthor();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(BookResource.BOOK).body("1:123:Programacion").build();
        new HttpClientService().httpRequest(request);
    }

    @Test
    public void testCreateBook() {
        this.createBook();
    }

    @Test(expected = HttpException.class)
    public void testCreateBookTitleEmpty() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(BookResource.BOOK).body("").build();
        new HttpClientService().httpRequest(request);
    }

    @Test(expected = HttpException.class)
    public void testCreateWithoutBookTitle() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(BookResource.BOOK).build();
        new HttpClientService().httpRequest(request);
    }

    @Test(expected = HttpException.class)
    public void testBookIsbnNotParserToInt() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(BookResource.BOOK).body("1:TTTT:Base de datos").build();
        new HttpClientService().httpRequest(request);
    }

    @Test(expected = HttpException.class)
    public void testCreateBookIdAuthorNotFoundException() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(BookResource.BOOK).body("2:TTTT:Base de datos").build();
        new HttpClientService().httpRequest(request);
    }
    
    @Test
    public void testBookList() { 
        this.createAuthor();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(BookResource.BOOK).body("1:123:Java").build();
        new HttpClientService().httpRequest(request);
        request = new HttpRequestBuilder().method(HttpMethod.POST).path(BookResource.BOOK).body("1:124:Python").build();
        new HttpClientService().httpRequest(request);
        
        request = new HttpRequestBuilder().method(HttpMethod.GET).path(BookResource.BOOK).build();

        
        assertEquals(jsonEsperado, new HttpClientService().httpRequest(request).getBody());
     
    }

}
