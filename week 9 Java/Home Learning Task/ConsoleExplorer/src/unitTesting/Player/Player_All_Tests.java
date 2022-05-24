package unitTesting.Player;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	Player_Constructor_Tests.class,
	Player_getPosition_Tests.class,
	Player_updatePosition_Tests.class,
	Player_getLastMove_Tests.class,
	Player_checkCollision_Tests.class,
	Player_getViewDistance_Tests.class,
	Player_increaseViewDistance_Tests.class
})
public class Player_All_Tests {

}
