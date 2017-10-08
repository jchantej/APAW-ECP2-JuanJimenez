package arquitectura;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import arquitectura.api.daos.DaoFactory;
import arquitectura.api.daos.memory.DaoMemoryFactory;
import arquitectura.api.resources.AuthorResource;
import arquitectura.http.HttpClientService;
import arquitectura.http.HttpException;
import arquitectura.http.HttpMethod;
import arquitectura.http.HttpRequest;
import arquitectura.http.HttpRequestBuilder;

public class AuthorResourceFunctionalTesting {

    private String jsonEsperado = "[{\"id\":1,\"name\":\"Pablo Jimenez,\"language\":\"Español\"}, {\"id\":2,\"name\":\"Juan Jimenez,\"language\":\"Español\"}]";

    @Before
    public void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
    }

    private void createAuthor() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(AuthorResource.AUTHOR).body("Pablo Jimenez").build();
        new HttpClientService().httpRequest(request);
    }

    @Test
    public void testCreateAuthor() {
        this.createAuthor();
    }

    @Test(expected = HttpException.class)
    public void testCreateAuthorNameEmpty() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(AuthorResource.AUTHOR).body("").build();
        new HttpClientService().httpRequest(request);
    }

    @Test(expected = HttpException.class)
    public void testCreateWithoutAuthorName() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(AuthorResource.AUTHOR).build();
        new HttpClientService().httpRequest(request);
    }

    @Test
    public void testReadAuthor() {
        this.createAuthor();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.GET).path(AuthorResource.AUTHOR).path(AuthorResource.ID)
                .expandPath("1").build();
        System.out.println(request.getPath());
        assertEquals("{\"id\":1,\"name\":\"Pablo Jimenez,\"language\":\"Español\"}",
                new HttpClientService().httpRequest(request).getBody());

    }

    @Test(expected = HttpException.class)
    public void testAuthorIdNotFound() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.GET).path(AuthorResource.AUTHOR).path(AuthorResource.ID)
                .expandPath("2").build();
        new HttpClientService().httpRequest(request);
    }

    @Test(expected = HttpException.class)
    public void testAuthorIdNotParserToInt() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.GET).path(AuthorResource.AUTHOR).path(AuthorResource.ID)
                .expandPath("P").build();
        new HttpClientService().httpRequest(request);
    }

    @Test
    public void testAuthorList() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(AuthorResource.AUTHOR).body("Pablo Jimenez").build();
        new HttpClientService().httpRequest(request);
        request = new HttpRequestBuilder().method(HttpMethod.POST).path(AuthorResource.AUTHOR).body("Juan Jimenez").build();
        new HttpClientService().httpRequest(request);

        request = new HttpRequestBuilder().method(HttpMethod.GET).path(AuthorResource.AUTHOR).build();

        assertEquals(jsonEsperado, jsonEsperado);
     

    }

}
