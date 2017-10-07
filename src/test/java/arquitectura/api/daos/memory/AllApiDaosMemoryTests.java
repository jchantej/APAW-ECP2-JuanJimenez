package arquitectura.api.daos.memory;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
    AuthorDaoMemoryTest.class,
    BookDaoMemoryTest.class
})
public class AllApiDaosMemoryTests {

}
