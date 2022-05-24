package unitTesting.GridCell;
import static org.junit.Assert.*;

import java.util.ArrayList;

import main.GridCell;

import org.junit.Test;

public class GridCell_Constructor_Tests {
	
	// tests for cellType assignment
	@Test
	public void cellTypeAssignment() { 
		// possible cellTypes
		ArrayList<String> cellTypes = new ArrayList<String>();
		cellTypes.add("hidden");
		cellTypes.add("border");
		cellTypes.add("nothing");
		cellTypes.add("player");
		cellTypes.add("treasure");
		cellTypes.add("powerup");
		
		// loop through possible cellTypes and test each in constructor
		for(int i = 0; i < cellTypes.size(); i++) {
			GridCell testCell = new GridCell(cellTypes.get(i));
			assertEquals(cellTypes.get(i), testCell.getCellType());
		}
	}
	
	// test that discovered initialises as false
	@Test
	public void discoveredInitialisation() {
		GridCell testCell = new GridCell("hidden");
		assertEquals(false, testCell.isDiscovered());
	}
	
}
