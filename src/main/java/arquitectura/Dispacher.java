package arquitectura;

import arquitectura.api.resources.AuthorResource;
import arquitectura.api.resources.BookResource;
import arquitectura.api.resources.exceptions.RequestInvalidException;
import arquitectura.http.HttpRequest;
import arquitectura.http.HttpResponse;
import arquitectura.http.HttpStatus;

public class Dispacher {

    private AuthorResource authorResource = new AuthorResource();

    private BookResource bookResource = new BookResource();

    private void responseError(HttpResponse response, Exception e) {
        response.setBody("{\"error\":\"" + e + "\"}");
        response.setStatus(HttpStatus.BAD_REQUEST);
    }

    public void doPost(HttpRequest request, HttpResponse response) {
        try {
            if (request.isEqualsPath(AuthorResource.AUTHOR)) {
                authorResource.createAuthor(request.getBody());
                response.setStatus(HttpStatus.CREATED);
            } else if (request.isEqualsPath(BookResource.BOOK)) {

                int authorId = Integer.parseInt(request.getBody().split(":")[0]);
                int isbnBook = Integer.parseInt(request.getBody().split(":")[1]);
                String titleBook = request.getBody().split(":")[2];
                bookResource.createBook(authorId, isbnBook, titleBook);
                response.setStatus(HttpStatus.CREATED);

            } else {
                throw new RequestInvalidException(request.getPath());
            }
        } catch (Exception e) {
            responseError(response, e);
        }
    }

    public void doGet(HttpRequest request, HttpResponse response) {
        try {
            if (request.isEqualsPath(AuthorResource.AUTHOR)) {
                response.setBody(authorResource.authorList().toString());
            } else if (request.isEqualsPath(AuthorResource.AUTHOR + AuthorResource.ID)) {
                int authorId = Integer.parseInt(request.paths()[1]);
                response.setBody(authorResource.readTheme(authorId).toString());
            } else if (request.isEqualsPath(AuthorResource.AUTHOR + AuthorResource.ID_ISBNS)) {
                response.setBody(authorResource.authorBookIsbnList(Integer.parseInt(request.paths()[1])).toString());
            }else if (request.isEqualsPath(BookResource.BOOK)) {
                response.setBody(bookResource.bookList().toString());
                
            } else {
                throw new RequestInvalidException(request.getPath());
            }
        } catch (Exception e) {
            responseError(response, e);
        }

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
