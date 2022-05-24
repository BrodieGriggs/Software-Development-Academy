package unitTesting.GridCell;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	GridCell_Constructor_Tests.class,
	GridCell_getCellType_Tests.class,
	GridCell_setCellType_Tests.class,
	GridCell_isDiscovered_Tests.class,
	GridCell_discover_Tests.class,
	GridCell_hide_Tests.class,
	GridCell_copy_Tests.class })
public class GridCell_All_Tests {
	
}
