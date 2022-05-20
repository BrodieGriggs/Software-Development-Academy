import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SubtractionUnitTest {
	// initialise class to be tested
	public static Calculator calc;
	
	@BeforeClass // runs before everything
	public static void setUpBeforeClass() {
		calc = new Calculator();
	}
	
	@AfterClass // runs after everything
	public static void tearDownAfterClass() {}
	
	@Before // runs before each test
	public void setUp() {}
	
	@After // runs after each test
	public void close() {}
	
	@Test
	public void test1() {
		int answer = calc.subtract(4, 6);
		assertEquals("Expected -2 but got something else", -2, answer);
	}
	@Test
	public void test2() {
		int answer = calc.subtract(190, 10);
		assertEquals("Expected 180 but got something else", 180, answer);
	}
	@Test
	public void test3() {
		int answer = calc.subtract(0, 0);
		assertEquals("Expected 0 but got something else", 0, answer);
	}
	@Test
	public void test4() {
		int answer = calc.subtract(4000, 6000);
		assertEquals("Expected -2000 but got something else", -2000, answer);
	}
}