package unitTesting.Map;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

import main.Map;

public class Map_getCellTypes_Tests {

	@Test
	public void test() {
		
		// the following values are initialised by default in the Map constructor:
		HashMap<String, String> cellTypes = new HashMap<String, String>();
		cellTypes.put("hidden", "███");
		cellTypes.put("border", "[X]");
		cellTypes.put("nothing", "   ");
		cellTypes.put("player", "(P)");
		cellTypes.put("treasure", "(T)");
		cellTypes.put("powerup", "(+)");

		Map testMap = new Map(5, 5);
		
		// check getter gets correct value
		for(var entry : cellTypes.entrySet()) {
			assertEquals(cellTypes.get(entry.getKey()), testMap.getCellTypes().get(entry.getKey()));
		}
	}

}
