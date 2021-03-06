package unitTesting.Map;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

import main.Map;

public class Map_Constructor_Tests {

	@Test
	public void variableAssignment() {
		
		int testX = 5;
		int testY = 10;
		
		Map testMap = new Map(testX, testY);
		
		HashMap<String, String> cellTypes = new HashMap<String, String>();
		cellTypes.put("hidden", "███");
		cellTypes.put("border", "[X]");
		cellTypes.put("nothing", "   ");
		cellTypes.put("player", "(P)");
		cellTypes.put("treasure", "(T)");
		cellTypes.put("powerup", "(+)");
		
		// check gridWidth assignment
		assertEquals(testX, testMap.getDimensions()[0]);
		
		// check gridHeight assignment
		assertEquals(testY, testMap.getDimensions()[1]);
		
		// check each cellType value has been assigned
		for(var entry : cellTypes.entrySet()) {
			assertEquals(cellTypes.get(entry.getKey()), testMap.getCellTypes().get(entry.getKey()));
		}
	}
}
