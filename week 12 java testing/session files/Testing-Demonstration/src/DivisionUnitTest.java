import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DivisionUnitTest {
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
		float answer = calc.divide(4, 6);
		assertEquals("Expected 0.66666666666 but got something else", 0.66666666666, answer, 0.0000001);
	}
	@Test
	public void test2() {
		float answer = calc.divide(190, 10);
		assertEquals("Expected 19 but got something else", 19, answer, 0.0000001);
	}
	@Test
	public void test3() {
		float answer = calc.divide(0, 0);
		assertEquals("Expected 0 but got something else", 0, answer, 0.0000001);
	}
	@Test
	public void test4() {
		float answer = calc.divide(4000, 6000);
		assertEquals("Expected 0.66666666666 but got something else", 0.66666666666, answer, 0.0000001);
	}
}