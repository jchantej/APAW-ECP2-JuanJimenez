package arquitectura;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
    AuthorResourceFunctionalTesting.class, 
    BookResourceFunctionalTesting.class

})
public class AllAuthorFunctionalTestings {

}
