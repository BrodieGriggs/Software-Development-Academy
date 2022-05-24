package unitTesting.GridCell;

import static org.junit.Assert.*;

import org.junit.Test;

import main.GridCell;

public class GridCell_hide_Tests {

	@Test
	public void testHide() {
		// discovered initialised as false
		GridCell testCell = new GridCell("hidden");
		assertEquals(false, testCell.isDiscovered());
		
		// use discover to change to true
		testCell.discover();
		assertEquals(true, testCell.isDiscovered());
		
		// use hide() to change to false
		testCell.hide();
		assertEquals(false, testCell.isDiscovered());
	}

}
