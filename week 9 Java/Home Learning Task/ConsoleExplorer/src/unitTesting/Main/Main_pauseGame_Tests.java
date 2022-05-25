package unitTesting.Main;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Main;

public class Main_pauseGame_Tests {

	@Test
	public void test() {
		
		// record start time
		long startTime = System.currentTimeMillis();
		
		int pauseDuration = 1;
		Main.pauseGame(pauseDuration);
		
		long expectedEndTime = startTime + (pauseDuration * 1000);
		
		// check expected end time is within 2ms of our estimate
		assertEquals(expectedEndTime, System.currentTimeMillis(), 2);
	}

}
