package unitTesting.GridCell;

import static org.junit.Assert.*;

import org.junit.Test;

import main.GridCell;

public class GridCell_getCellType_Tests {
	
	@Test
	public void test_getCellType() {
		GridCell testCell = new GridCell("hidden");
		assertEquals("hidden", testCell.getCellType());
	}

}
