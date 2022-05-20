import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AdditionUnitTest.class, SubtractionUnitTest.class, MultiplicationUnitTest.class, DivisionUnitTest.class })
public class AllTests {

}
