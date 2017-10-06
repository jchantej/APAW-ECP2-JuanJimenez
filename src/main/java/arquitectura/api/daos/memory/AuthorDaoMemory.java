package arquitectura.api.daos.memory;

import java.util.HashMap;

import arquitectura.api.daos.AuthorDao;
import arquitectura.api.entities.Author;


public class AuthorDaoMemory extends GenericDaoMemory<Author> implements AuthorDao {

    public AuthorDaoMemory() {
        this.setMap(new HashMap<Integer, Author>());
    }

    @Override
    protected Integer getId(Author entity)  {
        return (int) entity.getId();
    }

    @Override
    protected void setId(Author entity, Integer id) {
        entity.setId(id);

    }


}
