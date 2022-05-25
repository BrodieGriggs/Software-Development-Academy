package unitTesting.Map;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Map;

public class Map_getRandomEmptyCell_Tests {

	@Test
	public void test() {
		Map testMap = new Map(5, 5);
		int[] testPlayerPos = {1, 1};
		
		testMap.populateGrid(testPlayerPos);
		int[] emptyCell = testMap.getRandomEmptyCell(testPlayerPos);
		
		// test that cell selected is actually empty
		assertEquals("   ", testMap.getGrid()[emptyCell[0]][emptyCell[1]].getCellType());
	}

}
