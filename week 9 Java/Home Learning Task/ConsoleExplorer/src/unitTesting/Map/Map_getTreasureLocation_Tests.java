package unitTesting.Map;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Map;

public class Map_getTreasureLocation_Tests {

	@Test
	public void test_getTreasureLocation() {
		Map testMap = new Map(5, 5);
		int[] testPlayerPos = {1, 1};
		int[] testTreasureLocation = {3, 3};
		
		testMap.populateGrid(testPlayerPos);
		
		testMap.setTreasureLocation(testTreasureLocation);
		
		assertEquals(testTreasureLocation[0], testMap.getTreasureLocation()[0]);
		assertEquals(testTreasureLocation[1], testMap.getTreasureLocation()[1]);
	}

}
