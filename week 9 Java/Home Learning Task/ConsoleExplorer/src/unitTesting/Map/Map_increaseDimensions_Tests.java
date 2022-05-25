package unitTesting.Map;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Map;

public class Map_increaseDimensions_Tests {

	@Test
	public void test() {
		Map testMap = new Map(5, 5);
		
		int[] expectedDimensions = {5, 5};
		assertEquals(expectedDimensions[0], testMap.getDimensions()[0]);
		assertEquals(expectedDimensions[1], testMap.getDimensions()[1]);
		
		testMap.increaseDimensions(1, 1);
		expectedDimensions[0] = 6;
		expectedDimensions[1] = 6;
		assertEquals(expectedDimensions[0], testMap.getDimensions()[0]);
		assertEquals(expectedDimensions[1], testMap.getDimensions()[1]);
	}
}
