package unitTesting.Map;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	Map_Constructor_Tests.class,
	Map_populateGrid_Tests.class,
	Map_getTreasureLocation_Tests.class,
	Map_isPowerUpPresent_Tests.class,
	Map_getPowerUpLocation_Tests.class,
	Map_removePowerUp_Tests.class,
	Map_getRandomEmptyCell_Tests.class,
	Map_getDimensions_Tests.class,
	Map_increaseDimensions_Tests.class,
	Map_show_Tests.class,
	Map_showIntro_Tests.class,
	Map_showPowerUp_Tests.class,
	Map_showNextLevelText_Tests.class
})
public class Map_All_Tests {

}
