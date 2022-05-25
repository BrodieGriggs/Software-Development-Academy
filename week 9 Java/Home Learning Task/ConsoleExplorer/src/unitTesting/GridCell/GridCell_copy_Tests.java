package unitTesting.GridCell;

import static org.junit.Assert.*;

import org.junit.Test;

import main.GridCell;

public class GridCell_copy_Tests {
	@Test
	public void testCopy() {
		/* the class GridCell has only 2 variables,
		 * private String cellType
		 * private boolean discovered */
		
		GridCell testCell = new GridCell("hidden");
		assertEquals(testCell.getCellType(), testCell.copy().getCellType());
		assertEquals(testCell.isDiscovered(), false);
	}

}
