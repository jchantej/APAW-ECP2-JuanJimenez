package arquitectura;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import arquitectura.http.HttpClientService;
import arquitectura.http.HttpException;
import arquitectura.http.HttpMethod;
import arquitectura.http.HttpRequest;
import arquitectura.http.HttpRequestBuilder;


public class AuthorResourceFunctionalTesting {

  /*  @Before
    public void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
    }*/

    public static final String AUTHOR = "author";
    
    private void createTheme() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(AUTHOR).body("Pablo Jimenez").build();
        new HttpClientService().httpRequest(request);
    }

    @Test
    public void testCreateTheme() {
        this.createTheme();
    }

    @Test //TODO: Pediente de implementar las excepciones 
    public void testCreateAuthorNameEmpty() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(AUTHOR).body("").build();
        new HttpClientService().httpRequest(request);
    }

  @Test ////TODO: Pediente de implementar las excepciones 
    public void testCreateWithoutAuthorName() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(AUTHOR).build();
        new HttpClientService().httpRequest(request);
    }

   
}
