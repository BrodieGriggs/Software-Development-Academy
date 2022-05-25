package unitTesting.Map;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Map;

public class Map_removePowerUp_Tests {

	@Test
	public void variableAlterations() {
		Map testMap = new Map(5, 5);
		int[] testPlayerPosition = {1, 1};
		
		testMap.populateGrid(testPlayerPosition);
		
		int[] PULocation = testMap.getPowerUpLocation();
		
		testMap.removePowerUp();
		
		// check powerUpPresent boolean
		assertEquals(false, testMap.isPowerUpPresent());
		
		// check treasure location gridCell cellType has been set to nothing ("   ")
		assertEquals("   ", testMap.getGrid()[PULocation[0]][PULocation[1]].getCellType());
		
		// check powerUpLocation has been set to -1, -1
		int[] testPowerUpLocation = {-1, -1};
		assertEquals(testPowerUpLocation[0], testMap.getPowerUpLocation()[0]);
		assertEquals(testPowerUpLocation[1], testMap.getPowerUpLocation()[1]);
	}

}
