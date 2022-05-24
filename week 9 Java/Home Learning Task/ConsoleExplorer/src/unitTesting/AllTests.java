package unitTesting;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import unitTesting.GridCell.GridCell_All_Tests;
import unitTesting.Main.Main_All_Tests;
import unitTesting.Map.Map_All_Tests;
import unitTesting.Player.Player_All_Tests;

@RunWith(Suite.class)
@SuiteClasses({
	GridCell_All_Tests.class,
	Main_All_Tests.class,
	Map_All_Tests.class,
	Player_All_Tests.class
})
public class AllTests {

}
