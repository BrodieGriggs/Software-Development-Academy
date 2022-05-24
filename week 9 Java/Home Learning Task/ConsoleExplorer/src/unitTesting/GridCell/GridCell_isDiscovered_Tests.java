package unitTesting.GridCell;

import static org.junit.Assert.*;

import org.junit.Test;

import main.GridCell;

public class GridCell_isDiscovered_Tests {

	@Test
	public void isDiscoveredDefault() {
		// initialised value of discovered is false
		GridCell testCell = new GridCell("hidden");
		assertEquals(false, testCell.isDiscovered());
	}
	
	@Test
	public void isDiscoveredAltered() {
		GridCell testCell = new GridCell("hidden");
		testCell.discover();
		assertEquals(true, testCell.isDiscovered());
	}

}
