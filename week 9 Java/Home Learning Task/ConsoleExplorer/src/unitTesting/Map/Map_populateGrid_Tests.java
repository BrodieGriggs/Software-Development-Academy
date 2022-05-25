package unitTesting.Map;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Map;

public class Map_populateGrid_Tests {

	@Test
	public void validatingAlteredVariables() {
		
		int testWidth = 5;
		int testHeight = 5;
		int[] testDimensions = {testWidth, testHeight};
		int[] testPlayerPos = {1,1};
		
		Map testMap = new Map(testWidth, testHeight);
		
		testMap.populateGrid(testPlayerPos);
		
		// check treasure has been placed correctly in grid
		assertTrue(
				testMap.getTreasureLocation()[0] > 0
				&& testMap.getTreasureLocation()[0] < testWidth - 1
				&& testMap.getTreasureLocation()[1] > 0
				&& testMap.getTreasureLocation()[1] < testHeight - 1
		);
		
		// check powerup has been placed correctly in grid
		if(testMap.isPowerUpPresent()) {
			assertTrue(
					testMap.getPowerUpLocation()[0] > 0
					&& testMap.getPowerUpLocation()[0] < testWidth - 1
					&& testMap.getPowerUpLocation()[1] > 0
					&& testMap.getPowerUpLocation()[1] < testHeight - 1
			);
		}
	}

}
