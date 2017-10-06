package arquitectura;

import arquitectura.http.HttpRequest;
import arquitectura.http.HttpResponse;
import arquitectura.http.HttpStatus;


public class Dispacher {
    
    public static final String AUTHOR = "author";
    
    private void responseError(HttpResponse response, Exception e) {
        response.setBody("{\"error\":\"" + e + "\"}");
        response.setStatus(HttpStatus.BAD_REQUEST);
    }
    
    
    public void doPost(HttpRequest request, HttpResponse response) {
        try {
            if (request.isEqualsPath(AUTHOR)) {
            //Todo : pasar la informacion del recurso para crear el author
            
            } else {
               // throw new RequestInvalidException(request.getPath());
            }
        } catch (Exception e) {
            responseError(response, e);
        }
    }
    
    public void doGet(HttpRequest request, HttpResponse response) {
        // TODO Auto-generated method stub
        
    }

    public void doPut(HttpRequest request, HttpResponse response) {
        // TODO Auto-generated method stub
        
    }

    public void doPatch(HttpRequest request, HttpResponse response) {
        // TODO Auto-generated method stub
        
    }

    public void doDelete(HttpRequest request, HttpResponse response) {
        // TODO Auto-generated method stub
        
    }


}
