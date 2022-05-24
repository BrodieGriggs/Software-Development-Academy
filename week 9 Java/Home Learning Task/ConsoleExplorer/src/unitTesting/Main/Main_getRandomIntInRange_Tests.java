package unitTesting.Main;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Main;

public class Main_getRandomIntInRange_Tests {

	@Test
	public void test_getRandomIntInRange() {
		for(int i = 0; i < 1000; i++) {
			assertTrue("Random int was greater than the max (20)", Main.getRandomIntInRange(1, 20) <= 20);
			assertTrue("Random int was less than the min (1)", Main.getRandomIntInRange(1, 20) >= 1);
		}
	}

}
