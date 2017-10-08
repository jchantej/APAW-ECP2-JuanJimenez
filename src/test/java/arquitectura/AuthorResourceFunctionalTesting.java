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

   /* @Before
    public void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
    }*/

    private void createAuthor() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path("authors").body("Pablo Jimenez").build();
        new HttpClientService().httpRequest(request);
    }

    @Test
    public void testCreateAuthor() {
        this.createAuthor();
    }

}
