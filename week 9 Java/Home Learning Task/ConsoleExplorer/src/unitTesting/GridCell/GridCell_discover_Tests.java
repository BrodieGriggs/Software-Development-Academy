package unitTesting.GridCell;

import static org.junit.Assert.*;

import org.junit.Test;

import main.GridCell;

public class GridCell_discover_Tests {

	@Test
	public void testDiscover() {
		GridCell testCell = new GridCell("hidden");
		testCell.discover(); // discover sets the value of discovered to true
		assertEquals(true, testCell.isDiscovered());
	}

}
