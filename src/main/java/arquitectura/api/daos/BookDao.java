package arquitectura.api.daos;

import java.util.List;
import arquitectura.api.entities.Book;

public interface BookDao extends GenericDao<Book, Integer> {

    List<Integer> findIsbnByAuthorId(int authorId);
}
