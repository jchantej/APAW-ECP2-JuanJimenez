package arquitectura.api.dtos;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
    AuthorDtoTest.class,
    AuthorBookListDtoTest.class,
    BookDtoTest.class
})
public class AllApiDtosTests {

}
