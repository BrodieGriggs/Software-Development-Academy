package unitTesting.Map;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Map;

public class Map_getPowerUpLocation_Tests {

	@Test
	public void test_getPowerUpLocation() {
		Map testMap = new Map(5, 5);
		int[] testPlayerPos = {1, 1};
		int[] testPowerUpLocation = {3, 3};
		
		testMap.populateGrid(testPlayerPos);
		
		testMap.setPowerUpLocation(testPowerUpLocation);
		
		assertEquals(testPowerUpLocation[0], testMap.getPowerUpLocation()[0]);
		assertEquals(testPowerUpLocation[1], testMap.getPowerUpLocation()[1]);
	}

}
