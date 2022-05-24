package unitTesting.Main;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	Main_showInfo_Tests.class,
	Main_getRandomIntInRange_Tests.class,
	Main_clearConsole_Tests.class,
	Main_pauseGame_Tests.class,
	Main_main_Tests.class })
public class Main_All_Tests {
	
}
