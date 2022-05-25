package unitTesting.Map;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Map;

public class Map_isPowerUpPresent_Tests {

	@Test
	public void test() {
		Map testMap = new Map(5, 5);
		int[] testPlayerPos = {1, 1};
		testMap.populateGrid(testPlayerPos);
		
		assertEquals(true, testMap.isPowerUpPresent());
	}

}
