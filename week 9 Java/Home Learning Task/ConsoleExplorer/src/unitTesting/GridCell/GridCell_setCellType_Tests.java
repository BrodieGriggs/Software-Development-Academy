package unitTesting.GridCell;

import static org.junit.Assert.*;

import org.junit.Test;

import main.GridCell;

public class GridCell_setCellType_Tests {

	@Test
	public void test_setCellType() {
		GridCell testCell = new GridCell("hidden");
		testCell.setCellType("border");
		assertEquals("border", testCell.getCellType());
	}

}
