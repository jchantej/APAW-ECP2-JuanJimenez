package arquitectura.api.daos.memory;

import arquitectura.api.daos.AuthorDao;
import arquitectura.api.daos.BookDao;
import arquitectura.api.daos.DaoFactory;

public class DaoMemoryFactory extends DaoFactory {

    private AuthorDao authorDao;

    private BookDao bookDao;

    @Override
    public  AuthorDao getAuthorDao()  {
        if (authorDao == null) {
            authorDao = new AuthorDaoMemory();
        }
        return authorDao;
    }

    @Override
    public BookDao getBookDao() {
        if (bookDao == null) {
            bookDao = new BookDaoMemory();
        }
        return bookDao;
    }


}
