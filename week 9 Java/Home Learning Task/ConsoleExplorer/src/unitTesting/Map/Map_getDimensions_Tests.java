package unitTesting.Map;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Map;

public class Map_getDimensions_Tests {

	@Test
	public void test() {
		Map testMap = new Map(5, 5);
		int[] testPlayerPos = {1, 1};
		
		testMap.populateGrid(testPlayerPos);
		
		int[] expectedDimensions = {5, 5};
		
		assertEquals(expectedDimensions[0], testMap.getDimensions()[0]);
		assertEquals(expectedDimensions[1], testMap.getDimensions()[1]);
	}

}
